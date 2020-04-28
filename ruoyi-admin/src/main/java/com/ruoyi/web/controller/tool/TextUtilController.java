package com.ruoyi.web.controller.tool;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.LdhWebCount;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.tool.domain.YmlModel;


/**
 * 文本工具controller
 * @author Li Dehuan
 * @date 2019年12月5日
 *
 */
@Controller
@RequestMapping("/tool/textutil")
public class TextUtilController {

	private String prefix = "tool/textutil";
	
	
	/**
	 * property - yml 转换工具主页
	 * @return
	 */
	//@RequiresPermissions("tool:build:view")
	@LdhWebCount(apiName="property-yml 转换工具主页")
	@GetMapping("propYml")
	public String propYmlIndex() {
		return prefix + "/propOrYml";
	}
	
	
	
	/**
	 * property-yml获得结果
	 * @param sql
	 * @param params
	 * @return
	 */
	@PostMapping("/getPropYmlResult")
	@ResponseBody
	public AjaxResult getPropYmlResult(String content, String params, int nullFlag){
		
		
		AjaxResult ajaxResult = AjaxResult.success();
		
		return ajaxResult;
	}
	
	
	
	private String propToYml(String prop){
		StringBuilder yml = new StringBuilder();
		
		String[] lines = prop.split(System.lineSeparator());
		
		List<YmlModel> list = new ArrayList<YmlModel>();
		
		String desc = null;
		for(String line : lines){
			
			//判断是否注释
			if(line.charAt(0) == '#'){
				desc = line;
				continue;
			}
			
			String[] names = line.split("[.]");
			
			if(names == null || names.length == 0) continue;
			
			boolean isExist = false;
			
			for(YmlModel ym : list){
				// 存在同名属性名称
				if((names[0] + ":").equals(ym.getProperty())){
					isExist = true;
					proToYmlModel(ym, names, 1, desc);
					break;
				}
			}
			
			// 不存在
			if(!isExist){
				YmlModel cym = new YmlModel();
				cym.setProperty(names[0] + ":");
				list.add(cym);
				proToYmlModel(cym, names, 1, desc);
			}
			
		}
		
		writeYml(list, yml, "");
		
		return yml.toString();
	}
	
	
	private void proToYmlModel(YmlModel ym, String[] names, int level, String desc){

		String name = names[level];
		
		if(name == null) return;

		List<YmlModel> cyms = ym.getChildNodes();
		
		if(cyms == null) cyms = new ArrayList<YmlModel>();
		
		int eqIndex = name.indexOf("=");
		if(eqIndex < 0){
			boolean isExist = false;
			for(YmlModel cym : cyms){
				
				if((name + ":").equals(cym.getProperty())){
					isExist = true;
					proToYmlModel(cym, names, level + 1, desc);
					break;
				}
			}
			
			if(!isExist){
				YmlModel cym = new YmlModel();
				cym.setProperty(name + ":");
				cyms.add(cym);
				proToYmlModel(cym, names, level + 1, desc);
			}
			
		}else{
			YmlModel cym = new YmlModel();
			cym.setProperty(name.substring(0, eqIndex).trim() + ": " + name.substring(eqIndex + 1).trim());
			cym.setDesc(desc);
			cyms.add(cym);
		}
		
		ym.setChildNodes(cyms);
		
	}
	
	
	private void writeYml(List<YmlModel> yms, StringBuilder sb, String tab){
		
		if(yms == null) return;
		
		for(YmlModel ym : yms){
			if(StringUtils.isNotEmpty(ym.getDesc())) sb.append(tab + ym.getDesc() + System.lineSeparator());
			sb.append(tab + ym.getProperty() + System.lineSeparator());
			writeYml(ym.getChildNodes(), sb, tab + "  ");
		}
	}
	
	
	public static void main(String[] args) {
		
		TextUtilController t = new TextUtilController();
		
		String prop = "#设置Tomcat端口，默认8080\r\n"+ 
					"server.port=23331\r\n"+ 
				"#设置项目ContextPath\r\n"+ 
				"server.context-path=/express\r\n"+ 
				"#设置Tomcat编码\r\n"+ 
				"server.tomcat.uri-encoding=UTF-8\r\n"+ 
				"#设置视图解析器路径\n"+ 
				"spring.mvc.view.prefix=/WEB-INF/page/\r\n"+ 
				"#设置视图解析器后缀\r\n"+ 
				"spring.mvc.view.suffix=.jsp";
		
		long a1 = System.currentTimeMillis();
		String yml = t.propToYml(prop);
		long a2 = System.currentTimeMillis();
		System.out.println(yml);
		System.out.println(a2 - a1);
		
		
		long b1 = System.currentTimeMillis();
		String aa = t.ymlToProp(yml);
		long b2 = System.currentTimeMillis();
		System.out.println(aa);
		System.out.println(b2 - b1);
		
	}
	
	
	
	private String ymlToProp(String yml){
		
		String[] lines = yml.split(System.lineSeparator());
		
		String desc = "";
		
		List<YmlModel> yms = new ArrayList<YmlModel>();
		
		for(int i = 0; i < lines.length; i++){
			
			// 判断是否为注解
			if(lines[i].charAt(0) == '#'){
				desc = lines[i];
				continue;
			}
			
			
			// 判断是否子属性
			if(lines[i].startsWith("  ")){
				i = setYmlChild(yms.get(yms.size() - 1), lines, i, "  ");
				continue;
			}else{
				YmlModel ym = new YmlModel();
				
				ym.setDesc(desc);
				desc = "";
				ym.setProperty(lines[i]);
				yms.add(ym);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		writeYml(yms, sb , "");
		
		return sb.toString();
	}
	
	
	private int setYmlChild(YmlModel yml, String[] lines, int index, String tab_no){
		
		List<YmlModel> cyms = new ArrayList<YmlModel>();
		
		String desc = "";
		
		for(int i = index; i < lines.length; i++){
			// 判断是否为注解
			if(lines[i].charAt(tab_no.length()) == '#'){
				desc = lines[i];
				continue;
			}
			
			
			// 判断是否子属性
			if(lines[i].startsWith(tab_no + "  ")){
				i = setYmlChild(cyms.get(cyms.size() - 1), lines, i, tab_no + "  ");
				continue;
			}if(lines[i].startsWith(tab_no)){
				
				YmlModel ym = new YmlModel();
				
				ym.setDesc(desc);
				desc = "";
				ym.setProperty(lines[i]);
				cyms.add(ym);
				continue;
			}else{
				yml.setChildNodes(cyms);
				return i - 1;
			}
			
		}
		
		yml.setChildNodes(cyms);
		return lines.length - 1;
		//throw new RuntimeException("子节点解析出错，跳出循环");
	}
	
	
	@SuppressWarnings("unused")
	private void writeProp(List<YmlModel> yms, StringBuilder sb, String tab){

		if(yms == null) return;
		
		for(YmlModel ym : yms){
			if(StringUtils.isNotEmpty(ym.getDesc())) sb.append(tab + ym.getDesc() + System.lineSeparator());
			sb.append(tab + ym.getProperty() + System.lineSeparator());
			writeProp(ym.getChildNodes(), sb, tab + "  ");
		}
	}
}

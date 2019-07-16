package com.ruoyi.web.controller.tool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;

/**
 * sql工具controller
 * @author Li Dehuan
 * @date 2019年7月4日
 *
 */
@Controller
@RequestMapping("/tool/sqlutil")
public class SqlUtilController {

	private String prefix = "tool/sqlutil";
	
	/**
	 * sql工具主页
	 * @return
	 */
	//@RequiresPermissions("tool:build:view")
	@GetMapping()
	public String index() {
		return prefix + "/sqlutil";
	}
	
	
	/**
	 * 获得结果
	 * @param sql
	 * @param params
	 * @return
	 */
	@PostMapping("/getResult")
	@ResponseBody
	public AjaxResult getResult(String sql, String params){
		
		if(StringUtils.isEmpty(sql) || StringUtils.isEmpty(params)){
			return AjaxResult.error("参数不能为空");
		}
		
		if(StringUtils.countMatches(sql, "?") != StringUtils.countMatches(params, "(")){
			return AjaxResult.error("老铁，你的参数不正确啊！");
		}
		
		//验证sql
		sql = formmat(sql);
		
		//计算结果
		String res = sqlUtil(sql, params);
		
		AjaxResult ajaxResult = AjaxResult.success();
		
		ajaxResult.put("data", res);
		
		return ajaxResult;
	}
	
	/**
	 * 验证sql
	 * @param sql
	 * @return
	 */
	private String formmat(String sql) {
		
		//替换转移符
		sql = sql.replaceAll("&gt;", ">").replaceAll("&lt;", "<");
		
		return sql;
	}


	/**
	 * 算法
	 * @param sql
	 * @param params
	 * @return
	 */
	public String sqlUtil(String sql, String params){
		
		if(sql.indexOf('?') < 0) return sql;
		
		StringBuilder sb = new StringBuilder(sql);
		
		String[] list = params.split(", ");
		
		int index = 0;
		
		for(String str : list){
			
			int left = str.indexOf('(');
			
			String type = str.substring(left + 1, str.indexOf(')'));
			
			String value = str.substring(0, left);
			
			index = sb.indexOf("?", index);
			sb.replace(index, index + 1, getStrValue(type, value));
			
			index += value.length();
		}
		
		return sb.toString();
	}
	
	
	public String getStrValue(String type, String value){
		
		if("String".equals(type) || "Timestamp".equals(type)){
			
			return "'" + value + "'";
		}else{
			return value;
		}

	}
}

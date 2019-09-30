package com.ruoyi.web.controller.tool;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.LdhWebCount;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.SqlUtilParamType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;

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
	
	public static final String spliL = "(ldh(";
	public static final String spliR = ")ldh)";
	
	@Autowired
	private ISysDictDataService sysDictDataService;
	
	/**
	 * sql工具主页
	 * @return
	 */
	//@RequiresPermissions("tool:build:view")
	@LdhWebCount(apiName="sql工具主页")
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
	public AjaxResult getResult(String sql, String params, int nullFlag){
		
		if(StringUtils.isEmpty(sql) || StringUtils.isEmpty(params)){
			return AjaxResult.error("参数不能为空");
		}
		
		if(StringUtils.countMatches(sql, "?") > StringUtils.countMatches(params, "(") + StringUtils.countMatches(params, "null")){
			return AjaxResult.error("老铁，你的参数不正确啊！");
		}
		
		//验证sql
		sql = formmat(sql);
		
		//格式化参数
		params = formmatParam(params, nullFlag);
		
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
	 * 格式化参数
	 * @param param
	 * @param nullFlag
	 * @return
	 */
	private String formmatParam(String param, int nullFlag) {

		// 类型替换
		List<SysDictData> dtypes = null;
		
		try {
			dtypes = sysDictDataService.selectDictDataByType("sqlutil_params_type");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		SqlUtilParamType[] types = SqlUtilParamType.values();
		// 判断长度大小
		if(dtypes != null && dtypes.size() > types.length){
			for(SysDictData dt :dtypes){
				param = param.replace("(" + dt.getDictValue()+ ")", spliL + dt.getDictValue() + spliR);
			}
		}else{
			for(SqlUtilParamType t :types){
				param = param.replace("(" + t.getCode() + ")", spliL + t.getCode() + spliR);
			}
		}
		
		
		if(nullFlag == 1){
			param = param.replace("null, ", "null" + spliL + "null" + spliR + ", ");

			int ind = param.lastIndexOf("null");
			
			if("null".equals(param.substring(ind).trim())){
				param = param.subSequence(0, ind) + "null" + spliL + "null" + spliR;
			}

		}
		
		// 末尾加逗号和空格
		param = param + ", ";
		
		return param;
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
		
		String[] list = params.split("[)](ldh)[)][,] ");
		
		int index = 0;
		
		for(String str : list){
			
			int left = str.indexOf(spliL);
			
			String type = str.substring(left + spliL.length());
			
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
	
	
	public static void main(String[] args) {
		
		SqlUtilController c = new SqlUtilController();
		
		String p1 = "ad ? asd ? ff ?";
		String p2 = "sss(String), null, dfnull,g(String)";
		p2 = c.formmatParam(p2, 1);
		
		String a = c.sqlUtil(p1, p2);
		System.out.println(a);
	}
}

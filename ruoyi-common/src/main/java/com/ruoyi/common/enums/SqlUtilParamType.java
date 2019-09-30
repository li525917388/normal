package com.ruoyi.common.enums;

/**
 * sql工具类参数类型
 * @author Li Dehuan
 * @date 2019年9月29日
 *
 */
public enum SqlUtilParamType {

	Integer("Integer","整型"),
	
	Timestamp("Timestamp","时间"),
	
	String("String","字符串");
	
	private String code;
	
	private String name;
	
	private SqlUtilParamType(String code, String name){
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

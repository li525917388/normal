package com.ruoyi.common.core.domain;

import java.util.List;

/**
 * 返回信息
 * @author Li Dehuan
 * @date 2019年7月15日
 *
 */
public class ResultInfo<T> {

	private int code;		// 编号
	
	private String desc;	// 描述
	
	private T data; 		// 数据
	
	private List<T> rows;	// 数据列表
	
	public ResultInfo(){}
	
	public ResultInfo(int code, String desc){
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}

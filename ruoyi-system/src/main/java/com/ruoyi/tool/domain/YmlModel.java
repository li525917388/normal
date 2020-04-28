package com.ruoyi.tool.domain;

import java.util.List;

/**
 * 
 * @author Li Dehuan
 * @date 2019年12月5日
 *
 */
public class YmlModel {

	private String property;			// 属性名称
	
	private String desc;				// 注释
	
	private List<YmlModel> childNodes;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public List<YmlModel> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<YmlModel> childNodes) {
		this.childNodes = childNodes;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}

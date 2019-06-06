package com.ruoyi.ex.domain;

import java.util.Date;

/**
 * 快件跟踪信息
 * @author Li Dehuan
 * @date 2019年6月5日
 *
 */
public class Track {

	private String opType;			//操作类型
	
	private Date opTime;			//操作时间
	
	private String content;			//描述内容

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public Date getOpTime() {
		return opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}

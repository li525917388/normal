package com.ruoyi.system.domain;

import java.util.Date;

/**
 * 邮件任务类
 * @author Li Dehuan
 * @date 2019年7月9日
 *
 */
public class SysEmailTask {

	private Long id;				//主键
	
	private String emailUrl;		// 收件人邮箱
	
	private String title;			// 主题
	
	private String content;			// 内容
	
	private Date createTime;		// 创建时间
	
	private Integer status;			// 状态。 0=未发送，1=发送成功，2=发送失败
	
	private Integer failureNum;		// 失败次数
	
	private String source;			// 来源
	
	private String failureReason;	// 失败原因

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailUrl() {
		return emailUrl;
	}

	public void setEmailUrl(String emailUrl) {
		this.emailUrl = emailUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFailureNum() {
		return failureNum;
	}

	public void setFailureNum(Integer failureNum) {
		this.failureNum = failureNum;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
	
}

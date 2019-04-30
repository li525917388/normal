package com.ruoyi.my.domain;

import java.util.Date;

/**
 * 我的代办任务
 * @author Li Dehuan
 * @date 2019年4月28日
 *
 */
public class MyTask {

	private String taskId;			//任务id
	
	private String taskName;		//任务名称
	
	private String flowName;		//流程名称
	
	private String businessId;		//业务id
	
	private String formKey;			//表单key
	
	private String startUser;		//发起者
	
	private String description;		//任务描述
	
	private Date createTime;		//创建时间
	
	private int priority;			//优先等级

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getStartUser() {
		return startUser;
	}

	public void setStartUser(String startUser) {
		this.startUser = startUser;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getFormKey() {
		return formKey;
	}

	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	
}

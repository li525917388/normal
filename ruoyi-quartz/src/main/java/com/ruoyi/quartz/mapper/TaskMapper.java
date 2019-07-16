package com.ruoyi.quartz.mapper;

import java.util.List;

import com.ruoyi.quartz.domain.EmailTask;

/**
 * 任务mapper
 * @author Li Dehuan
 * @date 2019年7月9日
 *
 */
public interface TaskMapper {

	
	/**
	 * 查询邮件任务list
	 * @return
	 */
	List<EmailTask> queryEmailTask();
	
	
	/**
	 * 更新邮件任务状态
	 * @param task
	 * @return
	 */
	int updateEmailTaskStatus(EmailTask task);
}

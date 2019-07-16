package com.ruoyi.quartz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.quartz.domain.EmailTask;
import com.ruoyi.quartz.mapper.TaskMapper;
import com.ruoyi.quartz.service.ITaskService;

/**
 * 任务service实现类
 * @author Li Dehuan
 * @date 2019年7月9日
 *
 */
@Service
public class ITaskServiceImpl implements ITaskService {

	@Autowired
	private TaskMapper taskMapper;
	
	
	/*
	 * 查询邮件任务list
	 * @see com.ruoyi.quartz.service.ITaskService#queryEmailTask()
	 * 2019年7月9日
	 */
	@Override
	public List<EmailTask> queryEmailTask() {
		
		return taskMapper.queryEmailTask();
	}

	
	/*
	 * 更新邮件任务状态
	 * @see com.ruoyi.quartz.service.ITaskService#updateEmailTaskStatus(com.ruoyi.quartz.domain.EmailTask)
	 * 2019年7月9日
	 */
	@Override
	public int updateEmailTaskStatus(EmailTask task) {
		
		return taskMapper.updateEmailTaskStatus(task);
	}

}

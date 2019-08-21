package com.ruoyi.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.domain.SysEmailTask;
import com.ruoyi.system.mapper.AddTaskMapper;
import com.ruoyi.system.service.IAddTaskService;

/**
 * 任务推送数据新增 service 实现类
 * @author Li Dehuan
 * @date 2019年7月18日
 *
 */
@Service
public class AddTaskServiceImpl implements IAddTaskService {

	@Autowired
	AddTaskMapper taskMapper;
	
	
	/*
	 * 新增邮发送任务
	 * @see com.ruoyi.system.service.IAddTaskService#insertEmailTask(com.ruoyi.system.domain.SysEmailTask)
	 * 2019年7月18日
	 */
	@Transactional(propagation=Propagation.NESTED)
	@Override
	public int insertEmailTask(SysEmailTask emailTask) {

		return taskMapper.insertEmailTask(emailTask);
	}

}

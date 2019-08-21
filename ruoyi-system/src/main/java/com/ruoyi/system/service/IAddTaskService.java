package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysEmailTask;

/**
 * 任务推送数据新增 service
 * @author Li Dehuan
 * @date 2019年7月18日
 *
 */
public interface IAddTaskService {

	
	/**
	 * 新增邮件
	 * @param emailTask
	 * @return
	 */
	int insertEmailTask(SysEmailTask emailTask);
}

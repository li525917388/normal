package com.ruoyi.my.service;

import java.util.List;

import com.ruoyi.my.domain.MyTask;
import com.ruoyi.system.domain.SysUser;

/**
 * 我的待办任务 service
 * @author Li Dehuan
 * @date 2019年4月28日
 *
 */
public interface MyTaskService {

	
	/**
	 * 获取个人待办列表
	 * @param myTask
	 * @param user
	 * @return
	 */
	List<MyTask> selectMyTaskList(MyTask myTask, SysUser user);

	
	/**
	 * 获取任务详情
	 * @param taskId
	 * @return
	 */
	MyTask getTaskInfo(String taskId);


	
	/**
	 * 处理任务
	 * @param taskId
	 * @param opinion
	 * @param remark
	 * @return
	 */
	int doRask(String taskId, int opinion, String remark, String userId);

	
}

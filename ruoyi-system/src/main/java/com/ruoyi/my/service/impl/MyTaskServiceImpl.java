package com.ruoyi.my.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.my.domain.MyTask;
import com.ruoyi.my.service.MyTaskService;
import com.ruoyi.system.domain.SysUser;


/**
 * 我的个人待办任务
 * @author Li Dehuan
 * @date 2019年4月28日
 *
 */
@Service("MyTaskService")
public class MyTaskServiceImpl implements MyTaskService {

	@Autowired
	TaskService taskService;
	
	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	HistoryService historyService;

	
	/*
	 * 获取个人待办列表
	 * @see com.ruoyi.my.service.MyTaskService#selectMyTaskList(com.ruoyi.my.domain.MyTask, com.ruoyi.system.domain.SysUser)
	 * 2019年4月28日
	 */
	@Override
	public List<MyTask> selectMyTaskList(MyTask params, SysUser user) {
		
		List<Task> mylist = taskService.createTaskQuery().taskAssignee(user.getUserId() + "").list();
		
		List<Task> undoList = taskService.createTaskQuery().taskCandidateUser(user.getUserId() + "").list();
		
		mylist.addAll(undoList);
		
		List<MyTask> list = new ArrayList<MyTask>();
		
		for(Task task : mylist){
			MyTask myTask = new MyTask();
			myTask.setTaskId(task.getId());
			myTask.setTaskName(task.getName());
			myTask.setPriority(task.getPriority());
			myTask.setDescription(task.getDescription());
			myTask.setCreateTime(task.getCreateTime());
			System.out.println(task.getCategory());
			System.out.println(task.getProcessInstanceId());
			System.out.println(task.getProcessDefinitionId());
			
			String flowName = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getProcessDefinitionName();
			myTask.setFlowName(flowName);
			
			String startUser = historyService.createHistoricProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getStartUserId();
			myTask.setStartUser(startUser);
			
			System.out.println(flowName);
			
			list.add(myTask);
		}
		
		return list;
	}


	@Override
	public MyTask getTaskInfo(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		
		MyTask myTask = new MyTask();
		myTask.setTaskId(task.getId());
		myTask.setTaskName(task.getName());
		myTask.setPriority(task.getPriority());
		myTask.setDescription(task.getDescription());
		myTask.setCreateTime(task.getCreateTime());

		String flowName = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getProcessDefinitionName();
		myTask.setFlowName(flowName);
		
		String businessId = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getBusinessKey();
		myTask.setBusinessId(businessId);
		
		String startUser = historyService.createHistoricProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getStartUserId();
		myTask.setStartUser(startUser);
		
		return myTask;
	}


	/*
	 * 处理任务
	 * @see com.ruoyi.my.service.MyTaskService#doRask(java.lang.String, int, java.lang.String)
	 * 2019年4月30日
	 */
	@Override
	public int doRask(String taskId, int opinion, String remark, String userId) {
		
		taskService.claim(taskId, userId);		//	认领
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("op", opinion);
		
		taskService.complete(taskId, params);
		
		return 0;
	}
	
}

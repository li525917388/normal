package com.ruoyi.req.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.req.mapper.RequisitionMapper;
import com.ruoyi.req.domain.Requisition;
import com.ruoyi.req.service.IRequisitionService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.common.core.text.Convert;

/**
 * 申购 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-04-12
 */
@Service
public class RequisitionServiceImpl implements IRequisitionService 
{
	@Autowired
	private RequisitionMapper requisitionMapper;
	

	@Autowired
    private RepositoryService repositoryService;
    
	@Autowired
    private TaskService taskService;
	
	@Autowired  
    private RuntimeService runtimeService;

	/**
     * 查询申购信息
     * 
     * @param reqCode 申购ID
     * @return 申购信息
     */
    @Override
	public Requisition selectRequisitionById(String reqCode)
	{
	    return requisitionMapper.selectRequisitionById(reqCode);
	}
	
	/**
     * 查询申购列表
     * 
     * @param requisition 申购信息
     * @return 申购集合
     */
	@Override
	public List<Requisition> selectRequisitionList(Requisition requisition)
	{
	    return requisitionMapper.selectRequisitionList(requisition);
	}
	
    /**
     * 新增申购
     * 
     * @param requisition 申购信息
     * @return 结果
     */
	@Override
	public int insertRequisition(Requisition requisition) {
		
		System.out.println( "调用流程存储服务，查询部署数量：" + repositoryService.createDeploymentQuery().count());

		int res = requisitionMapper.insertRequisition(requisition);

		if(res > 0) {
			//
			ProcessInstance pi = runtimeService.startProcessInstanceByKey("requisition", "requisition::" + requisition.getReqCode());  
			
			System.out.println("id" + pi.getId());
			System.out.println("ActivityId" + pi.getActivityId());
			System.out.println("ProcessInstanceId" + pi.getProcessInstanceId());	
		}
		
	    return res;
	}
	
	/**
     * 修改申购
     * 
     * @param requisition 申购信息
     * @return 结果
     */
	@Override
	public int updateRequisition(Requisition requisition)
	{
	    return requisitionMapper.updateRequisition(requisition);
	}

	/**
     * 删除申购对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRequisitionByIds(String ids)
	{
		return requisitionMapper.deleteRequisitionByIds(Convert.toStrArray(ids));
	}

	
	/*
	 * 获取审核列表
	 * @see com.ruoyi.req.service.IRequisitionService#selectRequisitionApprovList(com.ruoyi.req.domain.Requisition, com.ruoyi.system.domain.SysUser)
	 * 2019年4月28日
	 */
	@Override
	public List<Requisition> selectRequisitionApprovList(Requisition requisition, SysUser user) {
		System.out.println(user == null ? "null" : user.getUserId());
		
		List<Task> mylist = taskService.createTaskQuery().taskAssignee(user.getUserId().toString()).list();
		
		List<Task> undoList = taskService.createTaskQuery().taskCandidateUser(user.getUserId().toString()).list();
		
		mylist.addAll(undoList);
		
		System.out.println("任务数：" + mylist.size());
		
		List<String> list = new ArrayList<String>();
		
		for(Task t : mylist){
			String key = runtimeService.createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId()).singleResult().getBusinessKey();
			if(key == null){
				continue;
			}
			String[] arr = key.split("::");
			
			if(arr.length < 2){
				continue;
			}
			
			list.add(arr[1]);
		}
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("requisition", requisition);
		params.put("list", list);
		
		return requisitionMapper.selectRequisitionApprovList(params);
	}
	
}

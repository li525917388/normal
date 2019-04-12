package com.ruoyi.req.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.req.mapper.RequisitionMapper;
import com.ruoyi.req.domain.Requisition;
import com.ruoyi.req.service.IRequisitionService;
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
	public int insertRequisition(Requisition requisition)
	{
	    return requisitionMapper.insertRequisition(requisition);
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
	
}

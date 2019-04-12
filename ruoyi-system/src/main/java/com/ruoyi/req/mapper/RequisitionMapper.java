package com.ruoyi.req.mapper;

import com.ruoyi.req.domain.Requisition;
import java.util.List;	

/**
 * 申购 数据层
 * 
 * @author Li Dehuan
 * @date 2019-04-12
 */
public interface RequisitionMapper 
{
	/**
     * 查询申购信息
     * 
     * @param reqCode 申购ID
     * @return 申购信息
     */
	public Requisition selectRequisitionById(String reqCode);
	
	/**
     * 查询申购列表
     * 
     * @param requisition 申购信息
     * @return 申购集合
     */
	public List<Requisition> selectRequisitionList(Requisition requisition);
	
	/**
     * 新增申购
     * 
     * @param requisition 申购信息
     * @return 结果
     */
	public int insertRequisition(Requisition requisition);
	
	/**
     * 修改申购
     * 
     * @param requisition 申购信息
     * @return 结果
     */
	public int updateRequisition(Requisition requisition);
	
	/**
     * 删除申购
     * 
     * @param reqCode 申购ID
     * @return 结果
     */
	public int deleteRequisitionById(String reqCode);
	
	/**
     * 批量删除申购
     * 
     * @param reqCodes 需要删除的数据ID
     * @return 结果
     */
	public int deleteRequisitionByIds(String[] reqCodes);
	
}
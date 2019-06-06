package com.ruoyi.ex.service;

import com.ruoyi.ex.domain.Waybill;
import com.ruoyi.system.domain.SysUser;

import java.util.List;

/**
 * 运单 服务层
 * 
 * @author Li Dehuan
 * @date 2019-05-31
 */
public interface IWaybillService 
{
	/**
     * 查询运单信息
     * 
     * @param waybillId 运单ID
     * @return 运单信息
     */
	public Waybill selectWaybillById(Long waybillId);
	
	/**
     * 查询运单列表
     * 
     * @param waybill 运单信息
     * @return 运单集合
     */
	public List<Waybill> selectWaybillList(Waybill waybill);
	
	/**
     * 新增运单
     * 
     * @param waybill 运单信息
     * @return 结果
     */
	public int insertWaybill(Waybill waybill);
	
	/**
     * 修改运单
     * 
     * @param waybill 运单信息
     * @return 结果
     */
	public int updateWaybill(Waybill waybill);
		
	/**
     * 删除运单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteWaybillByIds(String ids);
	
	
	

	
	
	/**
	 * 收件操作
	 * @param waybill
	 *  @param user
	 * @return
	 */
	public int pickupOper(Waybill waybill, SysUser user);
	
}

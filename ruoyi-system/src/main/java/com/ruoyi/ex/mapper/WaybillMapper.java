package com.ruoyi.ex.mapper;

import com.ruoyi.ex.domain.ScanInfo;
import com.ruoyi.ex.domain.Waybill;

import java.util.List;	

/**
 * 运单 数据层
 * 
 * @author Li Dehuan
 * @date 2019-05-31
 */
public interface WaybillMapper 
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
	 * 修改运单(根据运单号)
	 * @param waybill 运单信息
	 * @return 结果
	 */
	public int updateWaybillByNo(Waybill waybill);
	
	
	/**
     * 删除运单
     * 
     * @param waybillId 运单ID
     * @return 结果
     */
	public int deleteWaybillById(Long waybillId);
	
	/**
     * 批量删除运单
     * 
     * @param waybillIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteWaybillByIds(String[] waybillIds);

	
	/**
	 * 新增扫描记录
	 * @param scanInfo
	 * @return
	 */
	public int insertScanInfo(ScanInfo scanInfo);

	
	
	/**
	 * 更新运单明细
	 * @param waybill
	 */
	public void updateWaybillDetail(Waybill waybill);
	
}
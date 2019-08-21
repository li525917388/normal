package com.ruoyi.ex.mapper;

import com.ruoyi.ex.domain.ScanSign;
import java.util.List;	

/**
 * 签收 数据层
 * 
 * @author Li Dehuan
 * @date 2019-07-16
 */
public interface ScanSignMapper 
{
	/**
     * 查询签收信息
     * 
     * @param id 签收ID
     * @return 签收信息
     */
	public ScanSign selectScanSignById(Long id);
	
	
	
	/**
	 * 查询签收信息
	 * @param waybill 运单编号
	 * @return
	 */
	public ScanSign selectScanSignByWaybill(String waybill);
	
	
	
	/**
     * 查询签收列表
     * 
     * @param scanSign 签收信息
     * @return 签收集合
     */
	public List<ScanSign> selectScanSignList(ScanSign scanSign);
	
	/**
     * 新增签收
     * 
     * @param scanSign 签收信息
     * @return 结果
     */
	public int insertScanSign(ScanSign scanSign);
	
	/**
     * 修改签收
     * 
     * @param scanSign 签收信息
     * @return 结果
     */
	public int updateScanSign(ScanSign scanSign);
	
	/**
     * 删除签收
     * 
     * @param id 签收ID
     * @return 结果
     */
	public int deleteScanSignById(Long id);
	
	/**
     * 批量删除签收
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteScanSignByIds(String[] ids);
	
}
package com.ruoyi.ex.mapper;

import com.ruoyi.ex.domain.ScanInfo;
import java.util.List;	

/**
 * 扫描 数据层
 * 
 * @author Li Dehuan
 * @date 2019-06-05
 */
public interface ScanInfoMapper 
{
	/**
     * 查询扫描信息
     * 
     * @param scanId 扫描ID
     * @return 扫描信息
     */
	public ScanInfo selectScanInfoById(Long scanId);
	
	/**
     * 查询扫描列表
     * 
     * @param scanInfo 扫描信息
     * @return 扫描集合
     */
	public List<ScanInfo> selectScanInfoList(ScanInfo scanInfo);
	
	/**
     * 新增扫描
     * 
     * @param scanInfo 扫描信息
     * @return 结果
     */
	public int insertScanInfo(ScanInfo scanInfo);
	
	/**
     * 修改扫描
     * 
     * @param scanInfo 扫描信息
     * @return 结果
     */
	public int updateScanInfo(ScanInfo scanInfo);
	
	/**
     * 删除扫描
     * 
     * @param scanId 扫描ID
     * @return 结果
     */
	public int deleteScanInfoById(Long scanId);
	
	/**
     * 批量删除扫描
     * 
     * @param scanIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteScanInfoByIds(String[] scanIds);
	
}
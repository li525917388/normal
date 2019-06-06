package com.ruoyi.ex.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ex.mapper.ScanInfoMapper;
import com.ruoyi.ex.domain.ScanInfo;
import com.ruoyi.ex.service.IScanInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 扫描 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-06-05
 */
@Service
public class ScanInfoServiceImpl implements IScanInfoService 
{
	@Autowired
	private ScanInfoMapper scanInfoMapper;

	/**
     * 查询扫描信息
     * 
     * @param scanId 扫描ID
     * @return 扫描信息
     */
    @Override
	public ScanInfo selectScanInfoById(Long scanId)
	{
	    return scanInfoMapper.selectScanInfoById(scanId);
	}
	
	/**
     * 查询扫描列表
     * 
     * @param scanInfo 扫描信息
     * @return 扫描集合
     */
	@Override
	public List<ScanInfo> selectScanInfoList(ScanInfo scanInfo)
	{
	    return scanInfoMapper.selectScanInfoList(scanInfo);
	}
	
    /**
     * 新增扫描
     * 
     * @param scanInfo 扫描信息
     * @return 结果
     */
	@Override
	public int insertScanInfo(ScanInfo scanInfo) {
		
	    return scanInfoMapper.insertScanInfo(scanInfo);
	}
	
	/**
     * 修改扫描
     * 
     * @param scanInfo 扫描信息
     * @return 结果
     */
	@Override
	public int updateScanInfo(ScanInfo scanInfo)
	{
	    return scanInfoMapper.updateScanInfo(scanInfo);
	}

	/**
     * 删除扫描对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteScanInfoByIds(String ids)
	{
		return scanInfoMapper.deleteScanInfoByIds(Convert.toStrArray(ids));
	}
	
}

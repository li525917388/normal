package com.ruoyi.ex.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.ex.mapper.OrderMapper;
import com.ruoyi.ex.mapper.ScanInfoMapper;
import com.ruoyi.ex.mapper.ScanSignMapper;
import com.ruoyi.ex.mapper.WaybillMapper;
import com.ruoyi.ex.domain.Order;
import com.ruoyi.ex.domain.ScanInfo;
import com.ruoyi.ex.domain.ScanSign;
import com.ruoyi.ex.domain.Waybill;
import com.ruoyi.ex.service.IScanSignService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;

/**
 * 签收 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-07-16
 */
@Service
public class ScanSignServiceImpl implements IScanSignService 
{
	@Autowired
	private ScanSignMapper scanSignMapper;
	
	@Autowired
	private ScanInfoMapper scanInfoMapper;
	
	@Autowired
	private WaybillMapper waybillMapper;
	
	@Autowired
	private OrderMapper orderMapper;

	/**
     * 查询签收信息
     * 
     * @param id 签收ID
     * @return 签收信息
     */
    @Override
	public ScanSign selectScanSignById(Long id)
	{
	    return scanSignMapper.selectScanSignById(id);
	}
	
	/**
     * 查询签收列表
     * 
     * @param scanSign 签收信息
     * @return 签收集合
     */
	@Override
	public List<ScanSign> selectScanSignList(ScanSign scanSign)
	{
	    return scanSignMapper.selectScanSignList(scanSign);
	}
	
    /**
     * 新增签收
     * 
     * @param scanSign 签收信息
     * @return 结果
     */
	@Transactional
	@Override
	public AjaxResult insertScanSign(ScanSign scanSign) {
		ScanSign sign = scanSignMapper.selectScanSignByWaybill(scanSign.getWaybillNo());
		if(sign != null){
			return AjaxResult.error("该订单已签收");
		}
		
		Date now = new Date();
		
		//插入签收信息
		int res = scanSignMapper.insertScanSign(scanSign);
		
		if(res >= 0) return AjaxResult.error("新增签收信息失败");
		
		//新增扫描信息
		ScanInfo scanInfo = new ScanInfo();
		scanInfo.setWaybillNo(scanSign.getWaybillNo());
		scanInfo.setScanType(50);
		scanInfo.setScanUserId(Convert.toLong(scanSign.getCreateBy()));
		scanInfo.setScanUser(scanSign.getCreateBy());
		scanInfo.setScanTime(now);
		scanInfo.setScanDeptId(scanSign.getSignDeptId());
		scanInfo.setRemark(scanSign.getRemark());
		scanInfo.setSigner(scanSign.getSigner());
		int resScan = scanInfoMapper.insertScanInfo(scanInfo);
		
		if(resScan >= 0) return AjaxResult.error("新增扫描信息失败");
		
		//更新运单信息
		Waybill waybill = new Waybill();
		waybill.setWaybillStatus(50);		//签收
		waybill.setWaybillNo(scanInfo.getWaybillNo());
		int resWay = waybillMapper.updateWaybillByNo(waybill);
		
		if(resWay >= 0) return AjaxResult.error("更新运单失败");
		
		//获取订单信息
		Order order = orderMapper.selectOrderByWaybillNo(scanInfo.getWaybillNo());
		//更新订单状态
		order.setOrderStatus(5);		//已完成
		int resOrd = orderMapper.updateOrder(order);
		if(resOrd >= 0) return AjaxResult.error("更新订单失败");
		
	    return AjaxResult.success();
	}
	
	/**
     * 修改签收
     * 
     * @param scanSign 签收信息
     * @return 结果
     */
	@Override
	public int updateScanSign(ScanSign scanSign)
	{
	    return scanSignMapper.updateScanSign(scanSign);
	}

	/**
     * 删除签收对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteScanSignByIds(String ids)
	{
		return scanSignMapper.deleteScanSignByIds(Convert.toStrArray(ids));
	}
	
}

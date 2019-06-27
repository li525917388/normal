package com.ruoyi.ex.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.ex.mapper.OrderMapper;
import com.ruoyi.ex.mapper.ScanInfoMapper;
import com.ruoyi.ex.mapper.WaybillMapper;
import com.ruoyi.ex.domain.Order;
import com.ruoyi.ex.domain.ScanInfo;
import com.ruoyi.ex.domain.Waybill;
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
	
	@Autowired
	private WaybillMapper waybillMapper;
	
	@Autowired
	private OrderMapper orderMapper;

	/**
     * 查询扫描信息
     * 
     * @param scanId 扫描ID
     * @return 扫描信息
     */
    @Override
	public ScanInfo selectScanTempById(Long scanId)
	{
	    return scanInfoMapper.selectScanTempById(scanId);
	}
	
	/**
     * 查询扫描列表
     * 
     * @param scanInfo 扫描信息
     * @return 扫描集合
     */
	@Override
	public List<ScanInfo> selectScanTempList(ScanInfo scanInfo)
	{
	    return scanInfoMapper.selectScanTempList(scanInfo);
	}
	
    /**
     * 新增扫描
     * 
     * @param scanInfo 扫描信息
     * @return 结果
     */
	@Override
	public int insertScanTemp(ScanInfo scanInfo) {
		
	    return scanInfoMapper.insertScanTemp(scanInfo);
	}
	
	/**
     * 修改扫描
     * 
     * @param scanInfo 扫描信息
     * @return 结果
     */
	@Override
	public int updateScanTemp(ScanInfo scanInfo)
	{
	    return scanInfoMapper.updateScanTemp(scanInfo);
	}

	/**
     * 删除扫描对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteScanTempByIds(String ids)
	{
		return scanInfoMapper.deleteScanTempByIds(Convert.toStrArray(ids));
	}

	
	
	/*
	 * 上传扫描数据
	 * @see com.ruoyi.ex.service.IScanInfoService#uploadScanInfoByIds(java.lang.String)
	 * 2019年6月10日
	 */
	@Override
	@Transactional
	public int uploadScanInfoByIds(String ids) {
		
		String[] idss = Convert.toStrArray(ids);
		
		for(String id : idss){
			
			//获取临时扫描信息
			ScanInfo scanInfo = scanInfoMapper.selectScanTempById(Convert.toLong(id));
			
			//订单信息
			Order order = null;
			
			//运单信息
			Waybill waybill = null;
			
			switch (scanInfo.getScanType()) {
			
			//【10】收件
			case 10:

				//获取订单信息
				order = orderMapper.selectOrderByWaybillNo(scanInfo.getWaybillNo());
				
				waybill = new Waybill();
				waybill.setWaybillStatus(10);	//运单状态，已揽收
				waybill.setWaybillNo(scanInfo.getWaybillNo());//运单号
				waybill.setOrderId(order.getOrderid());	//订单ID
				waybill.setSendDate(new Date());	//寄件日期
				waybill.setReceiverName(order.getReceiverName());//收件人姓名
				waybill.setReceiverPhone(order.getReceiverPhone());//收件人电话
				waybill.setWeight(order.getWeight());	//重量
				waybill.setGoodsName(order.getGoodsName());	//物品名称
				
				waybill.setPickupDate(new Date());
				
				//新增运单信息
				waybillMapper.insertWaybill(waybill);
				
				//更新订单状态
				order.setOrderStatus(4);		//已收取
				orderMapper.updateOrder(order);
				
				break;
				
				
			//【20】发件
			case 20:
				waybill = new Waybill();
				waybill.setWaybillStatus(20);		//运输中
				waybill.setWaybillNo(scanInfo.getWaybillNo());
				
				//更新运单信息
				waybillMapper.updateWaybillByNo(waybill);
				
				break;
				
				
			//【30】到件
			case 30:
				waybill = new Waybill();
				waybill.setWaybillStatus(20);		//运输中
				waybill.setWaybillNo(scanInfo.getWaybillNo());
				
				//更新运单信息
				waybillMapper.updateWaybillByNo(waybill);
				
				break;
				
				
			//【40】派件
			case 40:
				waybill = new Waybill();
				waybill.setWaybillStatus(40);		//派件中
				waybill.setWaybillNo(scanInfo.getWaybillNo());
				
				//更新运单信息
				waybillMapper.updateWaybillByNo(waybill);
				
				break;
				
				
				
			//【41】自提件
			case 41:
				waybill = new Waybill();
				waybill.setWaybillStatus(41);		//自提件
				waybill.setWaybillNo(scanInfo.getWaybillNo());
				
				//更新运单信息
				waybillMapper.updateWaybillByNo(waybill);
				
				break;
				
				
			//【50】签收
			case 50:
				waybill = new Waybill();
				waybill.setWaybillStatus(50);		//派件中
				waybill.setWaybillNo(scanInfo.getWaybillNo());
				
				//更新运单信息
				waybillMapper.updateWaybillByNo(waybill);
				
				//获取订单信息
				order = orderMapper.selectOrderByWaybillNo(scanInfo.getWaybillNo());
				//更新订单状态
				order.setOrderStatus(5);		//已完成
				orderMapper.updateOrder(order);
				
				break;
				
			default:
				
				return 0;
			}
			

			//新增扫描信息
			scanInfoMapper.insertScanInfo(scanInfo);
			//删除临时扫描信息
			scanInfoMapper.deleteScanTempById(scanInfo.getScanId());
		}
		
		return idss.length;
	}
	
}

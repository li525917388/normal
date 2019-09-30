package com.ruoyi.ex.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.ex.mapper.OrderMapper;
import com.ruoyi.ex.mapper.WaybillMapper;
import com.ruoyi.ex.domain.Order;
import com.ruoyi.ex.domain.ScanInfo;
import com.ruoyi.ex.domain.Waybill;
import com.ruoyi.ex.service.IWaybillService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.common.core.text.Convert;

/**
 * 运单 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-05-31
 */
@Service
public class WaybillServiceImpl implements IWaybillService {
	
	@Autowired
	private WaybillMapper waybillMapper;
	
	@Autowired
	private OrderMapper orderMapper;

	/**
     * 查询运单信息
     * 
     * @param waybillId 运单ID
     * @return 运单信息
     */
    @Override
	public Waybill selectWaybillById(Long waybillId)
	{
	    return waybillMapper.selectWaybillById(waybillId);
	}
	
	/**
     * 查询运单列表
     * 
     * @param waybill 运单信息
     * @return 运单集合
     */
	@Override
	public List<Waybill> selectWaybillList(Waybill waybill)
	{
	    return waybillMapper.selectWaybillList(waybill);
	}
	
    /**
     * 新增运单
     * 
     * @param waybill 运单信息
     * @return 结果
     */
	@Override
	public int insertWaybill(Waybill waybill) {
		int res = waybillMapper.insertWaybill(waybill);
		
		waybill.setPickupDate(new Date());
		//更新运单明细
		waybillMapper.updateWaybillDetail(waybill);
		
	    return res;
	}
	
	/**
     * 修改运单
     * 
     * @param waybill 运单信息
     * @return 结果
     */
	@Override
	public int updateWaybill(Waybill waybill)
	{
	    return waybillMapper.updateWaybill(waybill);
	}

	/**
     * 删除运单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWaybillByIds(String ids)
	{
		return waybillMapper.deleteWaybillByIds(Convert.toStrArray(ids));
	}

	
	
	/*
	 * 收件操作
	 * @see com.ruoyi.ex.service.IOrderService#pickupOper(com.ruoyi.ex.domain.Waybill)
	 * 2019年5月31日
	 */
	@Transactional
	@Override
	public int pickupOper(Waybill waybill, SysUser user) {
		
		waybill.setWaybillStatus(10);	//运单状态。10=收件
		waybill.setSendDate(new Date());
		
		//新增运单
		int waybillRes = this.insertWaybill(waybill);
		
		if(waybillRes == 0){
			throw new RuntimeException("新增运单失败");
		}
		
		//修改订单状态
		Order order = new Order();
		order.setOrderStatus(4);		//设置已收取
		order.setOrderid(waybill.getOrderId());
		int orderRes = orderMapper.updateOrder(order);
		
		if(orderRes == 0){
			throw new RuntimeException("修改订单状态失败");
		}
		
		//新增扫描记录
		ScanInfo scanInfo = new ScanInfo();
		scanInfo.setScanType(10);						//收件
		scanInfo.setWaybillNo(waybill.getWaybillNo());	//运单号
		scanInfo.setScanTime(new Date());				//扫描时间
		scanInfo.setScanUserId(user.getUserId());		//扫描员
		scanInfo.setScanDeptId(user.getDeptId());		//扫描网点
		//执行：新增
		int resScan = waybillMapper.insertScanInfo(scanInfo);
		
		if(resScan == 0){
			throw new RuntimeException("新增扫描记录失败");
		}
		
		return 1;
	}
	
}

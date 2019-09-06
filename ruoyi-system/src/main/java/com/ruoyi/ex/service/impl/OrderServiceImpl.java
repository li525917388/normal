package com.ruoyi.ex.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.ex.mapper.OrderMapper;
import com.ruoyi.ex.domain.Order;
import com.ruoyi.ex.service.IOrderService;
import com.ruoyi.report.domain.ReportData;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.core.text.StrFormatter;
import com.ruoyi.common.utils.DateUtils;

/**
 * 订单 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-05-28
 */
@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderMapper orderMapper;

	/**
     * 查询订单信息
     * 
     * @param orderid 订单ID
     * @return 订单信息
     */
    @Override
	public Order selectOrderById(Long orderid)
	{
	    return orderMapper.selectOrderById(orderid);
	}
	
	/**
     * 查询订单列表
     * 
     * @param order 订单信息
     * @return 订单集合
     */
	@Override
	public List<Order> selectOrderList(Order order)
	{
	    return orderMapper.selectOrderList(order);
	}
	
    /**
     * 新增订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	@Override
	public int insertOrder(Order order) {
		
		String orderNo = DateUtils.dateTimeNow() + StrFormatter.formatLength(order.getCustId() + "", 5) 
				+ StrFormatter.formatLength(order.getPayType() + "", 1) +  StrFormatter.formatLength(order.getReceiverPhone(), 4);	//订单号
		
		order.setOrderSource("1");
		order.setOrderNo(orderNo);
		order.setOrderDate(new Date());
		order.setOrderStatus(1);			//
		
	    return orderMapper.insertOrder(order);
	}
	
	/**
     * 修改订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	@Override
	public int updateOrder(Order order)
	{
	    return orderMapper.updateOrder(order);
	}

	/**
     * 删除订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOrderByIds(String ids)
	{
		return orderMapper.deleteOrderByIds(Convert.toStrArray(ids));
	}

	
	/*
	 * 调度网点
	 * @see com.ruoyi.ex.service.IOrderService#dispSiet(long[], long)
	 * 2019年5月30日
	 */
	@Transactional
	@Override
	public int dispSiet(Long[] orderid, long deptid) {
		
		for(int i = 0; i < orderid.length; i++){

			Order order = new Order();
			
			order.setOrderid(orderid[i]);
			order.setDispDeptId(deptid);
			order.setOrderStatus(2);		//调度网点
			
			int res = orderMapper.updateOrder(order);
			
			if(res == 0){
				
				throw new RuntimeException("调度失败");
			}
		}
		
		return 1;
	}

	
	
	/*
	 * 调度业务员
	 * @see com.ruoyi.ex.service.IOrderService#dispSalesman(java.lang.Long[], long)
	 * 2019年5月30日
	 */
	@Override
	public int dispSalesman(Long[] orderid, long userid) {
		
		for(int i = 0; i < orderid.length; i++){

			Order order = new Order();
			
			order.setOrderid(orderid[i]);
			order.setDispUserId(userid);
			order.setOrderStatus(3);		//调度业务员
			
			int res = orderMapper.updateOrder(order);
			
			if(res == 0){
				
				throw new RuntimeException("调度失败");
			}
		}
		
		return 1;
	}

	
	
	/*
	 * 根据运单号获取订单信息
	 * @see com.ruoyi.ex.service.IOrderService#selectOrderByWaybillNo(java.lang.String)
	 * 2019年6月4日
	 */
	@Override
	public Order selectOrderByWaybillNo(String waybillNo) {
		
		return orderMapper.selectOrderByWaybillNo(waybillNo);
	}

	
	
	@Override
	public List<ReportData> getOrderMapReportData() {
		// TODO Auto-generated method stub
		return orderMapper.getOrderMapReportData();
	}

	
	/* 
	 * 报表：查询一年每天单量
	 * @param year
	 * @return
	 */
	@Override
	public List<Object[]> getOrderEveryDayReport(String year) {
		
		List<Map<String, Object>> res = orderMapper.getOrderEveryDayReport(year);
		
		List<Object[]> list = new ArrayList<Object[]>();
		
		for(Map<String, Object> map : res){
			Object[] os = new Object[2];
			os[0] = map.get("days");
			os[1] = map.get("total");
			list.add(os);
		}
		
		return list;
	}

}

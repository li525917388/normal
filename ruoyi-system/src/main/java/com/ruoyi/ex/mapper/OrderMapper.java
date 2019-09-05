package com.ruoyi.ex.mapper;

import com.ruoyi.ex.domain.Order;
import com.ruoyi.report.domain.ReportData;

import java.util.List;	

/**
 * 订单 数据层
 * 
 * @author Li Dehuan
 * @date 2019-05-28
 */
public interface OrderMapper 
{
	/**
     * 查询订单信息
     * 
     * @param orderid 订单ID
     * @return 订单信息
     */
	public Order selectOrderById(Long orderid);
	
	/**
     * 查询订单列表
     * 
     * @param order 订单信息
     * @return 订单集合
     */
	public List<Order> selectOrderList(Order order);
	
	/**
     * 新增订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	public int insertOrder(Order order);
	
	/**
     * 修改订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	public int updateOrder(Order order);
	
	/**
     * 删除订单
     * 
     * @param orderid 订单ID
     * @return 结果
     */
	public int deleteOrderById(Long orderid);
	
	/**
     * 批量删除订单
     * 
     * @param orderids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderByIds(String[] orderids);

	
	
	/**
	 * 根据运单号获取订单信息
	 * @param waybillNo
	 * @return
	 */
	public Order selectOrderByWaybillNo(String waybillNo);

	
	/**
	 * 订单地图报表
	 * @return
	 */
	public List<ReportData> getOrderMapReportData();
	
}
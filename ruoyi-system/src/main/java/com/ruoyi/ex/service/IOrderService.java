package com.ruoyi.ex.service;

import com.ruoyi.ex.domain.Order;
import com.ruoyi.report.domain.ReportData;

import java.util.List;

/**
 * 订单 服务层
 * 
 * @author Li Dehuan
 * @date 2019-05-28
 */
public interface IOrderService 
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
     * 删除订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderByIds(String ids);

	
	/**
	 * 调度网点
	 * @param orderid
	 * @param deptid
	 */
	public int dispSiet(Long[] orderid, long deptid);

	
	/**
	 * 调度业务员
	 * @param orderid
	 * @param userid
	 * @return
	 */
	public int dispSalesman(Long[] orderid, long userid);

	
	
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

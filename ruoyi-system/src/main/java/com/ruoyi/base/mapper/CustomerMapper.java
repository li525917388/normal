package com.ruoyi.base.mapper;

import com.ruoyi.base.domain.Customer;
import java.util.List;	

/**
 * 客户 数据层
 * 
 * @author Li Dehuan
 * @date 2019-05-28
 */
public interface CustomerMapper 
{
	/**
     * 查询客户信息
     * 
     * @param custId 客户ID
     * @return 客户信息
     */
	public Customer selectCustomerById(Long custId);
	
	/**
     * 查询客户列表
     * 
     * @param customer 客户信息
     * @return 客户集合
     */
	public List<Customer> selectCustomerList(Customer customer);
	
	/**
     * 新增客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	public int insertCustomer(Customer customer);
	
	/**
     * 修改客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	public int updateCustomer(Customer customer);
	
	/**
     * 删除客户
     * 
     * @param custId 客户ID
     * @return 结果
     */
	public int deleteCustomerById(Long custId);
	
	/**
     * 批量删除客户
     * 
     * @param custIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCustomerByIds(String[] custIds);
	
}
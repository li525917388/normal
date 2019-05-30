package com.ruoyi.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.base.mapper.CustomerMapper;
import com.ruoyi.base.domain.Customer;
import com.ruoyi.base.service.ICustomerService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.Md5Utils;
import com.ruoyi.system.service.ISysConfigService;

/**
 * 客户 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-05-28
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private ISysConfigService configService;

	/**
     * 查询客户信息
     * 
     * @param custId 客户ID
     * @return 客户信息
     */
    @Override
	public Customer selectCustomerById(Long custId)
	{
	    return customerMapper.selectCustomerById(custId);
	}
	
	/**
     * 查询客户列表
     * 
     * @param customer 客户信息
     * @return 客户集合
     */
	@Override
	public List<Customer> selectCustomerList(Customer customer)
	{
	    return customerMapper.selectCustomerList(customer);
	}
	
    /**
     * 新增客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	@Override
	public int insertCustomer(Customer customer) {
		
		//查询客户初始密码
		String pwd = configService.selectConfigByKey("base.customer.initPassword");
		
		if(pwd.isEmpty()){
			
			throw new RuntimeException("未设置客户初始密码参数，请联系管理员。param:base.customer.initPassword");
		}
		
		customer.setPassword(Md5Utils.hash(pwd));//设置初始密码
		
	    return customerMapper.insertCustomer(customer);
	}
	
	/**
     * 修改客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	@Override
	public int updateCustomer(Customer customer)
	{
	    return customerMapper.updateCustomer(customer);
	}

	/**
     * 删除客户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCustomerByIds(String ids)
	{
		return customerMapper.deleteCustomerByIds(Convert.toStrArray(ids));
	}
	
}

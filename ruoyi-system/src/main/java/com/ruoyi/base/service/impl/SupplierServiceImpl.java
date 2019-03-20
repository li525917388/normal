package com.ruoyi.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.base.mapper.SupplierMapper;
import com.ruoyi.base.domain.Supplier;
import com.ruoyi.base.service.ISupplierService;
import com.ruoyi.common.core.text.Convert;

/**
 * 供应商 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-03-20
 */
@Service
public class SupplierServiceImpl implements ISupplierService 
{
	@Autowired
	private SupplierMapper supplierMapper;

	/**
     * 查询供应商信息
     * 
     * @param id 供应商ID
     * @return 供应商信息
     */
    @Override
	public Supplier selectSupplierById(Integer id)
	{
	    return supplierMapper.selectSupplierById(id);
	}
	
	/**
     * 查询供应商列表
     * 
     * @param supplier 供应商信息
     * @return 供应商集合
     */
	@Override
	public List<Supplier> selectSupplierList(Supplier supplier)
	{
	    return supplierMapper.selectSupplierList(supplier);
	}
	
    /**
     * 新增供应商
     * 
     * @param supplier 供应商信息
     * @return 结果
     */
	@Override
	public int insertSupplier(Supplier supplier)
	{
	    return supplierMapper.insertSupplier(supplier);
	}
	
	/**
     * 修改供应商
     * 
     * @param supplier 供应商信息
     * @return 结果
     */
	@Override
	public int updateSupplier(Supplier supplier)
	{
	    return supplierMapper.updateSupplier(supplier);
	}

	/**
     * 删除供应商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSupplierByIds(String ids)
	{
		return supplierMapper.deleteSupplierByIds(Convert.toStrArray(ids));
	}
	
}

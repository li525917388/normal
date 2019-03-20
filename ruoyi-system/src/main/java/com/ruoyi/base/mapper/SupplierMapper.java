package com.ruoyi.base.mapper;

import com.ruoyi.base.domain.Supplier;
import java.util.List;	

/**
 * 供应商 数据层
 * 
 * @author Li Dehuan
 * @date 2019-03-20
 */
public interface SupplierMapper 
{
	/**
     * 查询供应商信息
     * 
     * @param id 供应商ID
     * @return 供应商信息
     */
	public Supplier selectSupplierById(Integer id);
	
	/**
     * 查询供应商列表
     * 
     * @param supplier 供应商信息
     * @return 供应商集合
     */
	public List<Supplier> selectSupplierList(Supplier supplier);
	
	/**
     * 新增供应商
     * 
     * @param supplier 供应商信息
     * @return 结果
     */
	public int insertSupplier(Supplier supplier);
	
	/**
     * 修改供应商
     * 
     * @param supplier 供应商信息
     * @return 结果
     */
	public int updateSupplier(Supplier supplier);
	
	/**
     * 删除供应商
     * 
     * @param id 供应商ID
     * @return 结果
     */
	public int deleteSupplierById(Integer id);
	
	/**
     * 批量删除供应商
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSupplierByIds(String[] ids);
	
}
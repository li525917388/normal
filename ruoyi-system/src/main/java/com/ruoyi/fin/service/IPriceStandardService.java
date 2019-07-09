package com.ruoyi.fin.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fin.domain.PriceStandard;

import java.math.BigDecimal;
import java.util.List;

/**
 * 标准报价 服务层
 * 
 * @author Li Dehuan
 * @date 2019-06-20
 */
public interface IPriceStandardService 
{
	/**
     * 查询标准报价信息
     * 
     * @param id 标准报价ID
     * @return 标准报价信息
     */
	public PriceStandard selectPriceStandardById(Long id);
	
	/**
     * 查询标准报价列表
     * 
     * @param priceStandard 标准报价信息
     * @return 标准报价集合
     */
	public List<PriceStandard> selectPriceStandardList(PriceStandard priceStandard);
	
	/**
     * 新增标准报价
     * 
     * @param priceStandard 标准报价信息
     * @return 结果
     */
	public int insertPriceStandard(PriceStandard priceStandard);
	
	/**
     * 修改标准报价
     * 
     * @param priceStandard 标准报价信息
     * @return 结果
     */
	public int updatePriceStandard(PriceStandard priceStandard);
		
	/**
     * 删除标准报价信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePriceStandardByIds(String ids);

	
	/**
	 * 报价试算
	 * @param priceStandard
	 * @param weight
	 * @return
	 */
	public AjaxResult calculateQuery(PriceStandard priceStandard, BigDecimal weight);
	
}

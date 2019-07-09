package com.ruoyi.fin.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fin.domain.PriceStandardDetail;

import java.util.List;

/**
 * 标准报价明细 服务层
 * 
 * @author Li Dehuan
 * @date 2019-07-02
 */
public interface IPriceStandardDetailService 
{
	/**
     * 查询标准报价明细信息
     * 
     * @param id 标准报价明细ID
     * @return 标准报价明细信息
     */
	public PriceStandardDetail selectPriceStandardDetailById(Long id);
	
	/**
     * 查询标准报价明细列表
     * 
     * @param priceStandardDetail 标准报价明细信息
     * @return 标准报价明细集合
     */
	public List<PriceStandardDetail> selectPriceStandardDetailList(PriceStandardDetail priceStandardDetail);
	
	/**
     * 新增标准报价明细
     * 
     * @param priceStandardDetail 标准报价明细信息
     * @return 结果
     */
	public AjaxResult insertPriceStandardDetail(PriceStandardDetail priceStandardDetail);
	
	/**
     * 修改标准报价明细
     * 
     * @param priceStandardDetail 标准报价明细信息
     * @return 结果
     */
	public AjaxResult updatePriceStandardDetail(PriceStandardDetail priceStandardDetail);
		
	/**
     * 删除标准报价明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePriceStandardDetailByIds(String ids);

	
	/**
	 * 检查重量区间
	 * @param priceStandardDetail
	 * @return
	 */
	public int checkWeightRange(PriceStandardDetail priceStandardDetail);
	
}

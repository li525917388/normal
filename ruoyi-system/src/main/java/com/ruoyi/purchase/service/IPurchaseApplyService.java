package com.ruoyi.purchase.service;

import com.ruoyi.purchase.domain.PurchaseApply;
import java.util.List;

/**
 * 采购申请 服务层
 * 
 * @author Li Dehuan
 * @date 2019-03-22
 */
public interface IPurchaseApplyService 
{
	/**
     * 查询采购申请信息
     * 
     * @param applyNo 采购申请ID
     * @return 采购申请信息
     */
	public PurchaseApply selectPurchaseApplyById(String applyNo);
	
	/**
     * 查询采购申请列表
     * 
     * @param purchaseApply 采购申请信息
     * @return 采购申请集合
     */
	public List<PurchaseApply> selectPurchaseApplyList(PurchaseApply purchaseApply);
	
	/**
     * 新增采购申请
     * 
     * @param purchaseApply 采购申请信息
     * @return 结果
     */
	public int insertPurchaseApply(PurchaseApply purchaseApply);
	
	/**
     * 修改采购申请
     * 
     * @param purchaseApply 采购申请信息
     * @return 结果
     */
	public int updatePurchaseApply(PurchaseApply purchaseApply);
		
	/**
     * 删除采购申请信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePurchaseApplyByIds(String ids);
	
}

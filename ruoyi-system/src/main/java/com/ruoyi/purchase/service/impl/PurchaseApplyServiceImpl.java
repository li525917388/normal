package com.ruoyi.purchase.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.purchase.mapper.PurchaseApplyMapper;
import com.ruoyi.purchase.domain.PurchaseApply;
import com.ruoyi.purchase.service.IPurchaseApplyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 采购申请 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-03-22
 */
@Service
public class PurchaseApplyServiceImpl implements IPurchaseApplyService 
{
	@Autowired
	private PurchaseApplyMapper purchaseApplyMapper;

	/**
     * 查询采购申请信息
     * 
     * @param applyNo 采购申请ID
     * @return 采购申请信息
     */
    @Override
	public PurchaseApply selectPurchaseApplyById(String applyNo)
	{
	    return purchaseApplyMapper.selectPurchaseApplyById(applyNo);
	}
	
	/**
     * 查询采购申请列表
     * 
     * @param purchaseApply 采购申请信息
     * @return 采购申请集合
     */
	@Override
	public List<PurchaseApply> selectPurchaseApplyList(PurchaseApply purchaseApply)
	{
	    return purchaseApplyMapper.selectPurchaseApplyList(purchaseApply);
	}
	
    /**
     * 新增采购申请
     * 
     * @param purchaseApply 采购申请信息
     * @return 结果
     */
	@Override
	public int insertPurchaseApply(PurchaseApply purchaseApply)
	{
		//设置申请编号
		purchaseApply.setApplyNo(getApplyNo(purchaseApply));
		
	    return purchaseApplyMapper.insertPurchaseApply(purchaseApply);
	}
	
	/**
	 * 获取申请单号
	 * @param purchaseApply
	 * @return
	 */
	private synchronized String getApplyNo(PurchaseApply purchaseApply) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		
		return "CG" + sdf.format(new Date());
	}

	/**
     * 修改采购申请
     * 
     * @param purchaseApply 采购申请信息
     * @return 结果
     */
	@Override
	public int updatePurchaseApply(PurchaseApply purchaseApply)
	{
	    return purchaseApplyMapper.updatePurchaseApply(purchaseApply);
	}

	/**
     * 删除采购申请对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePurchaseApplyByIds(String ids)
	{
		return purchaseApplyMapper.deletePurchaseApplyByIds(Convert.toStrArray(ids));
	}
	
}

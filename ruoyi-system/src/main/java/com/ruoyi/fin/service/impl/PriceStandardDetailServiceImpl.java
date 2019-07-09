package com.ruoyi.fin.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.fin.mapper.PriceStandardDetailMapper;
import com.ruoyi.fin.domain.PriceStandardDetail;
import com.ruoyi.fin.service.IPriceStandardDetailService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;

/**
 * 标准报价明细 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-07-02
 */
@Service
public class PriceStandardDetailServiceImpl implements IPriceStandardDetailService 
{
	@Autowired
	private PriceStandardDetailMapper priceStandardDetailMapper;

	/**
     * 查询标准报价明细信息
     * 
     * @param id 标准报价明细ID
     * @return 标准报价明细信息
     */
    @Override
	public PriceStandardDetail selectPriceStandardDetailById(Long id)
	{
	    return priceStandardDetailMapper.selectPriceStandardDetailById(id);
	}
	
	/**
     * 查询标准报价明细列表
     * 
     * @param priceStandardDetail 标准报价明细信息
     * @return 标准报价明细集合
     */
	@Override
	public List<PriceStandardDetail> selectPriceStandardDetailList(PriceStandardDetail priceStandardDetail)
	{
	    return priceStandardDetailMapper.selectPriceStandardDetailList(priceStandardDetail);
	}
	
    /**
     * 新增标准报价明细
     * 
     * @param priceStandardDetail 标准报价明细信息
     * @return 结果
     */
	@Override
	public AjaxResult insertPriceStandardDetail(PriceStandardDetail priceStandardDetail) {

		//格式化
		this.formatPriceStandardDetail(priceStandardDetail);
		
		if(priceStandardDetail.getMinWeight().floatValue() > priceStandardDetail.getMaxWeight().floatValue()){
			return AjaxResult.error("最小重量不能大于最大重量");
		}
		
		//检查重量段是否存在冲突
		int isTrue = priceStandardDetailMapper.checkWeightRange(priceStandardDetail);
		if(isTrue > 0){
			return AjaxResult.error("重量区间存在交集");
		}
		
		// 执行：新增
		int res = priceStandardDetailMapper.insertPriceStandardDetail(priceStandardDetail);
		
		if(res == 0){
			return AjaxResult.error("新增失败");
		}
		
	    return AjaxResult.success();
	}
	
	/**
     * 修改标准报价明细
     * 
     * @param priceStandardDetail 标准报价明细信息
     * @return 结果
     */
	@Override
	public AjaxResult updatePriceStandardDetail(PriceStandardDetail priceStandardDetail) {
		
		//格式化
		this.formatPriceStandardDetail(priceStandardDetail);
		
		if(priceStandardDetail.getMinWeight().floatValue() > priceStandardDetail.getMaxWeight().floatValue()){
			return AjaxResult.error("最小重量不能大于最大重量");
		}
		
		//检查重量段是否存在冲突
		int isTrue = priceStandardDetailMapper.checkWeightRange(priceStandardDetail);
		if(isTrue > 0){
			return AjaxResult.error("重量区间存在交集");
		}
		
		int res = priceStandardDetailMapper.updatePriceStandardDetail(priceStandardDetail);
		if(res == 0){
			AjaxResult.error("保存失败");
		}
		
	    return AjaxResult.success();
	}

	/**
     * 删除标准报价明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePriceStandardDetailByIds(String ids)
	{
		return priceStandardDetailMapper.deletePriceStandardDetailByIds(Convert.toStrArray(ids));
	}

	
	/*
	 * 检查重量区间
	 * @see com.ruoyi.fin.service.IPriceStandardDetailService#checkWeightRange(com.ruoyi.fin.domain.PriceStandardDetail)
	 * 2019年7月3日
	 */
	@Override
	public int checkWeightRange(PriceStandardDetail priceStandardDetail) {
		// TODO Auto-generated method stub
		return priceStandardDetailMapper.checkWeightRange(priceStandardDetail);
	}
	
	
	/**
	 * 格式化报价明细
	 * @param priceStandardDetail
	 */
	private void formatPriceStandardDetail(PriceStandardDetail priceStandardDetail){

		String range = priceStandardDetail.getRange().trim();
		
		int minIndex =  range.indexOf("<");
		
		if(minIndex >= 0){
			
			if(range.charAt(minIndex + 1) == '='){
				priceStandardDetail.setMinType(1);
				priceStandardDetail.setMinWeight(new BigDecimal(range.substring(0, minIndex)));
			}else{
				priceStandardDetail.setMinType(0);
				priceStandardDetail.setMinWeight(new BigDecimal(range.substring(0, minIndex)));
			}
			
			
			int maxIndex = range.indexOf("<", minIndex + 1);
			
			if(range.charAt(maxIndex + 1) == '='){
				priceStandardDetail.setMaxType(1);
				priceStandardDetail.setMaxWeight(new BigDecimal(range.substring(maxIndex + 2)));
			}else{
				priceStandardDetail.setMaxType(0);
				priceStandardDetail.setMaxWeight(new BigDecimal(range.substring(maxIndex + 1)));
			}

		}else{

			int maxIndex =  range.indexOf(">");
			
			if(range.charAt(maxIndex + 1) == '='){
				priceStandardDetail.setMaxType(1);
				priceStandardDetail.setMaxWeight(new BigDecimal(range.substring(0, maxIndex)));
			}else{
				priceStandardDetail.setMaxType(0);
				priceStandardDetail.setMaxWeight(new BigDecimal(range.substring(0, maxIndex)));
			}
			
			minIndex = range.indexOf(">", maxIndex + 1);
			
			if(range.charAt(minIndex + 1) == '='){
				priceStandardDetail.setMinType(1);
				priceStandardDetail.setMinWeight(new BigDecimal(range.substring(minIndex + 2)));
			}else{
				priceStandardDetail.setMinType(0);
				priceStandardDetail.setMinWeight(new BigDecimal(range.substring(minIndex + 1)));
			}
		}
	}
	
}

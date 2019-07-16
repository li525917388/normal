package com.ruoyi.fin.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.fin.mapper.PriceStandardMapper;
import com.ruoyi.fin.domain.PriceStandard;
import com.ruoyi.fin.domain.PriceStandardDetail;
import com.ruoyi.fin.service.IPriceStandardService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;

/**
 * 标准报价 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-06-20
 */
@Service
public class PriceStandardServiceImpl implements IPriceStandardService 
{
	@Autowired
	private PriceStandardMapper priceStandardMapper;

	/**
     * 查询标准报价信息
     * 
     * @param id 标准报价ID
     * @return 标准报价信息
     */
    @Override
	public PriceStandard selectPriceStandardById(Long id)
	{
	    return priceStandardMapper.selectPriceStandardById(id);
	}
	
	/**
     * 查询标准报价列表
     * 
     * @param priceStandard 标准报价信息
     * @return 标准报价集合
     */
	@Override
	public List<PriceStandard> selectPriceStandardList(PriceStandard priceStandard) {
		
	    return priceStandardMapper.selectPriceStandardList(priceStandard);
	}
	
    /**
     * 新增标准报价
     * 
     * @param priceStandard 标准报价信息
     * @return 结果
     */
	@Override
	public int insertPriceStandard(PriceStandard priceStandard)
	{
	    return priceStandardMapper.insertPriceStandard(priceStandard);
	}
	
	/**
     * 修改标准报价
     * 
     * @param priceStandard 标准报价信息
     * @return 结果
     */
	@Override
	public int updatePriceStandard(PriceStandard priceStandard)
	{
	    return priceStandardMapper.updatePriceStandard(priceStandard);
	}

	/**
     * 删除标准报价对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePriceStandardByIds(String ids)
	{
		return priceStandardMapper.deletePriceStandardByIds(Convert.toStrArray(ids));
	}

	
	/*
	 * 试算
	 * @see com.ruoyi.fin.service.IPriceStandardService#calculateQuery(com.ruoyi.fin.domain.PriceStandard)
	 * 2019年7月4日
	 */
	@Override
	public AjaxResult calculateQuery(PriceStandard priceStandard, BigDecimal weight) {
		
		List<PriceStandardDetail> list = priceStandardMapper.calculateQuery(priceStandard);
		
		String postage = "0";
		
		for(PriceStandardDetail pd : list){
			
			//min < W < max
			if(weight.compareTo(pd.getMinWeight()) > -1 && weight.compareTo(pd.getMaxWeight()) < 1){
				
				//判断是否临界值
				if(weight.compareTo(pd.getMinWeight()) == 0 || weight.compareTo(pd.getMaxWeight()) == 0){
					
					//判断左区间是否闭区间
					if(weight.compareTo(pd.getMinWeight()) == 0 || pd.getMinType() == 1) {
						
						//算费
						postage = getPrice(pd.getFormula(), weight.toString());
						break;
					}
					
					//判断右区间是否闭区间
					if(weight.compareTo(pd.getMaxWeight()) == 0 || pd.getMaxType() == 1){
						
						//算费
						postage = getPrice(pd.getFormula(), weight.toString());
						break;
					}
				}else{
					
					//算费
					postage = getPrice(pd.getFormula(), weight.toString());
					break;
				}
			}
			
		}
		
		return AjaxResult.sucData(postage);
	}
	
	
	public String getPrice(String formula, String weight){
		
		StringBuilder sb = new StringBuilder(formula);
		
		//公式变量替换
		int i = sb.indexOf("W");
		while(i >= 0){
			sb.replace(i, i + 1, weight);
			i = sb.indexOf("W", i + weight.length());
		}
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			Object o = engine.eval(sb.toString());
		
			return o.toString();
		} catch (ScriptException e) {
			
			e.printStackTrace();
			throw new RuntimeException("重量公式维护错误");
		}
	}
	
}

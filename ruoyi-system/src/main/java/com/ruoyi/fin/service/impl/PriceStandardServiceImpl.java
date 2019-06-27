package com.ruoyi.fin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fin.mapper.PriceStandardMapper;
import com.ruoyi.fin.domain.PriceStandard;
import com.ruoyi.fin.service.IPriceStandardService;
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
	public List<PriceStandard> selectPriceStandardList(PriceStandard priceStandard)
	{
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
	
}

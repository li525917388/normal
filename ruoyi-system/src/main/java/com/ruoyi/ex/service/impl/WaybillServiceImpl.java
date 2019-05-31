package com.ruoyi.ex.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ex.mapper.WaybillMapper;
import com.ruoyi.ex.domain.Waybill;
import com.ruoyi.ex.service.IWaybillService;
import com.ruoyi.common.core.text.Convert;

/**
 * 运单 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-05-31
 */
@Service
public class WaybillServiceImpl implements IWaybillService 
{
	@Autowired
	private WaybillMapper waybillMapper;

	/**
     * 查询运单信息
     * 
     * @param waybillId 运单ID
     * @return 运单信息
     */
    @Override
	public Waybill selectWaybillById(Long waybillId)
	{
	    return waybillMapper.selectWaybillById(waybillId);
	}
	
	/**
     * 查询运单列表
     * 
     * @param waybill 运单信息
     * @return 运单集合
     */
	@Override
	public List<Waybill> selectWaybillList(Waybill waybill)
	{
	    return waybillMapper.selectWaybillList(waybill);
	}
	
    /**
     * 新增运单
     * 
     * @param waybill 运单信息
     * @return 结果
     */
	@Override
	public int insertWaybill(Waybill waybill)
	{
	    return waybillMapper.insertWaybill(waybill);
	}
	
	/**
     * 修改运单
     * 
     * @param waybill 运单信息
     * @return 结果
     */
	@Override
	public int updateWaybill(Waybill waybill)
	{
	    return waybillMapper.updateWaybill(waybill);
	}

	/**
     * 删除运单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWaybillByIds(String ids)
	{
		return waybillMapper.deleteWaybillByIds(Convert.toStrArray(ids));
	}
	
}

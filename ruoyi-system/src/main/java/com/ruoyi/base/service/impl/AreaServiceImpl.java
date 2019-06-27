package com.ruoyi.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.base.mapper.AreaMapper;
import com.ruoyi.base.domain.Area;
import com.ruoyi.base.service.IAreaService;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.text.Convert;

/**
 * 地区码 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-06-11
 */
@Service
public class AreaServiceImpl implements IAreaService 
{
	@Autowired
	private AreaMapper areaMapper;

	/**
     * 查询地区码信息
     * 
     * @param areaId 地区码ID
     * @return 地区码信息
     */
    @Override
	public Area selectAreaById(Integer areaId)
	{
	    return areaMapper.selectAreaById(areaId);
	}
	
	/**
     * 查询地区码列表
     * 
     * @param area 地区码信息
     * @return 地区码集合
     */
	@Override
	public List<Area> selectAreaList(Area area)
	{
	    return areaMapper.selectAreaList(area);
	}
	
    /**
     * 新增地区码
     * 
     * @param area 地区码信息
     * @return 结果
     */
	@Override
	public int insertArea(Area area)
	{
	    return areaMapper.insertArea(area);
	}
	
	/**
     * 修改地区码
     * 
     * @param area 地区码信息
     * @return 结果
     */
	@Override
	public int updateArea(Area area)
	{
	    return areaMapper.updateArea(area);
	}

	/**
     * 删除地区码对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAreaByIds(String ids)
	{
		return areaMapper.deleteAreaByIds(Convert.toStrArray(ids));
	}

	
	/*
	 * 查询地区树列表
	 * @see com.ruoyi.base.service.IAreaService#selectDeptTree(com.ruoyi.base.domain.Area)
	 * 2019年6月20日
	 */
	@Override
	public List<Ztree> selectAreaTree(Area area) {
		
		List<Ztree> ztrees = areaMapper.selectAreaTree(area);
		
		return ztrees;
	}

}

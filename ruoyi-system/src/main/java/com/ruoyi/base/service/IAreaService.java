package com.ruoyi.base.service;

import com.ruoyi.base.domain.Area;
import com.ruoyi.common.core.domain.Ztree;

import java.util.List;

/**
 * 地区码 服务层
 * 
 * @author Li Dehuan
 * @date 2019-06-11
 */
public interface IAreaService 
{
	/**
     * 查询地区码信息
     * 
     * @param areaId 地区码ID
     * @return 地区码信息
     */
	public Area selectAreaById(Integer areaId);
	
	/**
     * 查询地区码列表
     * 
     * @param area 地区码信息
     * @return 地区码集合
     */
	public List<Area> selectAreaList(Area area);
	
	/**
     * 新增地区码
     * 
     * @param area 地区码信息
     * @return 结果
     */
	public int insertArea(Area area);
	
	/**
     * 修改地区码
     * 
     * @param area 地区码信息
     * @return 结果
     */
	public int updateArea(Area area);
		
	/**
     * 删除地区码信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAreaByIds(String ids);

	
	
	/**
	 * 查询地区树列表
	 * @param area
	 * @return
	 */
	public List<Ztree> selectAreaTree(Area area);
	
}

package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysWebCount;

/**
 * 网站访问计数器 mapper
 * @author Li Dehuan
 * @date 2019年8月22日
 *
 */
public interface SysWebCountMapper {	

	
	/**
	 * 查询监控网站访问量信息
	 * 
	 * @param apiCode 监控网站访问量ID
 	 * @return 监控网站访问量信息
	 */
	public SysWebCount selectSysWebCountById(String apiCode);
	
	/**
	 * 查询监控网站访问量列表
	 * 
	 * @param sysWebCount 监控网站访问量信息
	 * @return 监控网站访问量集合
	 */
	public List<SysWebCount> selectSysWebCountList(SysWebCount sysWebCount);
	
	/**
	 * 新增监控网站访问量
	 * 
	 * @param sysWebCount 监控网站访问量信息
	 * @return 结果
	 */
	public int insertSysWebCount(SysWebCount sysWebCount);
	
	/**
	 * 修改监控网站访问量
	 * 
	 * @param sysWebCount 监控网站访问量信息
	 * @return 结果
	 */
	public int updateSysWebCount(SysWebCount sysWebCount);
	
	/**
	 * 删除监控网站访问量
	 * 
	 * @param apiCode 监控网站访问量ID
	 * @return 结果
	 */
	public int deleteSysWebCountById(String apiCode);
	
	/**
	 * 批量删除监控网站访问量
	 * 
	 * @param apiCodes 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSysWebCountByIds(String[] apiCodes);
}

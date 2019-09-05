package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysWebCount;
import java.util.List;

/**
 * 监控网站访问量 服务层
 * 
 * @author Li Dehuan
 * @date 2019-08-22
 */
public interface ISysWebCountService 
{
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
	 * 删除监控网站访问量信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteSysWebCountByIds(String ids);
	
}

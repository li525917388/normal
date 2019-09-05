package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysWebCountMapper;
import com.ruoyi.system.domain.SysWebCount;
import com.ruoyi.system.service.ISysWebCountService;
import com.ruoyi.common.core.text.Convert;

/**
 * 监控网站访问量 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-08-22
 */
@Service
public class SysWebCountServiceImpl implements ISysWebCountService 
{
	@Autowired
	private SysWebCountMapper sysWebCountMapper;

	/**
	 * 查询监控网站访问量信息
	 * 
	 * @param apiCode 监控网站访问量ID
	 * @return 监控网站访问量信息
	 */
	@Override
	public SysWebCount selectSysWebCountById(String apiCode) {
		return sysWebCountMapper.selectSysWebCountById(apiCode);
	}
	
	/**
	 * 查询监控网站访问量列表
	 * 
	 * @param sysWebCount 监控网站访问量信息
	 * @return 监控网站访问量集合
	 */
	@Override
	public List<SysWebCount> selectSysWebCountList(SysWebCount sysWebCount) {
		return sysWebCountMapper.selectSysWebCountList(sysWebCount);
	}
	
    /**
	 * 新增监控网站访问量
	 * 
	 * @param sysWebCount 监控网站访问量信息
	 * @return 结果
	 */
	@Override
	public int insertSysWebCount(SysWebCount sysWebCount) {
		return sysWebCountMapper.insertSysWebCount(sysWebCount);
	}
	
	/**
	 * 修改监控网站访问量
	 * 
	 * @param sysWebCount 监控网站访问量信息
	 * @return 结果
	 */
	@Override
	public int updateSysWebCount(SysWebCount sysWebCount) {
	    return sysWebCountMapper.updateSysWebCount(sysWebCount);
	}

	/**
	 * 删除监控网站访问量对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteSysWebCountByIds(String ids) {
		return sysWebCountMapper.deleteSysWebCountByIds(Convert.toStrArray(ids));
	}
	
}

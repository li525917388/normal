package com.ruoyi.bk.mapper;

import com.ruoyi.bk.domain.BkConfig;
import java.util.List;	

/**
 * 博客项目参数 数据层
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
public interface BkConfigMapper {
	/**
	 * 查询博客项目参数信息
	 * 
	 * @param id 博客项目参数ID
 	 * @return 博客项目参数信息
	 */
	public BkConfig selectBkConfigById(Long id);
	
	/**
	 * 查询博客项目参数列表
	 * 
	 * @param bkConfig 博客项目参数信息
	 * @return 博客项目参数集合
	 */
	public List<BkConfig> selectBkConfigList(BkConfig bkConfig);
	
	/**
	 * 新增博客项目参数
	 * 
	 * @param bkConfig 博客项目参数信息
	 * @return 结果
	 */
	public int insertBkConfig(BkConfig bkConfig);
	
	/**
	 * 修改博客项目参数
	 * 
	 * @param bkConfig 博客项目参数信息
	 * @return 结果
	 */
	public int updateBkConfig(BkConfig bkConfig);
	
	/**
	 * 删除博客项目参数
	 * 
	 * @param id 博客项目参数ID
	 * @return 结果
	 */
	public int deleteBkConfigById(Long id);
	
	/**
	 * 批量删除博客项目参数
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBkConfigByIds(String[] ids);
	
}
package com.ruoyi.bk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bk.mapper.BkConfigMapper;
import com.ruoyi.bk.domain.BkConfig;
import com.ruoyi.bk.service.IBkConfigService;
import com.ruoyi.common.core.text.Convert;

/**
 * 博客项目参数 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
@Service
public class BkConfigServiceImpl implements IBkConfigService 
{
	@Autowired
	private BkConfigMapper bkConfigMapper;

	/**
	 * 查询博客项目参数信息
	 * 
	 * @param id 博客项目参数ID
	 * @return 博客项目参数信息
	 */
	@Override
	public BkConfig selectBkConfigById(Long id) {
		return bkConfigMapper.selectBkConfigById(id);
	}
	
	/**
	 * 查询博客项目参数列表
	 * 
	 * @param bkConfig 博客项目参数信息
	 * @return 博客项目参数集合
	 */
	@Override
	public List<BkConfig> selectBkConfigList(BkConfig bkConfig) {
		return bkConfigMapper.selectBkConfigList(bkConfig);
	}
	
    /**
	 * 新增博客项目参数
	 * 
	 * @param bkConfig 博客项目参数信息
	 * @return 结果
	 */
	@Override
	public int insertBkConfig(BkConfig bkConfig) {
		return bkConfigMapper.insertBkConfig(bkConfig);
	}
	
	/**
	 * 修改博客项目参数
	 * 
	 * @param bkConfig 博客项目参数信息
	 * @return 结果
	 */
	@Override
	public int updateBkConfig(BkConfig bkConfig) {
	    return bkConfigMapper.updateBkConfig(bkConfig);
	}

	/**
	 * 删除博客项目参数对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteBkConfigByIds(String ids) {
		return bkConfigMapper.deleteBkConfigByIds(Convert.toStrArray(ids));
	}
	
}

package com.ruoyi.bk.service;

import com.ruoyi.bk.domain.BkWeService;
import java.util.List;

/**
 * 我们的服务 服务层
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
public interface IBkWeServiceService 
{
	/**
	 * 查询我们的服务信息
	 * 
	 * @param id 我们的服务ID
	 * @return 我们的服务信息
	 */
	public BkWeService selectBkWeServiceById(Integer id);
	
	/**
	 * 查询我们的服务列表
	 * 
	 * @param bkWeService 我们的服务信息
	 * @return 我们的服务集合
	 */
	public List<BkWeService> selectBkWeServiceList(BkWeService bkWeService);
	
	/**
	 * 新增我们的服务
	 * 
	 * @param bkWeService 我们的服务信息
	 * @return 结果
	 */
	public int insertBkWeService(BkWeService bkWeService);
	
	/**
	 * 修改我们的服务
	 * 
	 * @param bkWeService 我们的服务信息
	 * @return 结果
	 */
	public int updateBkWeService(BkWeService bkWeService);
		
	/**
	 * 删除我们的服务信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBkWeServiceByIds(String ids);
	
}

package com.ruoyi.bk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bk.mapper.BkWeServiceMapper;
import com.ruoyi.bk.domain.BkWeService;
import com.ruoyi.bk.service.IBkWeServiceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 我们的服务 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
@Service
public class BkWeServiceServiceImpl implements IBkWeServiceService 
{
	@Autowired
	private BkWeServiceMapper bkWeServiceMapper;

	/**
	 * 查询我们的服务信息
	 * 
	 * @param id 我们的服务ID
	 * @return 我们的服务信息
	 */
	@Override
	public BkWeService selectBkWeServiceById(Integer id) {
		return bkWeServiceMapper.selectBkWeServiceById(id);
	}
	
	/**
	 * 查询我们的服务列表
	 * 
	 * @param bkWeService 我们的服务信息
	 * @return 我们的服务集合
	 */
	@Override
	public List<BkWeService> selectBkWeServiceList(BkWeService bkWeService) {
		return bkWeServiceMapper.selectBkWeServiceList(bkWeService);
	}
	
    /**
	 * 新增我们的服务
	 * 
	 * @param bkWeService 我们的服务信息
	 * @return 结果
	 */
	@Override
	public int insertBkWeService(BkWeService bkWeService) {
		return bkWeServiceMapper.insertBkWeService(bkWeService);
	}
	
	/**
	 * 修改我们的服务
	 * 
	 * @param bkWeService 我们的服务信息
	 * @return 结果
	 */
	@Override
	public int updateBkWeService(BkWeService bkWeService) {
	    return bkWeServiceMapper.updateBkWeService(bkWeService);
	}

	/**
	 * 删除我们的服务对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteBkWeServiceByIds(String ids) {
		return bkWeServiceMapper.deleteBkWeServiceByIds(Convert.toStrArray(ids));
	}
	
}

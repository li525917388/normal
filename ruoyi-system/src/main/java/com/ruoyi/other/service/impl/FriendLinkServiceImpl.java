package com.ruoyi.other.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.other.mapper.FriendLinkMapper;
import com.ruoyi.other.domain.FriendLink;
import com.ruoyi.other.service.IFriendLinkService;
import com.ruoyi.common.core.text.Convert;

/**
 * 友情链接 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-07-26
 */
@Service
public class FriendLinkServiceImpl implements IFriendLinkService 
{
	@Autowired
	private FriendLinkMapper friendLinkMapper;

	/**
	 * 查询友情链接信息
	 * 
	 * @param id 友情链接ID
	 * @return 友情链接信息
	 */
	@Override
	public FriendLink selectFriendLinkById(Long id) {
		return friendLinkMapper.selectFriendLinkById(id);
	}
	
	/**
	 * 查询友情链接列表
	 * 
	 * @param friendLink 友情链接信息
	 * @return 友情链接集合
	 */
	@Override
	public List<FriendLink> selectFriendLinkList(FriendLink friendLink) {
		return friendLinkMapper.selectFriendLinkList(friendLink);
	}
	
    /**
	 * 新增友情链接
	 * 
	 * @param friendLink 友情链接信息
	 * @return 结果
	 */
	@Override
	public int insertFriendLink(FriendLink friendLink) {
		return friendLinkMapper.insertFriendLink(friendLink);
	}
	
	/**
	 * 修改友情链接
	 * 
	 * @param friendLink 友情链接信息
	 * @return 结果
	 */
	@Override
	public int updateFriendLink(FriendLink friendLink) {
	    return friendLinkMapper.updateFriendLink(friendLink);
	}

	/**
	 * 删除友情链接对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteFriendLinkByIds(String ids) {
		return friendLinkMapper.deleteFriendLinkByIds(Convert.toStrArray(ids));
	}
	
}

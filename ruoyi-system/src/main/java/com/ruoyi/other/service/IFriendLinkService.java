package com.ruoyi.other.service;

import com.ruoyi.other.domain.FriendLink;
import java.util.List;

/**
 * 友情链接 服务层
 * 
 * @author Li Dehuan
 * @date 2019-07-26
 */
public interface IFriendLinkService 
{
	/**
	 * 查询友情链接信息
	 * 
	 * @param id 友情链接ID
	 * @return 友情链接信息
	 */
	public FriendLink selectFriendLinkById(Long id);
	
	/**
	 * 查询友情链接列表
	 * 
	 * @param friendLink 友情链接信息
	 * @return 友情链接集合
	 */
	public List<FriendLink> selectFriendLinkList(FriendLink friendLink);
	
	/**
	 * 新增友情链接
	 * 
	 * @param friendLink 友情链接信息
	 * @return 结果
	 */
	public int insertFriendLink(FriendLink friendLink);
	
	/**
	 * 修改友情链接
	 * 
	 * @param friendLink 友情链接信息
	 * @return 结果
	 */
	public int updateFriendLink(FriendLink friendLink);
		
	/**
	 * 删除友情链接信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteFriendLinkByIds(String ids);
	
}

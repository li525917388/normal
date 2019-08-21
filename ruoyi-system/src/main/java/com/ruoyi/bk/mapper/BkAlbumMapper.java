package com.ruoyi.bk.mapper;

import com.ruoyi.bk.domain.BkAlbum;
import java.util.List;	

/**
 * 影集 数据层
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
public interface BkAlbumMapper {
	/**
	 * 查询影集信息
	 * 
	 * @param id 影集ID
 	 * @return 影集信息
	 */
	public BkAlbum selectBkAlbumById(Long id);
	
	/**
	 * 查询影集列表
	 * 
	 * @param bkAlbum 影集信息
	 * @return 影集集合
	 */
	public List<BkAlbum> selectBkAlbumList(BkAlbum bkAlbum);
	
	/**
	 * 新增影集
	 * 
	 * @param bkAlbum 影集信息
	 * @return 结果
	 */
	public int insertBkAlbum(BkAlbum bkAlbum);
	
	/**
	 * 修改影集
	 * 
	 * @param bkAlbum 影集信息
	 * @return 结果
	 */
	public int updateBkAlbum(BkAlbum bkAlbum);
	
	/**
	 * 删除影集
	 * 
	 * @param id 影集ID
	 * @return 结果
	 */
	public int deleteBkAlbumById(Long id);
	
	/**
	 * 批量删除影集
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBkAlbumByIds(String[] ids);
	
}
package com.ruoyi.bk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bk.mapper.BkAlbumMapper;
import com.ruoyi.bk.domain.BkAlbum;
import com.ruoyi.bk.service.IBkAlbumService;
import com.ruoyi.common.core.text.Convert;

/**
 * 影集 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
@Service
public class BkAlbumServiceImpl implements IBkAlbumService 
{
	@Autowired
	private BkAlbumMapper bkAlbumMapper;

	/**
	 * 查询影集信息
	 * 
	 * @param id 影集ID
	 * @return 影集信息
	 */
	@Override
	public BkAlbum selectBkAlbumById(Long id) {
		return bkAlbumMapper.selectBkAlbumById(id);
	}
	
	/**
	 * 查询影集列表
	 * 
	 * @param bkAlbum 影集信息
	 * @return 影集集合
	 */
	@Override
	public List<BkAlbum> selectBkAlbumList(BkAlbum bkAlbum) {
		return bkAlbumMapper.selectBkAlbumList(bkAlbum);
	}
	
    /**
	 * 新增影集
	 * 
	 * @param bkAlbum 影集信息
	 * @return 结果
	 */
	@Override
	public int insertBkAlbum(BkAlbum bkAlbum) {
		return bkAlbumMapper.insertBkAlbum(bkAlbum);
	}
	
	/**
	 * 修改影集
	 * 
	 * @param bkAlbum 影集信息
	 * @return 结果
	 */
	@Override
	public int updateBkAlbum(BkAlbum bkAlbum) {
	    return bkAlbumMapper.updateBkAlbum(bkAlbum);
	}

	/**
	 * 删除影集对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteBkAlbumByIds(String ids) {
		return bkAlbumMapper.deleteBkAlbumByIds(Convert.toStrArray(ids));
	}
	
}

package com.ruoyi.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.base.mapper.MaterialMapper;
import com.ruoyi.base.domain.Material;
import com.ruoyi.base.service.IMaterialService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物资 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-03-19
 */
@Service
public class MaterialServiceImpl implements IMaterialService 
{
	@Autowired
	private MaterialMapper materialMapper;

	/**
     * 查询物资信息
     * 
     * @param id 物资ID
     * @return 物资信息
     */
    @Override
	public Material selectMaterialById(Long id)
	{
	    return materialMapper.selectMaterialById(id);
	}
	
	/**
     * 查询物资列表
     * 
     * @param material 物资信息
     * @return 物资集合
     */
	@Override
	public List<Material> selectMaterialList(Material material)
	{
	    return materialMapper.selectMaterialList(material);
	}
	
    /**
     * 新增物资
     * 
     * @param material 物资信息
     * @return 结果
     */
	@Override
	public int insertMaterial(Material material)
	{
	    return materialMapper.insertMaterial(material);
	}
	
	/**
     * 修改物资
     * 
     * @param material 物资信息
     * @return 结果
     */
	@Override
	public int updateMaterial(Material material)
	{
	    return materialMapper.updateMaterial(material);
	}

	/**
     * 删除物资对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMaterialByIds(String ids)
	{
		return materialMapper.deleteMaterialByIds(Convert.toStrArray(ids));
	}
	
}

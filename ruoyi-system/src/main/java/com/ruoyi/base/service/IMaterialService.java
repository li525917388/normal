package com.ruoyi.base.service;

import com.ruoyi.base.domain.Material;
import java.util.List;

/**
 * 物资 服务层
 * 
 * @author Li Dehuan
 * @date 2019-03-19
 */
public interface IMaterialService 
{
	/**
     * 查询物资信息
     * 
     * @param id 物资ID
     * @return 物资信息
     */
	public Material selectMaterialById(Long id);
	
	/**
     * 查询物资列表
     * 
     * @param material 物资信息
     * @return 物资集合
     */
	public List<Material> selectMaterialList(Material material);
	
	/**
     * 新增物资
     * 
     * @param material 物资信息
     * @return 结果
     */
	public int insertMaterial(Material material);
	
	/**
     * 修改物资
     * 
     * @param material 物资信息
     * @return 结果
     */
	public int updateMaterial(Material material);
		
	/**
     * 删除物资信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMaterialByIds(String ids);
	
}

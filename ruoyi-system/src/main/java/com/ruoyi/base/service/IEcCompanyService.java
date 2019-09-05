package com.ruoyi.base.service;

import com.ruoyi.base.domain.EcCompany;

import java.util.List;

/**
 * 电商-公司 服务层
 * 
 * @author Li Dehuan
 * @date 2019-09-04
 */
public interface IEcCompanyService 
{
	/**
	 * 查询电商-公司信息
	 * 
	 * @param id 电商-公司ID
	 * @return 电商-公司信息
	 */
	public EcCompany selectEcCompanyById(Integer id);
	
	/**
	 * 查询电商-公司列表
	 * 
	 * @param ecCompany 电商-公司信息
	 * @return 电商-公司集合
	 */
	public List<EcCompany> selectEcCompanyList(EcCompany ecCompany);
	
	/**
	 * 新增电商-公司
	 * 
	 * @param ecCompany 电商-公司信息
	 * @return 结果
	 */
	public int insertEcCompany(EcCompany ecCompany);
	
	/**
	 * 修改电商-公司
	 * 
	 * @param ecCompany 电商-公司信息
	 * @return 结果
	 */
	public int updateEcCompany(EcCompany ecCompany);
		
	/**
	 * 删除电商-公司信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteEcCompanyByIds(String ids);

	
	
	/**
	 * select2
	 * @param keywords
	 * @return
	 */
	public List<EcCompany> select2(String keywords);
	
}

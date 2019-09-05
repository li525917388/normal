package com.ruoyi.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.base.mapper.EcCompanyMapper;
import com.ruoyi.base.domain.EcCompany;
import com.ruoyi.base.service.IEcCompanyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 电商-公司 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-09-04
 */
@Service
public class EcCompanyServiceImpl implements IEcCompanyService 
{
	@Autowired
	private EcCompanyMapper ecCompanyMapper;

	/**
	 * 查询电商-公司信息
	 * 
	 * @param id 电商-公司ID
	 * @return 电商-公司信息
	 */
	@Override
	public EcCompany selectEcCompanyById(Integer id) {
		return ecCompanyMapper.selectEcCompanyById(id);
	}
	
	/**
	 * 查询电商-公司列表
	 * 
	 * @param ecCompany 电商-公司信息
	 * @return 电商-公司集合
	 */
	@Override
	public List<EcCompany> selectEcCompanyList(EcCompany ecCompany) {
		return ecCompanyMapper.selectEcCompanyList(ecCompany);
	}
	
    /**
	 * 新增电商-公司
	 * 
	 * @param ecCompany 电商-公司信息
	 * @return 结果
	 */
	@Override
	public int insertEcCompany(EcCompany ecCompany) {
		return ecCompanyMapper.insertEcCompany(ecCompany);
	}
	
	/**
	 * 修改电商-公司
	 * 
	 * @param ecCompany 电商-公司信息
	 * @return 结果
	 */
	@Override
	public int updateEcCompany(EcCompany ecCompany) {
	    return ecCompanyMapper.updateEcCompany(ecCompany);
	}

	/**
	 * 删除电商-公司对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteEcCompanyByIds(String ids) {
		return ecCompanyMapper.deleteEcCompanyByIds(Convert.toStrArray(ids));
	}

	
	
	/*
	 * 
	 * @see com.ruoyi.base.service.IEcCompanyService#select2(java.lang.String)
	 * 2019年9月5日
	 */
	@Override
	public List<EcCompany> select2(String keywords) {
		// TODO Auto-generated method stub
		return ecCompanyMapper.select2(keywords);
	}
	
}

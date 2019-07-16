package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.VerificationCodeMapper;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.VerificationCode;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IVerificationCodeService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;

/**
 * 验证码 服务层实现
 * 
 * @author Li Dehuan
 * @date 2019-07-10
 */
@Service
public class VerificationCodeServiceImpl implements IVerificationCodeService 
{
	@Autowired
	private VerificationCodeMapper verificationCodeMapper;
	
	@Autowired
	ISysUserService sysUserService;

	/**
     * 查询验证码信息
     * 
     * @param id 验证码ID
     * @return 验证码信息
     */
    @Override
	public VerificationCode selectVerificationCodeById(Long id)
	{
	    return verificationCodeMapper.selectVerificationCodeById(id);
	}
	
	/**
     * 查询验证码列表
     * 
     * @param verificationCode 验证码信息
     * @return 验证码集合
     */
	@Override
	public List<VerificationCode> selectVerificationCodeList(VerificationCode verificationCode)
	{
	    return verificationCodeMapper.selectVerificationCodeList(verificationCode);
	}
	
    /**
     * 新增验证码
     * 
     * @param verificationCode 验证码信息
     * @return 结果
     */
	@Override
	public int insertVerificationCode(VerificationCode verificationCode)
	{
	    return verificationCodeMapper.insertVerificationCode(verificationCode);
	}
	
	/**
     * 修改验证码
     * 
     * @param verificationCode 验证码信息
     * @return 结果
     */
	@Override
	public int updateVerificationCode(VerificationCode verificationCode)
	{
	    return verificationCodeMapper.updateVerificationCode(verificationCode);
	}

	/**
     * 删除验证码对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteVerificationCodeByIds(String ids)
	{
		return verificationCodeMapper.deleteVerificationCodeByIds(Convert.toStrArray(ids));
	}

	
	
	@Override
	public int getVerificationCode(VerificationCode code) {
		
		VerificationCode veriCode = verificationCodeMapper.getVerificationCode(code);
		
		if(veriCode == null || !veriCode.getVeriCode().equals(code.getVeriCode())){
			return -1;
		}
		
		return 1;
	}
	
	
	/*
	 * 获取验证码信息
	 * @see com.ruoyi.system.service.IVerificationCodeService#getVerificationCode(com.ruoyi.system.domain.VerificationCode)
	 * 2019年7月10日
	 */
	@Transactional
	@Override
	public int getVerificationCode(VerificationCode code, SysUser user) {
		
		VerificationCode veriCode = verificationCodeMapper.getVerificationCode(code);
		
		if(veriCode == null || !veriCode.getVeriCode().equals(code.getVeriCode())){
			return -1;
		}
		
		sysUserService.resetUserPwd(user);
		
		return 1;
	}

	
	
	/*
	 * 修改密码
	 * @see com.ruoyi.system.service.IVerificationCodeService#resetUserPwd(com.ruoyi.system.domain.SysUser)
	 * 2019年7月16日
	 */
	@Transactional
	@Override
	public AjaxResult resetUserPwd(SysUser user, VerificationCode code) {
		
		int res = sysUserService.resetUserPwd(user);
		
		if(res == 0){
			AjaxResult.error("密码修改失败");
		}
		
		VerificationCode verificationCode = verificationCodeMapper.getVerificationCode(code);
		
		if(verificationCode == null || !verificationCode.getVeriCode().equals(code.getVeriCode())){
			AjaxResult.error("验证已过期");
		}
		
		verificationCode.setVaild(0);
		this.updateVerificationCode(verificationCode);
		
		return AjaxResult.success();
	}

	
}

package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.VerificationCode;
import java.util.List;	

/**
 * 验证码 数据层
 * 
 * @author Li Dehuan
 * @date 2019-07-10
 */
public interface VerificationCodeMapper 
{
	/**
     * 查询验证码信息
     * 
     * @param id 验证码ID
     * @return 验证码信息
     */
	public VerificationCode selectVerificationCodeById(Long id);
	
	/**
     * 查询验证码列表
     * 
     * @param verificationCode 验证码信息
     * @return 验证码集合
     */
	public List<VerificationCode> selectVerificationCodeList(VerificationCode verificationCode);
	
	/**
     * 新增验证码
     * 
     * @param verificationCode 验证码信息
     * @return 结果
     */
	public int insertVerificationCode(VerificationCode verificationCode);
	
	/**
     * 修改验证码
     * 
     * @param verificationCode 验证码信息
     * @return 结果
     */
	public int updateVerificationCode(VerificationCode verificationCode);
	
	/**
     * 删除验证码
     * 
     * @param id 验证码ID
     * @return 结果
     */
	public int deleteVerificationCodeById(Long id);
	
	/**
     * 批量删除验证码
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteVerificationCodeByIds(String[] ids);

	
	
	/**
	 * 获取验证码信息
	 * @param code
	 * @return
	 */
	public VerificationCode getVerificationCode(VerificationCode code);
	
}
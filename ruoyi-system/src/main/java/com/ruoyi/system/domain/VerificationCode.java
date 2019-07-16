package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;


/**
 * 验证码表 sys_verification_code
 * 
 * @author Li Dehuan
 * @date 2019-07-10
 */
public class VerificationCode extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 验证码 */
	private String veriCode;
	/** 创建时间 */
	private Date createTime;
	/** 用户名 */
	private String username;
	/** 邮箱 */
	private String email;
	/** 有效时间 */
	private Date vaildTime;
	/** 有效值 */
	private Integer vaild;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setVeriCode(String veriCode) 
	{
		this.veriCode = veriCode;
	}

	public String getVeriCode() 
	{
		return veriCode;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getUsername() 
	{
		return username;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setVaildTime(Date vaildTime) 
	{
		this.vaildTime = vaildTime;
	}

	public Date getVaildTime() 
	{
		return vaildTime;
	}
	public void setVaild(Integer vaild) 
	{
		this.vaild = vaild;
	}

	public Integer getVaild() 
	{
		return vaild;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("veriCode", getVeriCode())
            .append("createTime", getCreateTime())
            .append("username", getUsername())
            .append("email", getEmail())
            .append("vaildTime", getVaildTime())
            .append("vaild", getVaild())
            .toString();
    }
}

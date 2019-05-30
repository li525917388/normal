package com.ruoyi.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;


/**
 * 客户表 base_customer
 * 
 * @author Li Dehuan
 * @date 2019-05-28
 */
public class Customer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long custId;
	/** 客户名称 */
	private String custName;
	/** 登录账号 */
	private String loginName;
	/** 密码 */
	private String password;
	/** 客户电话 */
	private String custPhone;
	/** 客户类型 */
	private Integer custType;
	/** 省 */
	private String custProv;
	/** 市 */
	private String custCity;
	/** 客户区县 */
	private String custArea;
	/** 客户详细地址 */
	private String custAddr;
	/** 备注 */
	private String remark;

	public void setCustId(Long custId) 
	{
		this.custId = custId;
	}

	public Long getCustId() 
	{
		return custId;
	}
	public void setCustName(String custName) 
	{
		this.custName = custName;
	}

	public String getCustName() 
	{
		return custName;
	}
	public void setLoginName(String loginName) 
	{
		this.loginName = loginName;
	}

	public String getLoginName() 
	{
		return loginName;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setCustPhone(String custPhone) 
	{
		this.custPhone = custPhone;
	}

	public String getCustPhone() 
	{
		return custPhone;
	}
	public void setCustType(Integer custType) 
	{
		this.custType = custType;
	}

	public Integer getCustType() 
	{
		return custType;
	}
	public void setCustProv(String custProv) 
	{
		this.custProv = custProv;
	}

	public String getCustProv() 
	{
		return custProv;
	}
	public void setCustCity(String custCity) 
	{
		this.custCity = custCity;
	}

	public String getCustCity() 
	{
		return custCity;
	}
	public void setCustArea(String custArea) 
	{
		this.custArea = custArea;
	}

	public String getCustArea() 
	{
		return custArea;
	}
	public void setCustAddr(String custAddr) 
	{
		this.custAddr = custAddr;
	}

	public String getCustAddr() 
	{
		return custAddr;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("custId", getCustId())
            .append("custName", getCustName())
            .append("loginName", getLoginName())
            .append("password", getPassword())
            .append("custPhone", getCustPhone())
            .append("custType", getCustType())
            .append("custProv", getCustProv())
            .append("custCity", getCustCity())
            .append("custArea", getCustArea())
            .append("custAddr", getCustAddr())
            .append("remark", getRemark())
            .toString();
    }
}

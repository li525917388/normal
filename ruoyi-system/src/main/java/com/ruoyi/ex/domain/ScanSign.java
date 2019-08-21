package com.ruoyi.ex.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 签收表 ex_scan_sign
 * 
 * @author Li Dehuan
 * @date 2019-07-16
 */
public class ScanSign extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 运单编号 */
	private String waybillNo;
	/** 派送人 */
	private Integer deliveryUserId;
	/** 签收人 */
	private String signer;
	/** 签收时间 */
	private Date signTime;
	/** 签收网点 */
	private Long signDeptId;

	/** 代收货款 */
	private BigDecimal cod;
	/** 代签标识 */
	private Integer proxyFlag;
	/** 服务类型 */
	private Integer serviceType;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setWaybillNo(String waybillNo) 
	{
		this.waybillNo = waybillNo;
	}

	public String getWaybillNo() 
	{
		return waybillNo;
	}
	public void setDeliveryUserId(Integer deliveryUserId) 
	{
		this.deliveryUserId = deliveryUserId;
	}

	public Integer getDeliveryUserId() 
	{
		return deliveryUserId;
	}
	public void setSigner(String signer) 
	{
		this.signer = signer;
	}

	public String getSigner() 
	{
		return signer;
	}
	public void setSignTime(Date signTime) 
	{
		this.signTime = signTime;
	}

	public Date getSignTime() 
	{
		return signTime;
	}
	public void setSignDeptId(Long signDeptId) 
	{
		this.signDeptId = signDeptId;
	}

	public Long getSignDeptId() 
	{
		return signDeptId;
	}
	
	public void setCod(BigDecimal cod) 
	{
		this.cod = cod;
	}

	public BigDecimal getCod() 
	{
		return cod;
	}
	public void setProxyFlag(Integer proxyFlag) 
	{
		this.proxyFlag = proxyFlag;
	}

	public Integer getProxyFlag() 
	{
		return proxyFlag;
	}
	public void setServiceType(Integer serviceType) 
	{
		this.serviceType = serviceType;
	}

	public Integer getServiceType() 
	{
		return serviceType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("waybillNo", getWaybillNo())
            .append("deliveryUserId", getDeliveryUserId())
            .append("signer", getSigner())
            .append("signTime", getSignTime())
            .append("signDeptId", getSignDeptId())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("remark", getRemark())
            .append("cod", getCod())
            .append("proxyFlag", getProxyFlag())
            .append("serviceType", getServiceType())
            .toString();
    }
}

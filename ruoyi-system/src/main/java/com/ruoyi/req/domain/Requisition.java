package com.ruoyi.req.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 申购表 req_requisition
 * 
 * @author Li Dehuan
 * @date 2019-04-12
 */
public class Requisition extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 申购编号 */
	private String reqCode;
	/** 物料编号 */
	private String matCode;
	/** 数量 */
	private Integer quantity;
	/** 单价 */
	private BigDecimal unitPrice;
	/** 金额 */
	private BigDecimal money;
	/** 备注 */
	private String remark;
	/** 状态 */
	private String status;
	/** 申请人 */
	private Long applyEmp;
	/** 申请时间 */
	private Date applyDate;
	/** 申请网点 */
	private Long applySite;

	public void setReqCode(String reqCode) 
	{
		this.reqCode = reqCode;
	}

	public String getReqCode() 
	{
		return reqCode;
	}
	public void setMatCode(String matCode) 
	{
		this.matCode = matCode;
	}

	public String getMatCode() 
	{
		return matCode;
	}
	public void setQuantity(Integer quantity) 
	{
		this.quantity = quantity;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}
	public void setUnitPrice(BigDecimal unitPrice) 
	{
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUnitPrice() 
	{
		return unitPrice;
	}
	public void setMoney(BigDecimal money) 
	{
		this.money = money;
	}

	public BigDecimal getMoney() 
	{
		return money;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setApplyEmp(Long applyEmp) 
	{
		this.applyEmp = applyEmp;
	}

	public Long getApplyEmp() 
	{
		return applyEmp;
	}
	public void setApplyDate(Date applyDate) 
	{
		this.applyDate = applyDate;
	}

	public Date getApplyDate() 
	{
		return applyDate;
	}
	public void setApplySite(Long applySite) 
	{
		this.applySite = applySite;
	}

	public Long getApplySite() 
	{
		return applySite;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("reqCode", getReqCode())
            .append("matCode", getMatCode())
            .append("quantity", getQuantity())
            .append("unitPrice", getUnitPrice())
            .append("money", getMoney())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("applyEmp", getApplyEmp())
            .append("applyDate", getApplyDate())
            .append("applySite", getApplySite())
            .toString();
    }
}

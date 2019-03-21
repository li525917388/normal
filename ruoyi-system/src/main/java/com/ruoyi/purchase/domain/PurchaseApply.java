package com.ruoyi.purchase.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购申请表 purchase_apply
 * 
 * @author Li Dehuan
 * @date 2019-03-22
 */
public class PurchaseApply extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 申请编号 */
	private String applyNo;
	/** 物资编号 */
	private String matCode;
	/** 申请日期 */
	private Date applyDate;
	/** 申请人 */
	private String applicant;
	/** 申请部门 */
	private String applyDept;
	/** 状态 */
	private String status;
	/** 申请数量 */
	private Integer quantity;
	/** 单价 */
	private BigDecimal unitPrice;
	/** 申请金额 */
	private BigDecimal applyAmount;
	/** 备注 */
	private String remark;

	public void setApplyNo(String applyNo) 
	{
		this.applyNo = applyNo;
	}

	public String getApplyNo() 
	{
		return applyNo;
	}
	public void setMatCode(String matCode) 
	{
		this.matCode = matCode;
	}

	public String getMatCode() 
	{
		return matCode;
	}
	public void setApplyDate(Date applyDate) 
	{
		this.applyDate = applyDate;
	}

	public Date getApplyDate() 
	{
		return applyDate;
	}
	public void setApplicant(String applicant) 
	{
		this.applicant = applicant;
	}

	public String getApplicant() 
	{
		return applicant;
	}
	public void setApplyDept(String applyDept) 
	{
		this.applyDept = applyDept;
	}

	public String getApplyDept() 
	{
		return applyDept;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
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
	public void setApplyAmount(BigDecimal applyAmount) 
	{
		this.applyAmount = applyAmount;
	}

	public BigDecimal getApplyAmount() 
	{
		return applyAmount;
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
            .append("applyNo", getApplyNo())
            .append("matCode", getMatCode())
            .append("applyDate", getApplyDate())
            .append("applicant", getApplicant())
            .append("applyDept", getApplyDept())
            .append("status", getStatus())
            .append("quantity", getQuantity())
            .append("unitPrice", getUnitPrice())
            .append("applyAmount", getApplyAmount())
            .append("remark", getRemark())
            .toString();
    }
}

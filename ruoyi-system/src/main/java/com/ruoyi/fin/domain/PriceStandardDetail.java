package com.ruoyi.fin.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;


/**
 * 标准报价明细表 fin_price_standard_detail
 * 
 * @author Li Dehuan
 * @date 2019-07-02
 */
public class PriceStandardDetail extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 报价id */
	private Long priceId;
	/** 范围 */
	private String range;
	/** 公式 */
	private String formula;
	/** 备注 */
	private String remark;
	/** 序号 */
	private Integer sortNo;
	
	private BigDecimal minWeight;	// 最小重量
	
	private BigDecimal maxWeight;	// 最大重量
	
	private Integer minType;		// 是否包含最小值
	
	private Integer maxType;		// 是否包含最大值

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setPriceId(Long priceId) 
	{
		this.priceId = priceId;
	}

	public Long getPriceId() 
	{
		return priceId;
	}
	public void setRange(String range) 
	{
		this.range = range;
	}

	public String getRange() 
	{
		return range;
	}
	public void setFormula(String formula) 
	{
		this.formula = formula;
	}

	public String getFormula() 
	{
		return formula;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setSortNo(Integer sortNo) 
	{
		this.sortNo = sortNo;
	}

	public Integer getSortNo() 
	{
		return sortNo;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("priceId", getPriceId())
            .append("range", getRange())
            .append("formula", getFormula())
            .append("remark", getRemark())
            .append("sortNo", getSortNo())
            .toString();
    }

	public BigDecimal getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(BigDecimal minWeight) {
		this.minWeight = minWeight;
	}

	public BigDecimal getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Integer getMinType() {
		return minType;
	}

	public void setMinType(Integer minType) {
		this.minType = minType;
	}

	public Integer getMaxType() {
		return maxType;
	}

	public void setMaxType(Integer maxType) {
		this.maxType = maxType;
	}
}

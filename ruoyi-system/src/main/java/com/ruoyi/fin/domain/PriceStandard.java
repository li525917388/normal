package com.ruoyi.fin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;


/**
 * 标准报价表 fin_price_standard
 * 
 * @author Li Dehuan
 * @date 2019-06-20
 */
public class PriceStandard extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 寄件地 */
	private String sendArea;
	/** 寄件地名称 */
	private String sendAreaName;
	/** 收件地 */
	private String receiveArea;
	/** 收件地名称 */
	private String receiveAreaName;
	/** 费用类别 */
	private Integer priceType;
	/** 服务方式 */
	private Integer serverType;
	/** 物品类别 */
	private String goodsType;
	/** 重量模式 */
	private Integer weightMode;
	/** 备注 */
	private String remark;
	/** 有效期开始时间 */
	private Date validTimeStart;
	/** 有效期结束时间 */
	private Date validTimeEnd;
	/** 有效值 */
	private Integer valid;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setSendArea(String sendArea) 
	{
		this.sendArea = sendArea;
	}

	public String getSendArea() 
	{
		return sendArea;
	}
	public void setReceiveArea(String receiveArea) 
	{
		this.receiveArea = receiveArea;
	}

	public String getReceiveArea() 
	{
		return receiveArea;
	}
	public void setPriceType(Integer priceType) 
	{
		this.priceType = priceType;
	}

	public Integer getPriceType() 
	{
		return priceType;
	}
	public void setServerType(Integer serverType) 
	{
		this.serverType = serverType;
	}

	public Integer getServerType() 
	{
		return serverType;
	}
	public void setGoodsType(String goodsType) 
	{
		this.goodsType = goodsType;
	}

	public String getGoodsType() 
	{
		return goodsType;
	}
	public void setWeightMode(Integer weightMode) 
	{
		this.weightMode = weightMode;
	}

	public Integer getWeightMode() 
	{
		return weightMode;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setValidTimeStart(Date validTimeStart) 
	{
		this.validTimeStart = validTimeStart;
	}

	public Date getValidTimeStart() 
	{
		return validTimeStart;
	}
	public void setValidTimeEnd(Date validTimeEnd) 
	{
		this.validTimeEnd = validTimeEnd;
	}

	public Date getValidTimeEnd() 
	{
		return validTimeEnd;
	}
	public void setValid(Integer valid) 
	{
		this.valid = valid;
	}

	public Integer getValid() 
	{
		return valid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sendArea", getSendArea())
            .append("receiveArea", getReceiveArea())
            .append("priceType", getPriceType())
            .append("serverType", getServerType())
            .append("goodsType", getGoodsType())
            .append("weightMode", getWeightMode())
            .append("remark", getRemark())
            .append("validTimeStart", getValidTimeStart())
            .append("validTimeEnd", getValidTimeEnd())
            .append("valid", getValid())
            .toString();
    }

	public String getSendAreaName() {
		return sendAreaName;
	}

	public void setSendAreaName(String sendAreaName) {
		this.sendAreaName = sendAreaName;
	}

	public String getReceiveAreaName() {
		return receiveAreaName;
	}

	public void setReceiveAreaName(String receiveAreaName) {
		this.receiveAreaName = receiveAreaName;
	}
}

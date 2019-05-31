package com.ruoyi.ex.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 运单表 ex_waybill
 * 
 * @author Li Dehuan
 * @date 2019-05-31
 */
public class Waybill extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 运单id */
	private Long waybillId;
	/** 运单号 */
	private String waybillNo;
	/** 订单ID */
	private Long orderId;
	/** 运单状态 */
	private Integer waybillStatus;
	/** 寄件日期 */
	private Date sendDate;
	/** 收件人姓名 */
	private String receiverName;
	/** 收件人电话 */
	private String receiverPhone;
	/** 收件重量 */
	private BigDecimal weight;
	/** 物品名称 */
	private String goodsName;
	/** 体积 */
	private String volume;

	public void setWaybillId(Long waybillId) 
	{
		this.waybillId = waybillId;
	}

	public Long getWaybillId() 
	{
		return waybillId;
	}
	public void setWaybillNo(String waybillNo) 
	{
		this.waybillNo = waybillNo;
	}

	public String getWaybillNo() 
	{
		return waybillNo;
	}
	public void setOrderId(Long orderId) 
	{
		this.orderId = orderId;
	}

	public Long getOrderId() 
	{
		return orderId;
	}
	public void setWaybillStatus(Integer waybillStatus) 
	{
		this.waybillStatus = waybillStatus;
	}

	public Integer getWaybillStatus() 
	{
		return waybillStatus;
	}
	public void setSendDate(Date sendDate) 
	{
		this.sendDate = sendDate;
	}

	public Date getSendDate() 
	{
		return sendDate;
	}
	public void setReceiverName(String receiverName) 
	{
		this.receiverName = receiverName;
	}

	public String getReceiverName() 
	{
		return receiverName;
	}
	public void setReceiverPhone(String receiverPhone) 
	{
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverPhone() 
	{
		return receiverPhone;
	}
	public void setWeight(BigDecimal weight) 
	{
		this.weight = weight;
	}

	public BigDecimal getWeight() 
	{
		return weight;
	}
	public void setGoodsName(String goodsName) 
	{
		this.goodsName = goodsName;
	}

	public String getGoodsName() 
	{
		return goodsName;
	}
	public void setVolume(String volume) 
	{
		this.volume = volume;
	}

	public String getVolume() 
	{
		return volume;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("waybillId", getWaybillId())
            .append("waybillNo", getWaybillNo())
            .append("orderId", getOrderId())
            .append("waybillStatus", getWaybillStatus())
            .append("sendDate", getSendDate())
            .append("receiverName", getReceiverName())
            .append("receiverPhone", getReceiverPhone())
            .append("weight", getWeight())
            .append("goodsName", getGoodsName())
            .append("volume", getVolume())
            .toString();
    }
}

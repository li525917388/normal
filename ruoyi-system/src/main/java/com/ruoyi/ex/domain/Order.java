package com.ruoyi.ex.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 订单表 ex_order
 * 
 * @author Li Dehuan
 * @date 2019-05-28
 */
public class Order extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 订单id */
	private Long orderid;
	/** 订单号 */
	private String orderNo;
	/** 订单日期 */
	private Date orderDate;
	/** 电商id */
	private String ecCompanyId;
	/** 订单状态 */
	private Integer orderStatus;
	/** 订单来源 */
	private String orderSource;
	/** 客户ID */
	private Long custId;
	/** 客户姓名 */
	private String custName;
	/** 寄件人姓名 */
	private String senderName;
	/** 寄件人电话 */
	private String senderPhone;
	/** 寄件省 */
	private String senderProv;
	/** 寄件市 */
	private String senderCity;
	/** 寄件区/县 */
	private String senderArea;
	/** 寄件乡/镇/街 */
	private String senderTown;
	/** 寄件详细地址 */
	private String senderAddr;
	/** 寄件邮编 */
	private Integer senderPost;
	/** 收件人 */
	private String receiverName;
	/** 收件电话 */
	private String receiverPhone;
	/** 收件省 */
	private String receiverProv;
	/** 收件市 */
	private String receiverCity;
	/** 收件区/县 */
	private String receiverArea;
	/** 收件乡/镇/街 */
	private String receiverTown;
	/** 收件详细地址 */
	private String receiverAddr;
	/** 收件邮编 */
	private Integer receiverPost;
	/** 运费 */
	private BigDecimal deliverMoney;
	/** 物品价值 */
	private BigDecimal goodsMoney;
	/** 物品数量 */
	private Integer goodsNum;
	/** 重量 */
	private BigDecimal weight;
	/** 支付方式 */
	private Integer payType;
	
	/** 调度部门id（网点） */
	private Long dispDeptId;
	
	/** 调度给用户ID（业务员） */
	private Long dispUserId;

	public void setOrderid(Long orderid) 
	{
		this.orderid = orderid;
	}

	public Long getOrderid() 
	{
		return orderid;
	}
	public void setOrderNo(String orderNo) 
	{
		this.orderNo = orderNo;
	}

	public String getOrderNo() 
	{
		return orderNo;
	}
	public void setOrderDate(Date orderDate) 
	{
		this.orderDate = orderDate;
	}

	public Date getOrderDate() 
	{
		return orderDate;
	}
	public void setEcCompanyId(String ecCompanyId) 
	{
		this.ecCompanyId = ecCompanyId;
	}

	public String getEcCompanyId() 
	{
		return ecCompanyId;
	}
	public void setOrderStatus(Integer orderStatus) 
	{
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatus() 
	{
		return orderStatus;
	}
	public void setOrderSource(String orderSource) 
	{
		this.orderSource = orderSource;
	}

	public String getOrderSource() 
	{
		return orderSource;
	}
	public void setCustId(Long custId) 
	{
		this.custId = custId;
	}

	public Long getCustId() 
	{
		return custId;
	}
	public void setSenderName(String senderName) 
	{
		this.senderName = senderName;
	}

	public String getSenderName() 
	{
		return senderName;
	}
	public void setSenderPhone(String senderPhone) 
	{
		this.senderPhone = senderPhone;
	}

	public String getSenderPhone() 
	{
		return senderPhone;
	}
	public void setSenderProv(String senderProv) 
	{
		this.senderProv = senderProv;
	}

	public String getSenderProv() 
	{
		return senderProv;
	}
	public void setSenderCity(String senderCity) 
	{
		this.senderCity = senderCity;
	}

	public String getSenderCity() 
	{
		return senderCity;
	}
	public void setSenderArea(String senderArea) 
	{
		this.senderArea = senderArea;
	}

	public String getSenderArea() 
	{
		return senderArea;
	}
	public void setSenderTown(String senderTown) 
	{
		this.senderTown = senderTown;
	}

	public String getSenderTown() 
	{
		return senderTown;
	}
	public void setSenderAddr(String senderAddr) 
	{
		this.senderAddr = senderAddr;
	}

	public String getSenderAddr() 
	{
		return senderAddr;
	}
	public void setSenderPost(Integer senderPost) 
	{
		this.senderPost = senderPost;
	}

	public Integer getSenderPost() 
	{
		return senderPost;
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
	public void setReceiverProv(String receiverProv) 
	{
		this.receiverProv = receiverProv;
	}

	public String getReceiverProv() 
	{
		return receiverProv;
	}
	public void setReceiverCity(String receiverCity) 
	{
		this.receiverCity = receiverCity;
	}

	public String getReceiverCity() 
	{
		return receiverCity;
	}
	public void setReceiverArea(String receiverArea) 
	{
		this.receiverArea = receiverArea;
	}

	public String getReceiverArea() 
	{
		return receiverArea;
	}
	public void setReceiverTown(String receiverTown) 
	{
		this.receiverTown = receiverTown;
	}

	public String getReceiverTown() 
	{
		return receiverTown;
	}
	public void setReceiverAddr(String receiverAddr) 
	{
		this.receiverAddr = receiverAddr;
	}

	public String getReceiverAddr() 
	{
		return receiverAddr;
	}
	public void setReceiverPost(Integer receiverPost) 
	{
		this.receiverPost = receiverPost;
	}

	public Integer getReceiverPost() 
	{
		return receiverPost;
	}
	public void setDeliverMoney(BigDecimal deliverMoney) 
	{
		this.deliverMoney = deliverMoney;
	}

	public BigDecimal getDeliverMoney() 
	{
		return deliverMoney;
	}
	public void setGoodsMoney(BigDecimal goodsMoney) 
	{
		this.goodsMoney = goodsMoney;
	}

	public BigDecimal getGoodsMoney() 
	{
		return goodsMoney;
	}
	public void setGoodsNum(Integer goodsNum) 
	{
		this.goodsNum = goodsNum;
	}

	public Integer getGoodsNum() 
	{
		return goodsNum;
	}
	public void setWeight(BigDecimal weight) 
	{
		this.weight = weight;
	}

	public BigDecimal getWeight() 
	{
		return weight;
	}
	public void setPayType(Integer payType) 
	{
		this.payType = payType;
	}

	public Integer getPayType() 
	{
		return payType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderid", getOrderid())
            .append("orderNo", getOrderNo())
            .append("orderDate", getOrderDate())
            .append("ecCompanyId", getEcCompanyId())
            .append("orderStatus", getOrderStatus())
            .append("orderSource", getOrderSource())
            .append("custId", getCustId())
            .append("senderName", getSenderName())
            .append("senderPhone", getSenderPhone())
            .append("senderProv", getSenderProv())
            .append("senderCity", getSenderCity())
            .append("senderArea", getSenderArea())
            .append("senderTown", getSenderTown())
            .append("senderAddr", getSenderAddr())
            .append("senderPost", getSenderPost())
            .append("receiverName", getReceiverName())
            .append("receiverPhone", getReceiverPhone())
            .append("receiverProv", getReceiverProv())
            .append("receiverCity", getReceiverCity())
            .append("receiverArea", getReceiverArea())
            .append("receiverTown", getReceiverTown())
            .append("receiverAddr", getReceiverAddr())
            .append("receiverPost", getReceiverPost())
            .append("deliverMoney", getDeliverMoney())
            .append("goodsMoney", getGoodsMoney())
            .append("goodsNum", getGoodsNum())
            .append("weight", getWeight())
            .append("payType", getPayType())
            .toString();
    }

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getDispDeptId() {
		return dispDeptId;
	}

	public void setDispDeptId(Long dispDeptId) {
		this.dispDeptId = dispDeptId;
	}

	public Long getDispUserId() {
		return dispUserId;
	}

	public void setDispUserId(Long dispUserId) {
		this.dispUserId = dispUserId;
	}
}

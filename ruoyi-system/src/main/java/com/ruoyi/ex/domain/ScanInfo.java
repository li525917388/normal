package com.ruoyi.ex.domain;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 扫描信息实体
 * @author Li Dehuan
 * @date 2019年6月4日
 *
 */
public class ScanInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3559822297659934611L;

	private Long scanId;			//扫描ID
	
	private String waybillNo;		//运单编号
	
	private Integer scanType;		//扫描类型
	
	private Date scanTime;			//扫描时间
	
	private Long scanUserId;		//扫描员工ID
	
	private String scanUser;		//扫描员工姓名
	
	private Long scanDeptId;		//扫描网点ID
	
	private String scanDept;		//扫描网点名称
	
	private String remark;			//备注
	
	private Long nextDeptId;		//上一站或下一站
	
	private String nextDept;		//上一站或下一站名称
		
	private Long deliveryUserId;	//派送人id
	
	private String deliveryUser;	//派送人名称
	
	private String signer;			//签收人

	public Long getScanId() {
		return scanId;
	}

	public void setScanId(Long scanId) {
		this.scanId = scanId;
	}

	public String getWaybillNo() {
		return waybillNo;
	}

	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}

	public Integer getScanType() {
		return scanType;
	}

	public void setScanType(Integer scanType) {
		this.scanType = scanType;
	}

	public Date getScanTime() {
		return scanTime;
	}

	public void setScanTime(Date scanTime) {
		this.scanTime = scanTime;
	}

	public Long getScanUserId() {
		return scanUserId;
	}

	public void setScanUserId(Long scanUserId) {
		this.scanUserId = scanUserId;
	}

	public Long getScanDeptId() {
		return scanDeptId;
	}

	public void setScanDeptId(Long scanDeptId) {
		this.scanDeptId = scanDeptId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getNextDeptId() {
		return nextDeptId;
	}

	public void setNextDeptId(Long nextDeptId) {
		this.nextDeptId = nextDeptId;
	}

	public Long getDeliveryUserId() {
		return deliveryUserId;
	}

	public void setDeliveryUserId(Long deliveryUserId) {
		this.deliveryUserId = deliveryUserId;
	}

	public String getSigner() {
		return signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getScanUser() {
		return scanUser;
	}

	public void setScanUser(String scanUser) {
		this.scanUser = scanUser;
	}

	public String getScanDept() {
		return scanDept;
	}

	public void setScanDept(String scanDept) {
		this.scanDept = scanDept;
	}

	public String getNextDept() {
		return nextDept;
	}

	public void setNextDept(String nextDept) {
		this.nextDept = nextDept;
	}

	public String getDeliveryUser() {
		return deliveryUser;
	}

	public void setDeliveryUser(String deliveryUser) {
		this.deliveryUser = deliveryUser;
	}
	
}

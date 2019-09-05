package com.ruoyi.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;


/**
 * 电商-公司表 base_ec_company
 * 
 * @author Li Dehuan
 * @date 2019-09-04
 */
public class EcCompany extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 电商编号 */
	private String ecCompanyId;
	/** 电商名称 */
	private String ecCompanyName;
	/** 电商对接秘钥 */
	private String secretKey;
	/** 创建时间 */
	private Date createTime;
	/** 备注 */
	private String remark;
	/** 有效值 */
	private Integer valid;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setEcCompanyId(String ecCompanyId) {
		this.ecCompanyId = ecCompanyId;
	}

	public String getEcCompanyId() {
		return ecCompanyId;
	}
	public void setEcCompanyName(String ecCompanyName) {
		this.ecCompanyName = ecCompanyName;
	}

	public String getEcCompanyName() {
		return ecCompanyName;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getSecretKey() {
		return secretKey;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getValid() {
		return valid;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ecCompanyId", getEcCompanyId())
            .append("ecCompanyName", getEcCompanyName())
            .append("secretKey", getSecretKey())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("valid", getValid())
            .toString();
    }
}

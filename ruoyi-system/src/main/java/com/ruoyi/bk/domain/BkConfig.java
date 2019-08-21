package com.ruoyi.bk.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;


/**
 * 博客项目参数表 bk_config
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
public class BkConfig extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 参数名称 */
	private String configName;
	/** 参数键名 */
	private String configKey;
	/** 参数值 */
	private String configValue;
	/** 有效值 */
	private Integer valid;
	/** 备注 */
	private String remark;
	/** 创建时间 */
	private Date createDate;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigName() {
		return configName;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigKey() {
		return configKey;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getConfigValue() {
		return configValue;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getValid() {
		return valid;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}


	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("configName", getConfigName())
            .append("configKey", getConfigKey())
            .append("configValue", getConfigValue())
            .append("valid", getValid())
            .append("remark", getRemark())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .toString();
    }
}

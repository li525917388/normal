package com.ruoyi.bk.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;


/**
 * 我们的服务表 bk_we_service
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
public class BkWeService extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 标题 */
	private String title;
	/** 描述 */
	private String desc;
	/** 图标 */
	private String icon;
	/** 顺序 */
	private Integer order;
	/** 有效值 */
	private Integer valid;
	/** 创建时间 */
	private Date createTime;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getOrder() {
		return order;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getValid() {
		return valid;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("desc", getDesc())
            .append("icon", getIcon())
            .append("order", getOrder())
            .append("valid", getValid())
            .append("createTime", getCreateTime())
            .toString();
    }
}

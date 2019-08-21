package com.ruoyi.bk.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;


/**
 * 影集表 bk_album
 * 
 * @author Li Dehuan
 * @date 2019-07-25
 */
public class BkAlbum extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 标题 */
	private String title;
	/** 内容描述 */
	private String content;
	/** 图片地址 */
	private String imgUrl;
	/** 有效值 */
	private Integer valid;
	/** 创建时间 */
	private Date createDate;
	/** 1 */
	private Integer sortNo;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getValid() {
		return valid;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("imgUrl", getImgUrl())
            .append("valid", getValid())
            .append("createDate", getCreateDate())
            .append("sortNo", getSortNo())
            .toString();
    }
}

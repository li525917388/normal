package com.ruoyi.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 供应商表 base_supplier
 * 
 * @author Li Dehuan
 * @date 2019-03-20
 */
public class Supplier extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 供应商编号 */
	private String supCode;
	/** 供应商名称 */
	private String supName;
	/** 供应商地址 */
	private String supAddress;
	/** 供应商电话 */
	private String supPhone;
	/** 创建时间 */
	private Date createTime;
	/** 编辑时间 */
	private Date editTime;
	/** 公司名称 */
	private String compName;
	/** 联系人 */
	private String contact;
	/** 有效值 */
	@Excel(name = "有效值", readConverterExp = "1=正常,0=停用")
	private String valid;
	/** 数据来源 */
	private String dataSource;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setSupCode(String supCode) 
	{
		this.supCode = supCode;
	}

	public String getSupCode() 
	{
		return supCode;
	}
	public void setSupName(String supName) 
	{
		this.supName = supName;
	}

	public String getSupName() 
	{
		return supName;
	}
	public void setSupAddress(String supAddress) 
	{
		this.supAddress = supAddress;
	}

	public String getSupAddress() 
	{
		return supAddress;
	}
	public void setSupPhone(String supPhone) 
	{
		this.supPhone = supPhone;
	}

	public String getSupPhone() 
	{
		return supPhone;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setEditTime(Date editTime) 
	{
		this.editTime = editTime;
	}

	public Date getEditTime() 
	{
		return editTime;
	}
	public void setCompName(String compName) 
	{
		this.compName = compName;
	}

	public String getCompName() 
	{
		return compName;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}

	public String getContact() 
	{
		return contact;
	}
	public void setValid(String valid) 
	{
		this.valid = valid;
	}

	public String getValid() 
	{
		return valid;
	}
	public void setDataSource(String dataSource) 
	{
		this.dataSource = dataSource;
	}

	public String getDataSource() 
	{
		return dataSource;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supCode", getSupCode())
            .append("supName", getSupName())
            .append("supAddress", getSupAddress())
            .append("supPhone", getSupPhone())
            .append("createTime", getCreateTime())
            .append("editTime", getEditTime())
            .append("compName", getCompName())
            .append("contact", getContact())
            .append("valid", getValid())
            .append("dataSource", getDataSource())
            .toString();
    }
}

package com.ruoyi.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物资表 base_material
 * 
 * @author Li Dehuan
 * @date 2019-03-19
 */
public class Material extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 物资编码 */
	private String matCode;
	/** 物资名称 */
	private String matName;
	/** 物资类型 */
	private String matType;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setMatCode(String matCode) 
	{
		this.matCode = matCode;
	}

	public String getMatCode() 
	{
		return matCode;
	}
	public void setMatName(String matName) 
	{
		this.matName = matName;
	}

	public String getMatName() 
	{
		return matName;
	}
	public void setMatType(String matType) 
	{
		this.matType = matType;
	}

	public String getMatType() 
	{
		return matType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("matCode", getMatCode())
            .append("matName", getMatName())
            .append("matType", getMatType())
            .toString();
    }
}

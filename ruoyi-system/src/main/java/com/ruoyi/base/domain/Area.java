package com.ruoyi.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;


/**
 * 地区码表 base_area
 * 
 * @author Li Dehuan
 * @date 2019-06-11
 */
public class Area extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 地区Id */
	private Integer areaId;
	/** 地区编码 */
	private String areaCode;
	/** 地区名 */
	private String areaName;
	/** 地区级别（1:省份province,2:市city,3:区县district,4:街道street） */
	private Integer level;
	/** 城市编码 */
	private String cityCode;
	/** 城市中心点（即：经纬度坐标） */
	private String center;
	/** 地区父节点 */
	private Integer parentId;

	public void setAreaId(Integer areaId) 
	{
		this.areaId = areaId;
	}

	public Integer getAreaId() 
	{
		return areaId;
	}
	public void setAreaCode(String areaCode) 
	{
		this.areaCode = areaCode;
	}

	public String getAreaCode() 
	{
		return areaCode;
	}
	public void setAreaName(String areaName) 
	{
		this.areaName = areaName;
	}

	public String getAreaName() 
	{
		return areaName;
	}
	public void setLevel(Integer level) 
	{
		this.level = level;
	}

	public Integer getLevel() 
	{
		return level;
	}
	public void setCityCode(String cityCode) 
	{
		this.cityCode = cityCode;
	}

	public String getCityCode() 
	{
		return cityCode;
	}
	public void setCenter(String center) 
	{
		this.center = center;
	}

	public String getCenter() 
	{
		return center;
	}
	public void setParentId(Integer parentId) 
	{
		this.parentId = parentId;
	}

	public Integer getParentId() 
	{
		return parentId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("areaId", getAreaId())
            .append("areaCode", getAreaCode())
            .append("areaName", getAreaName())
            .append("level", getLevel())
            .append("cityCode", getCityCode())
            .append("center", getCenter())
            .append("parentId", getParentId())
            .toString();
    }
}

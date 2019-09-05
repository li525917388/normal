package com.ruoyi.system.domain;

import java.util.Date;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 网站访问计数器实体
 * @author Li Dehuan
 * @date 2019年8月21日
 *
 */
public class SysWebCount extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Excel(name = "网站编号")
	private String apiCode;			// 网站编号
	
	@Excel(name = "网站名称")
	private String apiName;			// 网站名称
	
	@Excel(name = "总数")
	private Long count;				// 总数
	
	@Excel(name = "错误总数")
	private Long errorCount;		// 错误总数
	
	@Excel(name = "最后登陆时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
	private Date updateDate;		// 最后更新时间

	public String getApiCode() {
		return apiCode;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Long errorCount) {
		this.errorCount = errorCount;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}

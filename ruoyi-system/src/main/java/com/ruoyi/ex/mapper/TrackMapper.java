package com.ruoyi.ex.mapper;

import java.util.List;

import com.ruoyi.ex.domain.ScanInfo;

/**
 * 快件跟踪mapper
 * @author Li Dehuan
 * @date 2019年6月5日
 *
 */
public interface TrackMapper {

	
	/**
	 * 获取扫描信息
	 * @return
	 */
	List<ScanInfo> selectScanInfoList(String waybillNo);
	
}

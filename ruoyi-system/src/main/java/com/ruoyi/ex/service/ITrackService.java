package com.ruoyi.ex.service;

import java.util.List;

import com.ruoyi.ex.domain.Track;

/**
 * 快件跟踪service
 * @author Li Dehuan
 * @date 2019年6月5日
 *
 */
public interface ITrackService {

	
	/**
	 * 快件跟踪查询
	 * @param no 单号
	 * @param noType 单号类型。waybill=运单号（默认），orderno=订单号，bagno=袋号
	 * @return
	 */
	List<Track> selectTrackList(String no, String noType);
	

}

package com.ruoyi.ex.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.ex.domain.ScanInfo;
import com.ruoyi.ex.domain.Track;
import com.ruoyi.ex.mapper.TrackMapper;
import com.ruoyi.ex.service.ITrackService;


/**
 * 快件跟踪service实现类
 * @author Li Dehuan
 * @date 2019年6月5日
 *
 */
@Service
public class TrackServiceImpl implements ITrackService {

	@Autowired
	TrackMapper trackMapper;
	
	
	/*
	 * 快件跟踪查询
	 * @see com.ruoyi.ex.service.ITrackService#selectTrackList(java.lang.String, java.lang.String)
	 * 2019年6月5日
	 */
	@Override
	public List<Track> selectTrackList(String no, String noType) {
		List<Track> list = new ArrayList<Track>();
		
		List<ScanInfo> scanInfos = trackMapper.selectScanInfoList(no);
		
		//遍历扫描信息
		for(ScanInfo scanInfo : scanInfos){
			
			Track track = scanChangeTrack(scanInfo);
			
			list.add(track);
		}
		
		return list;
	}


	
	/**
	 * 扫描信息转换跟踪信息
	 * @param scanInfo
	 * @return
	 */
	private Track scanChangeTrack(ScanInfo scanInfo) {
		Track track = new Track();
		track.setOpTime(scanInfo.getScanTime());//扫描时间
		
		switch (scanInfo.getScanType()) {
		case 10:
			track.setOpType("已揽件");
			track.setContent("【" + scanInfo.getScanDept() + "】的收件员 【" + scanInfo.getScanUser() + "】 已揽件");
			break;
			
		case 20:
			track.setOpType("发件");
			track.setContent("快件正由 【" + scanInfo.getScanDept() + "】 发往 【" + scanInfo.getNextDept() + "】 途中");
			break;

		case 30:
			track.setOpType("到件");
			track.setContent("快件已到达 【" + scanInfo.getScanDept() + "】");
			break;
			
		case 40:
			track.setOpType("派件");
			track.setContent("【" + scanInfo.getScanDept() + "】的派件员 " + scanInfo.getDeliveryUser() + " 正在派件");
			break;
			
		case 41:
			track.setOpType("自提件");
			track.setContent("自提件，请到 【" + scanInfo.getScanDept() + "】 自提，扫描员： " + scanInfo.getScanUser() + "");
			break;
			
		case 50:
			track.setOpType("签收");
			track.setContent("快件已签收，签收人：【 " + scanInfo.getSigner() + "】");
			break;
			
		default:
			track.setOpType(scanInfo.getScanType() + "");
			break;
		}
		
		return track;
	}

}

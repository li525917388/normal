package com.ruoyi.report.domain;

import java.util.List;
import java.util.Map;

public class MapReport<T> {

	private List<T> data;
	
	private Map<String, float[]> geoCoordMap;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Map<String, float[]> getGeoCoordMap() {
		return geoCoordMap;
	}

	public void setGeoCoordMap(Map<String, float[]> geoCoordMap) {
		this.geoCoordMap = geoCoordMap;
	}
	
	
}

package com.uni.cntr.gbp.dao;

import java.util.List;

import com.uni.cntr.gbp.vo.SalesGBPbyAccVO;

public interface SalesGBPbyAccDao {
	public List<SalesGBPbyAccVO> getAll(String sales, String trade, String bound, String route, String week, int diff);
	
}

package com.uni.cntr.gbp.dao;

import java.util.List;

import com.uni.cntr.gbp.vo.SalesGBPVO;

public interface SalesGBPDao {
	public List<SalesGBPVO> getAll(String sales);
	
	public List<SalesGBPVO> getAll(String sales, String week, int diff);
}

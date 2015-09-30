package com.uni.cntr.gbp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.cntr.gbp.dao.SalesGBPDao;
import com.uni.cntr.gbp.vo.SalesGBPVO;

@Service
public class SalesGBPService {

	@Autowired
	private SalesGBPDao salesGBPDao;
	
	public List<SalesGBPVO> getAll(String sales) {
		return salesGBPDao.getAll(sales);
	}
	
	public List<SalesGBPVO> getAll(String sales, String week, int diff) {
		return salesGBPDao.getAll(sales, week, diff);
	}
} 


package com.uni.cntr.gbp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.cntr.gbp.dao.SalesGBPbyAccDao;
import com.uni.cntr.gbp.vo.SalesGBPbyAccVO;

@Service
public class SalesGBPbyAccService {

	@Autowired
	private SalesGBPbyAccDao salesGBPbyAccDao;
	
	public List<SalesGBPbyAccVO> getAll(String sales, String trade, String bound, String route, String week, int diff) {
		return salesGBPbyAccDao.getAll(sales, trade, bound, route, week, diff);
	}

} 


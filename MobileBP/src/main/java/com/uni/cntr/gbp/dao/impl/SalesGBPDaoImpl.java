package com.uni.cntr.gbp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uni.cntr.gbp.dao.SalesGBPDao;
import com.uni.cntr.gbp.vo.SalesGBPVO;

@Repository
public class SalesGBPDaoImpl implements SalesGBPDao {

	@Override
	public List<SalesGBPVO> getAll(String sales) {
		// TODO Auto-generated method stub
		
		List<SalesGBPVO> list = new ArrayList<SalesGBPVO>();
		
		SalesGBPVO vo = new SalesGBPVO();
		vo.setTrade("US");
		vo.setBound("E");
		vo.setRoute("CC1");
		vo.setWk1_alo(95);
		vo.setWk1_bkg(86);
		vo.setWk1_bp(102);
		vo.setWeek("38");
		list.add(vo);
		
		vo = new SalesGBPVO();
		vo.setTrade("US");
		vo.setBound("E");
		vo.setRoute("CC2");
		vo.setWeek("38");
		vo.setWk1_alo(23);
		vo.setWk1_bkg(12);
		vo.setWk1_bp(9);
		list.add(vo);
		
		return list;
	}

	@Override
	public List<SalesGBPVO> getAll(String sales, String week, int diff) {
		List<SalesGBPVO> list = new ArrayList<SalesGBPVO>();
		
		SalesGBPVO vo = new SalesGBPVO();
		vo.setTrade("US");
		vo.setBound("E");
		vo.setRoute("CC4");
		vo.setWeek(String.valueOf(Integer.valueOf(week) + diff));
		vo.setWk1_alo(95);
		vo.setWk1_bkg(86);
		vo.setWk1_bp(102);
		list.add(vo);
		
		vo = new SalesGBPVO();
		vo.setTrade("US");
		vo.setBound("E");
		vo.setRoute("CC5");
		vo.setWeek(String.valueOf(Integer.valueOf(week) + diff));
		vo.setWk1_alo(123);
		vo.setWk1_bkg(423);
		vo.setWk1_bp(444);
		list.add(vo);
		
		vo = new SalesGBPVO();
		vo.setTrade("US");
		vo.setBound("E");
		vo.setRoute("CC5");
		vo.setWeek(String.valueOf(Integer.valueOf(week) + diff));
		vo.setWk1_alo(123);
		vo.setWk1_bkg(777);
		vo.setWk1_bp(777);
		list.add(vo);
		return list;
	}	

}

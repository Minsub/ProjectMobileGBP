package com.uni.cntr.gbp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uni.cntr.gbp.dao.SalesGBPDao;
import com.uni.cntr.gbp.util.Utils;
import com.uni.cntr.gbp.vo.SalesGBPVO;

@Repository
public class SalesGBPDaoImpl implements SalesGBPDao {

	@Override
	public List<SalesGBPVO> getAll(String sales) {
		return generate("201521", 0);
	}

	@Override
	public List<SalesGBPVO> getAll(String sales, String week, int diff) {
		
		return generate(week, diff);
	}	
	
	private List<SalesGBPVO> generate(String week, int diff) {
		List<SalesGBPVO> list = new ArrayList<SalesGBPVO>();
		
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		list.add(Utils.generateGBPVO(week, diff));
		
		return list;
	}

}

package com.uni.cntr.gbp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uni.cntr.gbp.dao.SalesGBPbyAccDao;
import com.uni.cntr.gbp.util.Utils;
import com.uni.cntr.gbp.vo.SalesGBPbyAccVO;

@Repository
public class SalesGBPbyAccDaoImpl implements SalesGBPbyAccDao {

	@Override
	public List<SalesGBPbyAccVO> getAll(String sales, String trade, String bound, String route, String week, int diff) {
		
		
		return generate(week, diff);
	}

	private List<SalesGBPbyAccVO> generate(String week, int diff) {
		List<SalesGBPbyAccVO> list = new ArrayList<SalesGBPbyAccVO>();
		
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		list.add(Utils.generateGBPbyAccVO(week, diff));
		
		return list;
	}
}

package com.uni.cntr.gbp;

import java.util.List;

import com.uni.cntr.gbp.dao.SalesGBPbyAccDao;
import com.uni.cntr.gbp.dao.impl.SalesGBPbyAccDaoImpl;
import com.uni.cntr.gbp.util.Utils;
import com.uni.cntr.gbp.vo.SalesGBPbyAccVO;

public class TestDao {

	public static void main(String[] args) {
		
//		SalesGBPDao dao = new SalesGBPDaoImpl();
//		
//		List<SalesGBPVO> list = dao.getAll(Utils.getDefaultSales());
		
		SalesGBPbyAccDao dao = new SalesGBPbyAccDaoImpl();
		
		List<SalesGBPbyAccVO> list = dao.getAll(Utils.getDefaultSales(), "US", "E", "CC1", "201541", 0);
	}

}

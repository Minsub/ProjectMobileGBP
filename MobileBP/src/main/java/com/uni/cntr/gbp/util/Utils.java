package com.uni.cntr.gbp.util;

import com.uni.cntr.gbp.vo.SalesGBPVO;
import com.uni.cntr.gbp.vo.SalesGBPbyAccVO;

public class Utils {
	private final static String DEFAULT_SALES = "0123";
	
	public static String getDefaultSales() {
		return DEFAULT_SALES;
	}
	
	public static SalesGBPbyAccVO generateGBPbyAccVO(String week, int diff) {
		String w1, w2, w3;
		if (diff == 1) {
			w1 = String.valueOf(Integer.valueOf(week) + 1);
			w2 = String.valueOf(Integer.valueOf(week) + 2);
			w3 = String.valueOf(Integer.valueOf(week) + 3);
		} else if(diff == -1){
			w1 = String.valueOf(Integer.valueOf(week) - 1);
			w2 = String.valueOf(Integer.valueOf(week) - 2);
			w3 = String.valueOf(Integer.valueOf(week) - 3);
		} else {
			w1 = String.valueOf(Integer.valueOf(week));
			w2 = String.valueOf(Integer.valueOf(week) + 1);
			w3 = String.valueOf(Integer.valueOf(week) + 2);
		}
		SalesGBPbyAccVO vo = new SalesGBPbyAccVO();
		vo.setAcc("KRTEST01");
		vo.setDesc("GLOVIS CO..");
		vo.setWeek1(w1);
		vo.setWk1_bkg(20);
		vo.setWk1_bp(23);
		vo.setWeek2(w2);
		vo.setWk2_bkg(24);
		vo.setWk2_bp(26);
		vo.setWeek3(w3);
		vo.setWk3_bkg(32);
		vo.setWk3_bp(45);
		
		return vo;
	}
	
	public static SalesGBPVO generateGBPVO(String week, int diff) {
		
		String w1, w2, w3;
		if (diff == 1) {
			w1 = String.valueOf(Integer.valueOf(week) + 1);
			w2 = String.valueOf(Integer.valueOf(week) + 2);
			w3 = String.valueOf(Integer.valueOf(week) + 3);
		} else if(diff == -1){
			w1 = String.valueOf(Integer.valueOf(week) - 1);
			w2 = String.valueOf(Integer.valueOf(week) - 2);
			w3 = String.valueOf(Integer.valueOf(week) - 3);
		} else {
			w1 = "201521";
			w2 = "201522";
			w3 = "201523";
		}
		SalesGBPVO vo = new SalesGBPVO();
		vo.setTrade("US");
		vo.setBound("E");
		vo.setRoute("CC1");
		vo.setWeek1(w1);
		vo.setWk1_alo(95);
		vo.setWk1_bkg(86);
		vo.setWk1_bp(102);
		vo.setWeek2(w2);
		vo.setWk2_alo(95);
		vo.setWk2_bkg(86);
		vo.setWk2_bp(102);
		vo.setWeek3(w3);
		vo.setWk3_alo(95);
		vo.setWk3_bkg(86);
		vo.setWk3_bp(102);
		
		return vo;
	}
}

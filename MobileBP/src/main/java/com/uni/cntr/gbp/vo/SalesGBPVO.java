package com.uni.cntr.gbp.vo;


public class SalesGBPVO {
	private String trade;		// 
	private String bound;		//  
	private String route;		// 
	private String week;
	
	private int    wk1_alo;     // Allo. (week1)
	private int    wk1_bkg;     // BKG.  (week1)
	private int    wk1_bp;      // BP.   (week1)
	
	
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getBound() {
		return bound;
	}
	public void setBound(String bound) {
		this.bound = bound;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public int getWk1_alo() {
		return wk1_alo;
	}
	public void setWk1_alo(int wk1_alo) {
		this.wk1_alo = wk1_alo;
	}
	public int getWk1_bkg() {
		return wk1_bkg;
	}
	public void setWk1_bkg(int wk1_bkg) {
		this.wk1_bkg = wk1_bkg;
	}
	public int getWk1_bp() {
		return wk1_bp;
	}
	public void setWk1_bp(int wk1_bp) {
		this.wk1_bp = wk1_bp;
	}

}

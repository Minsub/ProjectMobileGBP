package com.uni.education.vo;

import java.io.UnsupportedEncodingException;

public class RegistrationLectureVO {
	private String user_id;		//사용자 ID		
	private String lecture_id;	//강좌 ID
	private String rank;		//직급
	private int testscore;		//테스트 점수
	private String pass;		//수료여부 (Y/N)
	private String cancelation;	//취소여부 (Y/N)
	private String note;		//비고 (취소사유, 결석 사유 등)
	//Lecture INFO.
	private String lname;
	private String YMD_STD;
	private String YMD_END;
	private String days;
	private String credit;
	// User Info. (Teacher)
	private String uname;		//사용자 이름 
	private String utype;		//일반/개발 
	private String team;		//소속
	private String urank;		//직급
	
	public void encording() {
		try {
			if (lname != null) {
				lname = new String(lname.getBytes("8859_1"), "UTF-8");
			}
			if (note != null) {
				note = new String(note.getBytes("8859_1"), "UTF-8");
			}
			if (uname != null) {
				uname = new String(uname.getBytes("8859_1"), "UTF-8");
			}
			if (team != null) {
				team = new String(team.getBytes("8859_1"), "UTF-8");
			}
			if (rank != null) {
				rank = new String(rank.getBytes("8859_1"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(String lecture_id) {
		this.lecture_id = lecture_id;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getTestscore() {
		return testscore;
	}
	public void setTestscore(int testscore) {
		this.testscore = testscore;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCancelation() {
		return cancelation;
	}
	public void setCancelation(String cancelation) {
		this.cancelation = cancelation;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getYMD_STD() {
		return YMD_STD;
	}
	public void setYMD_STD(String yMD_STD) {
		YMD_STD = yMD_STD;
	}
	public String getYMD_END() {
		return YMD_END;
	}
	public void setYMD_END(String yMD_END) {
		YMD_END = yMD_END;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getUrank() {
		return urank;
	}
	public void setUrank(String urank) {
		this.urank = urank;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	
	
}

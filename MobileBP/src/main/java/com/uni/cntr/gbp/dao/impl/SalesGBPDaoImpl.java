package com.uni.cntr.gbp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uni.cntr.gbp.dao.SalesGBPDao;
import com.uni.cntr.gbp.util.DBManager;
import com.uni.cntr.gbp.util.Utils;
import com.uni.cntr.gbp.vo.SalesGBPVO;

@Repository
public class SalesGBPDaoImpl implements SalesGBPDao {

	@Override
	public List<SalesGBPVO> getAll(String sales) {
		//return generate("201521", 0);
		return getDatabyDB2(sales, null, 0);
	}

	@Override
	public List<SalesGBPVO> getAll(String sales, String week, int diff) {
		
		//return generate(week, diff);
		return getDatabyDB2(sales, week, diff);
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
	
	private List<SalesGBPVO> getDatabyDB2(String sales, String week, int diff) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<SalesGBPVO> list = new ArrayList<SalesGBPVO>();
		try {
			con = DBManager.getConnection();
			stmt = con.createStatement();
			
			String sql = getSQL(week, sales, diff);
			rs = stmt.executeQuery(sql);
			
			SalesGBPVO vo;
			while(rs.next()) {
				vo = new SalesGBPVO();
				vo.setTrade(rs.getString("OUTTRD"));
				vo.setBound(rs.getString("OUTBND"));
				vo.setRoute(rs.getString("OUTROT"));
				vo.setWeek1(rs.getString("OUTWK1"));
				vo.setWeek2(rs.getString("OUTWK2"));
				vo.setWeek3(rs.getString("OUTWK3"));
				vo.setWk1_alo(rs.getInt("OUTAL1"));
				vo.setWk1_bkg(rs.getInt("OUTBK1"));
				vo.setWk1_bp(rs.getInt("OUTBP1"));
				vo.setWk2_alo(rs.getInt("OUTAL2"));
				vo.setWk2_bkg(rs.getInt("OUTBK2"));
				vo.setWk2_bp(rs.getInt("OUTBP2"));
				vo.setWk3_alo(rs.getInt("OUTAL3"));
				vo.setWk3_bkg(rs.getInt("OUTBK3"));
				vo.setWk3_bp(rs.getInt("OUTBP3"));
				list.add(vo);
			}
			
		} catch(SQLException e) {
			
		} finally {
			if (rs != null ){try { rs.close(); } catch(SQLException e){} }
			if (stmt != null ){try { stmt.close(); } catch(SQLException e){} }
			if (con != null ){try { con.close(); } catch(SQLException e){} }
		}
		
		return list;
	}
	
	private String getSQL(String week, String sales, int diff) {
		String sortYWK = "";
		if (diff == 1) {
			sortYWK = "\n (SELECT YMWYER * 100 + YMWYWK  " +
					"\n FROM PLIBOP.OPRAYMW   " +
					"\n WHERE YMWKND='W' AND YMWYER * 100 + YMWYWK > " + week +
					"\n ORDER BY YMWYER * 100 + YMWYWK ASC  " +
					"\n FETCH FIRST 1 ROWS ONLY)  ";
		} else if (diff == -1) {
			sortYWK = "\n (SELECT YMWYER * 100 + YMWYWK  " +
						"\n FROM PLIBOP.OPRAYMW   " +
						"\n WHERE YMWKND='W' AND YMWYER * 100 + YMWYWK < " + week +
						"\n ORDER BY YMWYER * 100 + YMWYWK DESC  " +
						"\n FETCH FIRST 1 ROWS ONLY)  ";
		} else {
			sortYWK = "\n (SELECT YMWYER * 100 + YMWYWK " +
					  "\n FROM PLIBOP.OPRAYMW  WHERE YMWKND='W' " +
					  "\n AND ( SELECT TO_CHAR(CURRENT TIMESTAMP,'YYYYMMDD') FROM SYSIBM.SYSDUMMY1) BETWEEN YMWFDT AND YMWTDT) ";
		}
			
		StringBuilder sb = new StringBuilder();
		sb.append("\n WITH YWK AS (  ");
		sb.append("\n SELECT ROW_NUMBER() OVER (ORDER BY  YMWYER * 100 + YMWYWK ASC) SEQ, YMWYER * 100 + YMWYWK YWK  ");
		sb.append("\n FROM PLIBOP.OPRAYMW   ");
		sb.append("\n WHERE YMWKND='W' AND YMWYER * 100 + YMWYWK >=   ");
		
		//date
		sb.append(sortYWK);
		
		sb.append("\n ORDER BY YMWYER * 100 + YMWYWK ASC  ");
		sb.append("\n FETCH FIRST 3 ROWS ONLY  ");
		sb.append("\n )  ");
		sb.append("\n   ");
		sb.append("\n SELECT SSLTRD OUTTRD, SSLBND OUTBND, SSLROT OUTROT  ");
		sb.append("\n       , (SELECT YWK FROM YWK WHERE SEQ = 1) OUTWK1  ");
		sb.append("\n       , (SELECT YWK FROM YWK WHERE SEQ = 2) OUTWK2  ");
		sb.append("\n       , (SELECT YWK FROM YWK WHERE SEQ = 3) OUTWK3  ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 1 THEN SSLALO ELSE 0 END) OUTAL1  ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 1 THEN SSLBPT+SSLBPV ELSE 0 END) OUTBP1  ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 1 THEN SSLBKT+SSLBKV ELSE 0 END) OUTBK1  ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 2 THEN SSLALO ELSE 0 END) OUTAL2  ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 2 THEN SSLBPT+SSLBPV ELSE 0 END) OUTBP2  ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 2 THEN SSLBKT+SSLBKV ELSE 0 END) OUTBK2  ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 3 THEN SSLALO ELSE 0 END) OUTAL3  ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 3 THEN SSLBPT+SSLBPV ELSE 0 END) OUTBP3  ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 3 THEN SSLBKT+SSLBKV ELSE 0 END) OUTBK3  ");
		sb.append("\n FROM PLIBBP.GBPASCLT  ");
		sb.append("\n     INNER JOIN PLIBBP.GBPASSAL ON CLTMID = SSLMID  ");
		sb.append("\n     INNER JOIN YWK ON SSLYWK=YWK  ");
		sb.append("\n WHERE SSLSAL = '"+sales+"'  ");
		sb.append("\n GROUP BY SSLTRD, SSLBND, SSLROT  ");
		sb.append("\n ORDER BY SSLTRD DESC, SSLBND, SSLROT  ");
		return sb.toString();
	}

}

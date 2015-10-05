package com.uni.cntr.gbp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uni.cntr.gbp.dao.SalesGBPbyAccDao;
import com.uni.cntr.gbp.util.DBManager;
import com.uni.cntr.gbp.util.Utils;
import com.uni.cntr.gbp.vo.SalesGBPbyAccVO;

@Repository
public class SalesGBPbyAccDaoImpl implements SalesGBPbyAccDao {
	
	private static final int MAX_LENGTH_DESC = 25;

	@Override
	public List<SalesGBPbyAccVO> getAll(String sales, String trade, String bound, String route, String week, int diff) {
		//return generate(week, diff);
		return getDatabyDB2(sales, trade, bound, route, week, diff);
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
	
	private List<SalesGBPbyAccVO> getDatabyDB2(String sales, String trade, String bound, String route, String week, int diff) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<SalesGBPbyAccVO> list = new ArrayList<SalesGBPbyAccVO>();
		try {
			con = DBManager.getConnection();
			stmt = con.createStatement();
			
			String sql = getSQL(sales, trade, bound, route, week, diff);
			rs = stmt.executeQuery(sql);
			
			SalesGBPbyAccVO vo;
			while(rs.next()) {
				vo = new SalesGBPbyAccVO();
				vo.setAcc(rs.getString("OUTACC"));
				
				String sDesc = rs.getString("OUTDES");
				if (sDesc.length() > MAX_LENGTH_DESC) {
					sDesc = sDesc.substring(0, MAX_LENGTH_DESC - 1) + "..";
				}
				vo.setDesc(sDesc);
				
				vo.setWeek1(rs.getString("OUTWK1"));
				vo.setWeek2(rs.getString("OUTWK2"));
				vo.setWeek3(rs.getString("OUTWK3"));
				vo.setWk1_bkg(rs.getInt("OUTBK1"));
				vo.setWk1_bp(rs.getInt("OUTBP1"));
				vo.setWk2_bkg(rs.getInt("OUTBK2"));
				vo.setWk2_bp(rs.getInt("OUTBP2"));
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
	
	private String getSQL(String sales, String trade, String bound, String route, String week, int diff) {
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
		sb.append("\n SELECT TRIM(SDTCOD) OUTACC, TRIM(SHPTRA) OUTDES ");
		sb.append("\n       , (SELECT YWK FROM YWK WHERE SEQ = 1) OUTWK1   ");
		sb.append("\n       , (SELECT YWK FROM YWK WHERE SEQ = 2) OUTWK2   ");
		sb.append("\n       , (SELECT YWK FROM YWK WHERE SEQ = 3) OUTWK3   ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 1 THEN SDTBPT+SDTBPV ELSE 0 END) OUTBP1   ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 1 THEN SDTBKT+SDTBKV ELSE 0 END) OUTBK1   ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 2 THEN SDTBPT+SDTBPV ELSE 0 END) OUTBP2   ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 2 THEN SDTBKT+SDTBKV ELSE 0 END) OUTBK2   ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 3 THEN SDTBPT+SDTBPV ELSE 0 END) OUTBP3   ");
		sb.append("\n       , SUM(CASE WHEN SEQ = 3 THEN SDTBKT+SDTBKV ELSE 0 END) OUTBK3   ");
		sb.append("\n FROM PLIBBP.GBPASCLT   ");
		sb.append("\n     INNER JOIN PLIBBP.GBPASDTL ON CLTMID = SDTMID   ");
		sb.append("\n     INNER JOIN YWK ON SDTYWK=YWK   ");
		sb.append("\n     LEFT OUTER JOIN PLIBCD.CODASHPR ON SDTCOD=SHPCDE ");
		sb.append("\n WHERE SDTSAL = '"+sales+"'   ");
		sb.append("\n  AND SDTTRD = '"+trade+"'   ");
		sb.append("\n  AND SDTBND = '"+bound+"'   ");
		sb.append("\n  AND SDTROT = '"+route+"'   ");
		sb.append("\n GROUP BY TRIM(SDTCOD), TRIM(SHPTRA) ");
		sb.append("\n ORDER BY TRIM(SDTCOD) ");
		return sb.toString();
	}

}

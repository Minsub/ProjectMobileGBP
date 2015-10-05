package com.uni.cntr.gbp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static final String ID = "WBFAXSVR";
	private static final String PW = "WEBFAX";
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static Connection getConnection() throws SQLException{
		try {
            java.sql.DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
            return DriverManager.getConnection("jdbc:as400://203.242.32.18;naming=sql;errors=full;date format=iso",ID, PW); //Production
    		//return DriverManager.getConnection("jdbc:as400://203.242.35.200;naming=sql;errors=full;date format=iso",ID, PW); //DEV
        }
        catch (SQLException e) {
            throw e;
        } 
    }
	
	/**
	 * 
	 * @return 
	 * @throws SQLException
	 * @throws Exception
	 */
	public static Connection getConnectionDEV() throws SQLException{
    	
		try {
            java.sql.DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
            //return DriverManager.getConnection("jdbc:as400://203.242.32.18;naming=sql;errors=full;date format=iso",ID, PW); //Production
    		return DriverManager.getConnection("jdbc:as400://203.242.35.200;naming=sql;errors=full;date format=iso",ID, PW); //DEV
        }
        catch (SQLException e) {
            throw e;
        } 
    }
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static Connection getConnectionPRO() throws SQLException{
    	
		try {
            java.sql.DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
            return DriverManager.getConnection("jdbc:as400://203.242.32.18;naming=sql;errors=full;date format=iso",ID, PW); //Production
    		//"jdbc:as400://203.242.35.200;naming=sql;errors=full;date format=iso","DPBIZNJP", "infi1111"); //DEV
        }
        catch (SQLException e) {
            throw e;
        } 
    }
}

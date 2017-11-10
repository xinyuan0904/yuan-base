package com.yuan.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.yuan.db.DbPoolConnection;

public class TestDb {

	public static void main(String[] args) {
		String sql = "select * from interface_info";
		try {
			search(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void search(String sql) throws SQLException{
		DbPoolConnection dbp = DbPoolConnection.getInstance();  
        DruidPooledConnection con = dbp.getConnection();  
        PreparedStatement ps = con.prepareStatement(sql);  
        ResultSet rs = ps.executeQuery();
        while( rs.next() ){
        	System.out.println(rs.getString("class_name"));
        }
        ps.close();  
        con.close();  
        dbp = null;  
	}
}

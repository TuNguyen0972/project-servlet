package com.trungtamjava.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;



public class JDBCConnection {
	
		public static void main(String[] args) {
			JDBCConnection jdbc = new JDBCConnection();
			Connection conn = jdbc.getConnection();
			if(conn == null){
				System.out.println("that bai");
			}else{
				System.out.println("thanh cong");
			}
		}
	   public Connection getConnection(){
		   try{
		   String username = "root";
		   String password = "";
		   String url = "jdbc:mysql://localhost:3306/tunguyen";
		   Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		   Connection conn = DriverManager.getConnection (url,"root","");
		   return conn;
		   } catch(Exception e){
			   System.out.println("Loi" + e);
		   }
		   
		   return null;
	   }
}

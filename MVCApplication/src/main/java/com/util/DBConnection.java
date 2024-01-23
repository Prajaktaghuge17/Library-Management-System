package com.util;
import java.sql.*;
public class DBConnection {

	
		  static Connection con= null;
		  public static Connection getDbConnection() throws SQLException, ClassNotFoundException
		  {
		    Class.forName("oracle.jdbc.driver.OracleDriver");	  
		    try 
		    {
				con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","prajakta","prajakta");
			} 
		    catch (SQLException e) 
		    {
			  e.printStackTrace();
			}
		    return con;
		  }
		}
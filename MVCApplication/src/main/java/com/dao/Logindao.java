package com.dao;
import com.bean.*;
import com.util.*;
import java.sql.*;

public class Logindao {
	
		 Connection con=null;	
		  public String userAuthentication(LoginBean lbobj) throws ClassNotFoundException, SQLException 
		  {
		     con=DBConnection.getDbConnection(); 
			 String uname=lbobj.getUname();
		     String upwd=lbobj.getUpwd();
		     PreparedStatement ps= con.prepareStatement("select uname,upwd from usertb where uname=? and upwd=?");
		     ps.setString(1, uname);
		     ps.setString(2, upwd);
		     ResultSet rs=ps.executeQuery();
		     if(rs.next())
		     	 return "Success";
		     return "Invalid username or password";
		  }//end method
		}//end class

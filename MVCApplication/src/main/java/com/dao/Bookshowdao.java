package com.dao;

import com.bean.*;
import com.util.*;
import java.sql.*;

public class Bookshowdao {
	
		 Connection con=null;	
		  public String userAuthentication(Bookshowbean sobj) throws ClassNotFoundException, SQLException 
		  {
		     con=DBConnection.getDbConnection(); 
			 String id=sobj.getId();
			 String title=sobj.getTitle();
			 String author=sobj.getAuthor();
			 String price=sobj.getPrice();
			 String quantity=sobj.getQuantity();
			 
			 
		     Statement st=con.createStatement();
		     ResultSet rs=st.executeQuery("select * from book");
		     while(rs.next()) {
		    	 System.out.println(" "+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
		     }
		     return "success";
		  }//end method
		}//end class




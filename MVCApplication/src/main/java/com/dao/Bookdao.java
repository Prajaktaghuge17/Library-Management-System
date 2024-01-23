package com.dao;

import com.bean.*;
import com.util.*;
import java.sql.*;

public class Bookdao {
	
		 Connection con=null;	
		  public String userAuthentication(BookBean bbobj) throws ClassNotFoundException, SQLException 
		  {
		     con=DBConnection.getDbConnection(); 
			 String id=bbobj.getId();
			 String title=bbobj.getTitle();
			 String author=bbobj.getAuthor();
			 String price=bbobj.getPrice();
			 String quantity=bbobj.getQuantity();
			 
		     PreparedStatement ps= con.prepareStatement("insert into book values(?,?,?,?,?)");
		     ps.setString(1, id);
		     ps.setString(2, title);
		     ps.setString(3, author);
		     ps.setString(4, price);
		     ps.setString(5, quantity);
		     int i=ps.executeUpdate();
		    if(i>0) {
		    	return "Record inserted successfully";
		    }
		    else {
		    	return "Record not added";
		    }
		  }//end method
		}//end class


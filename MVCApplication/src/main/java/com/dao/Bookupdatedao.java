package com.dao;

import com.bean.*;
import com.util.*;
import java.sql.*;

public class Bookupdatedao {
	
		 Connection con=null;	
		  public String userAuthentication(BookupdateBean buobj) throws ClassNotFoundException, SQLException 
		  {
		     con=DBConnection.getDbConnection(); 
			 String id=buobj.getId();
			 String title=buobj.getTitle();
			 String author=buobj.getAuthor();
			 String price=buobj.getPrice();
			 String quantity=buobj.getQuantity();
			 
			 
		     PreparedStatement ps= con.prepareStatement("update book set title=?,author=?,price=?,quantity=? where id=?");
		  
		     ps.setString(1, title);
		     ps.setString(2, author);
		     ps.setString(3, price);
		     ps.setString(4, quantity);
		     ps.setString(5, id);
		    
		     int i=ps.executeUpdate();
		    if(i>0) {
		    	return "Record updated successfully";
		    }
		    else {
		    	return "Record not updated";
		    }
		  }//end method
		}//end class



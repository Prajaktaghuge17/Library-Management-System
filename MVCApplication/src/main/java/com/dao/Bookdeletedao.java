package com.dao;
import com.bean.*;
import com.util.*;
import java.sql.*;

public class Bookdeletedao {
	
		 Connection con=null;	
		  public String userAuthentication(Bookdeletebean bbdobj1) throws ClassNotFoundException, SQLException 
		  {
		     con=DBConnection.getDbConnection(); 
			 String id=bbdobj1.getId();
			
			 
			 
		     PreparedStatement ps= con.prepareStatement("delete from book where id=?");
		     ps.setString(1, id);
		    
		     int i=ps.executeUpdate();
		    if(i>0) {
		    	return "Record delete successfully";
		    }
		    else {
		    	return "Record not deleted";
		    }
		  }//end method
		
		}//end class




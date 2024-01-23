package com.controller;


import com.bean.*;
import com.dao.*;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class BookshowServlet extends HttpServlet 
{
    public BookshowServlet() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  String id=request.getParameter("id");
	  String title=request.getParameter("title");
	  String author=request.getParameter("author");
	  String price=request.getParameter("price");
	  String quantity=request.getParameter("quantity");
	
	  
	  PrintWriter out= response.getWriter();
	  Bookshowbean s2obj= new Bookshowbean();
	  s2obj.setId(id);
	  s2obj.setTitle(title);
	  s2obj.setAuthor(author);
	  s2obj.setPrice(price);
	  s2obj.setQuantity(quantity);
	 
	  RequestDispatcher rd1= request.getRequestDispatcher("./showbook.jsp");
	  RequestDispatcher rd2= request.getRequestDispatcher("./Bookshowdao.java");
	  
	  Bookshowdao s1obj= new Bookshowdao();
	  try 
	  {
		String str=s1obj.userAuthentication(s2obj);
		
		 if(str.equals("success"))
		 {
			 rd1.forward(request, response);
		 }
		 else
		 {
			 out.print(""+str);
			 rd2.include(request, response);
		 }
	  }
	  catch (ClassNotFoundException | SQLException e) 
	  {
		e.printStackTrace();
	  }
	}
}//end Servlet class
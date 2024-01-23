package com.controller;

import com.bean.*;
import com.dao.*;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet 
{
    public LoginServlet() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  String uname=request.getParameter("uname");
	  String upwd=request.getParameter("upwd");
	  
	  PrintWriter out= response.getWriter();
	  LoginBean lbobj= new LoginBean();
	  lbobj.setUname(uname);
	  lbobj.setUpwd(upwd);
	  RequestDispatcher rd1= request.getRequestDispatcher("./index.jsp");
	  RequestDispatcher rd2= request.getRequestDispatcher("./login.html");
	  
	  Logindao ldobj= new Logindao();
	  try 
	  {
		String str=ldobj.userAuthentication(lbobj);
		
		 if(str.equals("Success"))
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
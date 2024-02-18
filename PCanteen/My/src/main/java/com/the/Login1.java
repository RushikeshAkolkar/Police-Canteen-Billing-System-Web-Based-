package com.the;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login1")
public class Login1 extends HttpServlet {
	
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname1=request.getParameter("uname");
		String pass1=request.getParameter("pass");
		String p ;
		HttpSession session =  request.getSession(true);
		PrintWriter pl = response.getWriter();
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB",
		            "postgres", "123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from officer where uname='"+uname1+"' and pass='"+pass1+"'");
            if(rs.next())
            {
            	p = (String) rs.getString(1);
            	
            	session.setAttribute("dis", p);
            	
               	response.sendRedirect("Welcome.jsp");
            }
            
		}
		catch(Exception e)
		{
			pl.println(e.getMessage());
			session.invalidate();
		}
	}

}

package com.the;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Bill")
public class CanteenBill extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession(false);
		 
		try{
		 String btn=request.getParameter("submit");
		 String s1=request.getParameter("pro");
		 String s2=request.getParameter("cost");
		 String s3=request.getParameter("qty");
		 String s4=request.getParameter("name");
		 int s5=Integer.parseInt(request.getParameter("pid"));
		 String s6 = (String) session.getAttribute("dis");
		 String s7 = request.getParameter("date");
		 session.setAttribute("date",s7);
		 String pro[]=s1.split(",");
		 String[] cost=s2.split(",");
		 String qty[]=s3.split(",");
		 PrintWriter out = response.getWriter();
		 Date d=new Date();
		 Float[] total=new Float[200];
		 float n = 0;
		 long ms = 0;
		 PreparedStatement ps;
	            ms = d.getTime();
	           java.sql.Date sqld = new java.sql.Date(ms);
	           int res=0;
	           int i=0;
	      if("logout".equals(btn))
	      {
	    	  session.invalidate();
	    	  response.sendRedirect("index.jsp");
	      }
	      if("clear".equals(btn))
	      {
	    	  response.sendRedirect("Welcome.jsp");
	      }
	      if("detail".equals(btn))
			 {
				 RequestDispatcher rd=request.getRequestDispatcher("final1");
				 rd.forward(request,response);
			 }
	      if("insert".equals(btn))
	      {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
				java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db","123");
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from police");
	            String id=request.getParameter("pid");
	            while(rs.next())
	            {
	            	if(s6.equals(rs.getString(1)) && id.equals(rs.getString(2)) && s4.equals(rs.getString(3)))
	            	{
	            		out.println("<html><body><center>Wlcome to Police Canteen Of "+s6+"<br>Date:-"+d+"<br>Name:-"+s4+"<br>Id="+s5);
	            		out.println("<table border=1>"+sqld+"<tr><th>Product Name</th><th>Product Cost</th><th>Product Qauantity</th><th>Product Total</th></tr>");
	            		for(i=0;i<pro.length;i++)
	            		{
	            			ps = con.prepareStatement("insert into bill values(?,?,?,?,?,?)");
	            			ps.setString(1,s6);
	            			ps.setInt(2,s5);
	            			ps.setString(3,pro[i]);
	            			ps.setString(4,cost[i]);
	            			ps.setString(5,qty[i]);
	            			ps.setDate(6,sqld);
	            			res=ps.executeUpdate();
	            			total[i] = Float.parseFloat(cost[i])*Float.parseFloat(qty[i]);
	            			n=total[i]+n;
	            		}
	            		if(res>0)
	            		{
	            			out.println("<script>alert('Data Inserted Successfully')</script>");
	            		}
	            		for(i=0;i<pro.length;i++)
	            		{
	            			out.println("<tr><td><center>"+pro[i]+"</center></td><td><center>"+cost[i]+"</center></td><td><center>"+qty[i]+"</center></td><td><center>"+total[i]+"</center></td></tr>");
	            		}
	            		out.println("<tr align=right><td colspan=4>Total Cost = "+n+"</td></tr>");
	            		}
	            	out.println("<br><input type='button' onclick='window.print()' value='Print Bill'></table></center></body></html>"); 
	            	}
	            
	            
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
			session.invalidate();
		}
	}
	
	}
	 catch(Exception e) {
		 response.sendRedirect("index.jsp");
		 session.invalidate();
	 }
}

}

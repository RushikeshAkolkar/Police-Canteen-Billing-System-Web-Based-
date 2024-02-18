<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
Connection con;
Statement stmt;
ResultSet rs;
float total=0.0f;
String s4,s5;
try {
    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db","123");
    stmt = con.createStatement();
    rs=stmt.executeQuery("select * from bill inner join police on bill.id=police.id");
    while(rs.next())
    { 
    	total = total+(Float.parseFloat(rs.getString(6))*(Float.parseFloat(rs.getString(7))));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table border=1>
<tr>
<th>Product 
<tr>
<td><%= rs.getString(5) %></td>
<td><%= rs.getString(6) %></td>
<td><%= rs.getString(7) %></td>
</tr>
<tr>
<td><%=total%></td>
</tr>
<%
        }
}catch(Exception e){}
%>
</table>
</center>
</body>
</html>

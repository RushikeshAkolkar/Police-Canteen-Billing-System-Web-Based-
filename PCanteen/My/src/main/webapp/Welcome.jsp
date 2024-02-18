<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("dis")==null)
{
	response.sendRedirect("index.jsp");
	
}

%>
<center>
<form action="Bill" method="post">
Welcome To Police Canteen Of ${dis}
<table>
<tr>
<td>Police Name</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>Police Id</td>
<td><input type="text" name="pid"></td>
</tr>
<tr>
<td>Product Name</td>
<td><input type="text" name="pro"></td>
</tr>
<tr>
<td>Product Cost</td>
<td><input type="text" name="cost"></td>
</tr>
<tr>
<td>Product qty</td>
<td><input type="text" name="qty"></td>
</tr>
<tr>

<td><button value="logout" name="submit">Logout</button></td>
<td><button value="clear" name="submit">Clear</button></td>
<td><button value="insert" name="submit">Submit</button></td>
</tr>
</table>
</form>
</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date,java.text.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Login User Name Error............!
</body>
</html>
<%java.util.Date d = new Date();
long ms=0;
java.sql.Date sqld;
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String date1 = sdf.format(d);
try {
    java.util.Date date4 = sdf.parse(date1);
    ms = date4.getTime();
    sqld = new java.sql.Date(ms);
} catch (ParseException ex) {
}
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
ResultSet rs= (ResultSet) request.getAttribute("resultset");
rs.next();
%>
<form action="save-update-student" method="post">

<input type="number" value="<%= rs.getInt(1) %>" name="id"  readonly="readonly">
<input type="text"  value="<%= rs.getString(2) %>" name="name">
<input type="text"  value="<%= rs.getString(3) %>" name="email">
<input type="number" value="<%= rs.getInt(4) %>" name="age">
<input type="text" value="<%= rs.getString(5) %>" name="course">
<input type="text" value="<%= rs.getString(6) %>" name="city">
<input type="submit" value="UPDATET">




</body>
</html>
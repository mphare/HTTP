<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="JSP, expressions, JavaServer Pages" />
<meta name="description" content="A quick example of JSP expressions." />
<link rel=stylesheet href="/AttendanceServer/style/Master.css" type="text/css" />
<title>Attendance Server</title>
</head>
<%
  String textColor = "0x05a";
%>

<body text="<%=textColor%>">
	<%@ include file="parts/Header.jsp"%>
	<h1>Attendance Server</h1>
	<a href="test-stuff.jsp">Test Stuff</a>
	<a href="show-students.jsp">List All Students</a>
	<%@ include file="parts/Footer.jsp"%>
</body>
</html>
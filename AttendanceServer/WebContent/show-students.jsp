<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="JSP, expressions, JavaServer Pages" />
<meta name="description" content="A quick example of JSP expressions." />
<link rel=stylesheet href="/FirstDWP/Style/Master.css" type="text/css" />
<title>Insert title here</title>
</head>
<%
  String textColor = "0x05a";
%>
<body text="<%=textColor%>">
	<%@ include file="parts/Header.jsp"%>
	<h1>List of Students</h1>
	<%@ include file="parts/Footer.jsp"%>
</body>
</html>
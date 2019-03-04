<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!-- 这是 JSP 注释 --%>
<%! String name; %>
你的 URL 地址是：<%= request.getRequestURI() %>
	
<br />

<%
	name = "geekxia";
	out.println("你的名字是：" + name);
%>
</body>
</html>
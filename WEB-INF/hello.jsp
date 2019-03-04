<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org">

<html>
<head>
<meta http-equiv="Content-Type" />
<title>JSP 动态页面</title>
</head>
<body>
	<%-- 这是 JSP 注释 --%>
	<%! String name; %>
	你的 URL 地址是：<%= request.getRequestURI() %>
	
	<br />
	<%
		name = "geekxia";
		out.println("你的名字是：" + name);
	%>
</body>
</html>
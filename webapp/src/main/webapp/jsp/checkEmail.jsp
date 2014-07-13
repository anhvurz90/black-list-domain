<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% boolean blacklisted = (Boolean)request.getAttribute("blackListed"); 
%>
<html>
	<head>
		<title>Domain add</title>
	</head>
	<body>
		<h2>Email checking</h2>
		<span style="color: <%= blacklisted ? "red" : "green" %>">The domain of your email is <%= blacklisted?"" : " not" %> blacklisted</span>
		<br/>
		<br/>
		<a href="<%= request.getContextPath() %>/listDomain">Back to domain list</a>
	</body>
</html>
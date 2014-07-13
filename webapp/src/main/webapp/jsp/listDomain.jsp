<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,
 					  java.util.ArrayList,
					  com.anhvurz90.blacklisteddomain.api.DomainManager,
					  com.anhvurz90.blacklisteddomain.entities.Domain"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%   
	List<Domain> domains = (List<Domain>)request.getAttribute("domains");
%>

<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		 <title>Domain value</title>
		 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	 	 <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
		 <script src="<c:url value="/resources/js/jquery.form-validator.min.js"/>"></script>
	</head>
	<body>
<!-- Link to add new domain -->	
		<a href="<%= request.getContextPath() %>/addDomain">Add new domain</a>
		
<!-- Check whether email belongs to blacklisted domain -->
		<h4>Check whether email belongs to blacklisted domain:</h4>	
		<form method="POST" action="<%= request.getContextPath() %>/checkEmail">
			<table>
				<tr>
					<td><label>Email</label></td>
					<td><input name="email" data-validation="email"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Check email"/>
					</td>
				</tr>
			</table>
		</form>

		
<!-- List all domains -->
		<h2>Domain List</h2>
		<table id='hor-zebra'>
			<thead>
				<tr>
					<th scope="col">Order</th>
					<th scope="col">Domain</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<% for (int i = 0; i < domains.size(); i++) {%>
					<tr class='<%= (i % 2 == 1)?"even" : "odd"%>'>
						<td><%= i %></td>
						<td><%= domains.get(i).getValue() %></td>
						<td><a href="<%= request.getContextPath() %>/deleteDomain?domainName=<%= domains.get(i).getValue() %>">Delete</a></td>
					</tr>
				<% } %>
			</tbody>
		</table>
		<script>
			$.validate();
		</script>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Domain add</title>
	</head>
	<body>
		<h2>Domain Information</h2>
		<form:form method="POST" action="/BlackListedDomain/addDomain">
			<table>
				<tr>
					<td><form:label path="value">Name</form:label></td>
					<td><form:input path="value"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Submit"/>
					</td>
				</tr>
			</table>
		</form:form>
	</body>
</html>
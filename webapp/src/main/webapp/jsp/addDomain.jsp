<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Domain add</title>
		<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery.form-validator.min.js"/>"></script>
	</head>
	<body>
		<h2>Domain Information</h2>
		<form:form method="POST" action='<%=request.getContextPath() + "/listDomain"%>'>
			<table>
				<tr>
					<td><form:label path="value">Name</form:label></td>
					<td><form:input path="value"
													data-validation="domain"/> 
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Submit"/>
					</td>
				</tr>
			</table>
		</form:form>
		<script>
			$.validate();
		</script>
	</body>
</html>
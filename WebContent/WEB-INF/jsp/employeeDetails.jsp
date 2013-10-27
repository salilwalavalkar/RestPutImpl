<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee Details</title>

</head>
<body>	
	<table class="fullBorder">
		<tr>
			<td>Employee Details</td>
		</tr>					
		<c:forEach items="${employeeList}"
				var="item" varStatus="itemStatus">
			<tr>
				<td>Employee id: </td>
				<td>${item.empId}</td>						
			</tr>
			<tr>
				<td>Employee name: </td>
				<td>${item.empName}</td>						
			</tr>
		</c:forEach>			
	</table>
</body>
</html>
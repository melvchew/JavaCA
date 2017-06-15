<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	session = request.getSession(false);
	System.out.println(request.getContextPath() + "/LogIn.jsp");
	if (session.getAttribute("loggedInUser") == null) {
		response.sendRedirect(request.getContextPath() + "/Login");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Types</title>
</head>
<body>
	<form method="post">
		<table class="table">
			<thead>
				<tr>
					<th>Leave Type ID</th>
					<th>Leave Type</th>
					<th><input type="submit" value="Update"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${leaveTypeList}" var="type">
					<tr>
						<td>${type.leaveTypeId}</td>
						<td><input type="text" name="${type.leaveTypeId}"
							value="${type.leaveType}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
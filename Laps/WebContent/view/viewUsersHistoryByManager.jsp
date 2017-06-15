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
<title>Insert title here</title>
</head>
<body>
	<form method="get">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Job Title</th>
					<th>Phone</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList}" var="emp">
					<tr>
						<td>${emp.name}</td>
						<td>${emp.position.jobTitle}</td>
						<td>${emp.phone}</td>
						<td>${emp.email}</td>
						<td><a
							href="<c:url value="/employee/viewleavehistory">
										<c:param name="id" value="${emp.username}"/>
									</c:url>">Leave
								History</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
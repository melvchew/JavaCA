<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Staff Leave</title>
</head>
<body>
	<form method="post">
	<c:if test="${ param['submit'] == 'Update' }">
			<h2>${ msg }</h2>
		</c:if>
		<table class="table">
			<thead>
				<tr>
					<th>Leave Type</th>
					<th>Days Remaining</th>
					<th><input type="submit" value="Update"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${leaveList}" var="leave">
					<tr>
						<td>${leave.leaveTypeId}</td>
						<td><input type="text" name="${leave.leaveTypeId}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
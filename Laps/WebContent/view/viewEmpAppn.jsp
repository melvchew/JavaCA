<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pending Leave Applications</title>
</head>
<body>
	<form method="post">
		<table class="table">
			<thead>
				<tr>
					<th>Application ID</th>
					<th>Name</th>
					<th>Leave Type</th>
					<th>Application Date</th>
					<th>Leave Start Date</th>
					<th>Leave End Date</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${leaveList}" var="appn">
					<tr>
						<td>${appn.appnId}</td>
						<td>${appn.user.name}</td>
						<td>${appn.leaveType.leaveType}</td>
						<td>${appn.appnDate}</td>
						<td>${appn.startDate}</td>
						<td>${appn.endDate}</td>
						<td>${appn.status}</td>
						<td><a
							href="<c:url value="/manageleave">
										<c:param name="id" value="${appn.appnId}"/>
									</c:url>">
								Details </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
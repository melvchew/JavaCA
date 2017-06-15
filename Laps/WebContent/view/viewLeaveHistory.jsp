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
	<div>
		<table>

			<thead>
				<tr>
					<th>Application Id</th>

					<th>Applied On</th>
					<th>Leaves From</th>
					<th>Leaves To</th>

					<th width="133" scope="col">Leave Status</th>
					<th>Leaves Type</th>
					<th>Comments</th>

				</tr>
			</thead>

			<c:forEach items="${leaveList}" var="i" varStatus="loopStatus">
				<tr>
					<td height="99"><c:out value="${i.appnId}" /></td>

					<td><fmt:formatDate type="date" dateStyle="short"
							value="${i.appnDate }" /></td>
					<td><fmt:formatDate type="date" dateStyle="short"
							value="${i.startDate }" /></td>
					<td><fmt:formatDate type="date" dateStyle="short"
							value="${i.endDate }" /></td>
					<td><c:out value="${i.status}" /></td>
					<td><c:out value="${i.leaveType.leaveType}" /></td>
					<td><c:out value="${i.empComments}" /></td>

					<label><c:out value="${ id }"></c:out></label>
					<td><c:if test="${not empty id}">
							<a
								href="<c:url value="/manager/manageleave">
										<c:param name="id" value="${i.appnId}"/>
									</c:url>">DETAILS</a>
						</c:if>
						
						<c:if test="${empty id}">
							<a
								href="<c:url value="/employee/manageleave">
										<c:param name="LeaveAppnId" value="${i.appnId}"/>
									</c:url>">DETAILS</a>
						</c:if>
						
						</td>
				</tr>
			</c:forEach>
		</table>
		<p></p>
	</div>
</body>
</html>
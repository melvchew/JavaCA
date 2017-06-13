<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%
	session = request.getSession(false);
	if (session.getAttribute("profile") == null) {
		response.sendRedirect(request.getContextPath() + "/LogIn.jsp");
	}
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Body Table -->
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
<%-- 				<th><fmt:message key="Col1" /></th>
				<th><fmt:message key="Col2" /></th>
				<th><fmt:message key="Col3" /></th>
				<th><fmt:message key="Col4" /></th> --%>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="LeaveAppn" items="${leaveList}" >
				<tr>
					<td>${LeaveAppn.appnId}</td>
					<td>${LeaveAppn.leaveTypeId}</td>
					<td>${LeaveAppn.userId}</td>
					<td>${LeaveAppn.appnDate}</td>
					<td>${LeaveAppn.startDate}</td>
				</tr>
				<%-- 					<!-- "Edit" button -->
					<td><c:url var="updurl" scope="page"
							value="/view/CourseSetup.jsp">
							<c:param name="courseName" value="${course.courseName}" />
							<c:param name="typeOfCourse" value="${course.typeOfCourse}" />
							<c:param name="id" value="${course.lecturerID}" />
							<c:param name="update" value="true" />
						</c:url> <a href="${updurl}" class="btn btn-primary"><fmt:message
								key="label.course.edit" /></a></td>

					<!-- "Delete" button -->
					<td><c:url var="delurl" scope="page" value="/CourseDelete">
							<c:param name="courseName" value="${course.courseName}" />
						</c:url> <a href="${delurl}" class="btn btn-primary"> <fmt:message
								key="label.course.delete" /></a></td> 

				</tr>--%>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
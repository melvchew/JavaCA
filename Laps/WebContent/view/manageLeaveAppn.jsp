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
	<form method="post">
		<input type="hidden" name="appnId" value="${leave.appnId}" /> <label>Application
			Id:</label> <label>${leave.appnId }</label><br /> <label>Employee
			Name:</label> <label>${leave.user.name }</label><br /> <label>Leave
			Type:</label> <label>${leave.leaveType.leaveType }</label><br /> <label>Start
			Date: </label> <label><fmt:formatDate type="date" dateStyle="short"
				value="${leave.startDate }" /> </label><br /> <label>End Date</label> <label><fmt:formatDate
				type="date" dateStyle="short" value="${leave.endDate }" /></label><br /> <label>Status:</label><label>${leave.status }</label><br/>
		<label>Employee Comments:</label> <label>${empty leave.empComments? "No Comments" : leave.empComments }</label><br />
		<label>Manager Comments:</label> <input type="text"
			value="Enter comment" name="mgrComments" /><br />
		<c:if test="${ leave.status == 'PENDING' || leave.status == 'CANCELLED' }">
			<input name="btnAction" type="submit" value="Reject" />
			<input name="btnAction" type="submit" value="Approve" />
		</c:if>

	</form>
</body>
</html>
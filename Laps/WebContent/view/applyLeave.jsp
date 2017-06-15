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
	<form  method="post">
		<h1>Leave Application</h1>
		<br>

		<c:if test="${ param['submit'] == 'Submit' }">
			<h2>${ msg }</h2>
		</c:if>
		<table border="2" cellpadding="6" cellspacing="8">
			<tr>


			</tr>
			<tr>
				<td>Leave Type <br> <select name="leavetype">
						<option value="1">Annual Leave</option>
						<option value="2">Medical Leave</option>
						<option value="3">Compensation</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Date Range:
					<table>
						<tr>
							<td>From :</td>
							<td><input type="text" data-provide="datepicker" name="StartDate" readonly="readonly"></td>
						</tr>
						<tr>
							<td>To :</td>
							<td><input type="text" data-provide="datepicker" name="EndDate" readonly="readonly"></td>
						</tr>
						<tr>
							<td>Reasons:</td>
							<td><input type="text" name="reasons"></td>
						</tr>
					</table> <input type="submit" name="submit" value="Submit" />
		</table>
	</form>
</body>
</html>
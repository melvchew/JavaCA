<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Update Holidays</title>
</head>
<body>
<center>
<font color="#57C9F4" size=8>Update Holidays</font>
<hr>
<c:if test="${ param['submit'] == 'Submit' }">
	<p>The holiday is updated!</p>
</c:if>
<form method="post">
<table border="1" >
<tr>
<td bgcolor="#57C9F4">Date:</td>
<td><input name="date" type="text" data-provide="datepicker" value="${param['date'] }"></td>
<td bgcolor="#57C9F4">Description:</td>
<td><input name="Description" value=""></td>
</tr>
<tr>
<td>
<center>
<input type="submit" value="Submit" name="submit">
<input type="reset" value="Reset"> 
</center>
</td>
</tr>

</table>

</form>
<a href="viewholidays">Check</a>
</center>
</body>
</html>
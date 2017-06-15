<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Holidays Details</title>
</head>
<body>
<center>
<font color="#57C9F4" size=8>Holidays Details</font>
<hr>
	
	<table align="center"  border="4" width=700px height=70px >

	     <tr >
	     <td bgcolor="#57C9F4" >Index</td>
         <td bgcolor="#57C9F4">Date</td>
         <td bgcolor="#57C9F4">Description</td>
         <td bgcolor="#57C9F4">Opertion</td>
         </tr>
		<c:forEach items="${slist}" var="holidays" varStatus="i">
			
			<tr>
				<td>${i.index+1}</td>

				<td><fmt:formatDate pattern="MM/dd/yyyy" value="${holidays.date}" /></td>

				<td>${holidays.description}</td>
				
				<td>  
			    <a href="updateholiday?date=<fmt:formatDate pattern="MM/dd/yyyy" value="${holidays.date}" />">Update</a>
				<a href="insertholiday">Insert</a>
                <a href="viewholidays?date=<fmt:formatDate pattern="MM/dd/yyyy" value="${holidays.date}" />">Delete</a>      
				</td>
			</tr>
			
		</c:forEach>
	</table>
</center>
	
	
</body>
</html>
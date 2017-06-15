<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Position Detials</title>
</head>
<body>
<center>
<font color="#57C9F4" size=8>Position Detials</font>
<hr>
	
	<table align="center"  border="4" width=700px height=70px >

	     <tr >
	     <td bgcolor="#57C9F4" >Index</td>
         <td bgcolor="#57C9F4">JobTitle</td>
         <td bgcolor="#57C9F4">AccessLevelName</td>
          <td bgcolor="#57C9F4">DeleteFlag</td>
         <td bgcolor="#57C9F4">Opertion</td>
         </tr>
		<c:forEach items="${slist}" var="position" varStatus="i">
			
			<tr>
				<td>${position.positionId}</td>
				<td>${position.jobTitle}</td>
				<td>${position.accessLevel.accessLevelName}</td>
				<td>${position.deleteFlag}</td>
				<td>  
				 <a href="updateposition?positionId=${position.positionId}">Update</a> 
                 <a href="insertposition">Insert</a> 
                 <a href= "viewpositions?positionId=${position.positionId}">Delete</a>   
				</td>
			</tr>
			
		</c:forEach>
	</table>
</center>
	
	
</body>
</html>
<%@page import="model.UsersDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>

</head>
<body>

<h2>Update User</h2>

<%
UsersDTO u= (UsersDTO)request.getAttribute("u");
%>

<form name="updateUserForm"  method="post">
<input type="hidden" value="${u.username}" name="originalName" />

    User Name: <input type="text" name="uname" value="${u.username}" /><br>
    
    Password: <input type="text" name="passwd" value="${u.password}" /><br>
    
    Position Id: <input type="text" name="posid" value="${u.position.positionId}" /><br><!-- Need drop down list -->
    
    Name: <input type="text" name="name" value="${u.name}" /><br>
    
    Birth Date: <input type="text" data-provide="datepicker" readonly="readonly" name="dob" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${u.dob}" />" /> (Format: m/d/y)<br>
    
    Phone: <input type="text" name="phone" value="${u.phone}" /><br>
    
    Address: <input type="text" name="addr" value="${u.address}" /><br>
    
    Email: <input type="text" name="email" value="${u.email}" /><br>
    
    Manager Id: <input type="text" name="manageid" value="${u.managerId}" /><br><!-- Need drop down list -->
    
    OverTime Hours: <input type="text" name="othour" value="${u.otHours}" /><br>

  <input type="submit" value="Update" /><br>
</form>

</body>
</html>
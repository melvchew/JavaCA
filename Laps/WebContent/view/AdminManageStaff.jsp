<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Staff</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
    font-size: 1em;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
</style>

</head>

<body>
<h2> User List </h2>
<p>All the current user details.</p>
<!-- button works Only when run on this.jsp??!!! -->


<a href="/Laps/admin/createuser">Create User</a>


<table id="tabUser" style="width: 100%">

  <tr>
    <th style="width: 7%">User Id</th>
    <th style="width: 7%">User Name</th>
    <th style="width: 6%">Password</th>
    <th style="width: 10%">Position Id</th>
    <th style="width: 6%">Name</th>
    <th style="width: 10%">Birthday(m/d/y)</th>
    <th style="width: 7%">Phone</th>
    <th style="width: 7%">Address</th>
    <th style="width: 7%">Email</th>
    <th style="width: 7%">Manager Id</th>
    <th style="width: 7%">OverTime hour</th>
    <th style="width: 9%">Update User</th>
    <th style="width: 9%">Delete User</th>
  </tr>
 
  
  <c:forEach items="${uList}" var="ul"> 
   <tr>
  	<td><c:out value ="${ul.userId}"/></td>
  	<td>${ul.username}</td>
  	<td>${ul.password}</td>
  	<td>${ul.position.positionId}</td>
  	<td>${ul.name}</td>
  	<td><fmt:formatDate pattern="MM/dd/yyyy" value="${ul.dob}" /></td>
  	<td>${ul.phone}</td>
  	<td>${ul.address}</td>
  	<td>${ul.email}</td>
  	<td>${ul.managerId}</td>  
  	<td>${ul.otHours}</td>
  	<td><a href="/Laps/admin/upduser?username=${ul.username}">Update</a></td>
  	<td><a href="/Laps/admin/deluser?username=${ul.username}">Delete</a></td>
  	<!-- Need massage for delete!!!! -->
  	
  	</tr> 
 </c:forEach> 
</table>


</body>
</html>
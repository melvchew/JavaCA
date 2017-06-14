<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Manage Default Leave</title>



<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

.button {
	display: inline-block;
	border-radius: 4px;
	background-color: #f4511e;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 14px;
	padding: 10px;
	width: 100px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

input[type=text] {
	width: 40%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}
</style>
</head>
<body>
	<h1>Default Leave</h1>
	<!-- <p>Add the border-bottom property to th and td for horizontal dividers:</p> -->
	<form method="post" action='/Laps/AdminManageDefaultLeaveController'>
		<table>
			<tr>
				<th>Position</th>
				<th>Leave Type</th>
				<th>Days</th>
			</tr>
			<c:forEach items="${dlList }" var="dl">
				<tr>
					<td><c:out value="${dl.positionId }"/></td>
					<td>${dl.leaveTypeId }</td>
					<td><input required type="number" step="0.5" name="${dl.leaveTypeId }${dl.positionId }"  value="${dl.days}"></td>
				</tr>
			</c:forEach>


		</table>
			
		<button class="button" style="vertical-align: middle">
			<span>Update </span>
		</button>
		</form>
		
</body>
</html>
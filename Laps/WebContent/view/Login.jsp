<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<center>
			<table>
				<thead>
					<tr>
						<th colspan="2" align="center">Log In</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>User Name:</td>
						<td><input type="text" name="txtUname" value="" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="txtPwd" value="" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="Login" />
						<input type="reset" value="Reset" /></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>
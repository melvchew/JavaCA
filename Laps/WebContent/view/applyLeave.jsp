<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="applyLeave.jsp" enctype=text/plain>
		<h1>Leave Application</h1>
		<br>

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
							<td><input type="text" name="StartDate "></td>
						</tr>
						<tr>
							<td>To :</td>
							<td><input type="text" name="EndDate"></td>
						</tr>
						<tr>
							<td>Reasons:</td><td><input type="text" name="reasons"></td>
						</tr>
					</table> <input type="submit" name="submit" value="Submit" />
		</table>
	</form>
</body>
</html>
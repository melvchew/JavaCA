<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<font color="#57C9F4" size=8>Insert Position</font>
<hr>
<c:if test="${ param['submit'] == 'Submit' }">
	<p>The position is inserted!</p>
</c:if>
<form method="post">
<table border="2" >
<tr>
<td bgcolor="#57C9F4">JobTitle:</td>
<td><input name="JobTitle" value=""></td>
<td bgcolor="#57C9F4">AccessLevelNam:</td>
<td>
<select name="select">
  <option value="1" selected>Manager</option>
  <option value="2">employee</option>
</select>
</td>
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
<a href="viewpositions">Check</a>
</center>
</body>
</html>
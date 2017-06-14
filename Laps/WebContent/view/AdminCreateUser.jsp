<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>

</head>
<body>
<h2>Create User</h2>
<form name="createUserForm" method="post">

    User Name: <input type="text" name="uname" /><br>
    Password: <input type="text" name="passwd" /><br>
    Position Id: <input type="text" name="posid" /><br><!-- Need drop down list -->
    Name: <input type="text" name="name" /><br>
    Birth Date: <input type="text" name="dob" /><br>
    Phone: <input type="text" name="phone" /><br>
    Address: <input type="text" name="addr" /><br>
    Email: <input type="text" name="email" /><br>
    Manager Id: <input type="text" name="manageid" /><br><!-- Need drop down list -->

  <input type="submit" value="Submit" /><br>
</form>
</body>
</html>
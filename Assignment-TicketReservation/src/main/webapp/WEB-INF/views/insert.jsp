<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<form action="register" method="post">
UserName:<input type="text" name="username"/><br/>
Password:<input type="password" name="password"/><br/>
Email :<input type="email" name="email"/><br/>
FirstName:<input type="text" name="firstname"/><br/>
LastName:<input type="text" name="lastname"/><br/>
Address:<input type="text" name="address"/><br/>
<input type="submit" value="register"/>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Insert Movie Timing</h2>
<form action="ltime" method="post">
<input type="hidden" name="timing_id" value=${msg}>
Movie Timing:<input type="text" name="timing"/>
<input type="submit" value="click">
</form>
</body>
</html>
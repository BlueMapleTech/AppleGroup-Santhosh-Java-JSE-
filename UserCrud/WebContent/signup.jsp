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
<p align="center">REGISTRATION	FORM</p><br>

<form action="UserController" method="post">

 <% String action = request.getParameter("action");%>
 <%HttpSession hs=request.getSession(true);
String action1=(String) hs.getAttribute("action"); 

%>
 <% if (((action1!=null)||(action!=null))&&((action1.length()>0)||(action.length()>0))) {%>
            User Name : <input type="text" name="name"
                               value="<c:out value="${user.name}" />" readonly="readonly"/> (You Can't Change this)<br />
     <input type="hidden" name="action1" value="update"> 
            <%} else {%>
            User Name : <input type="text" name="name"
                               value="<c:out value="${user.name}" />" /> <br />
<input type="hidden" name="action1" value="signup"/>
            <%}%>
Password   :      <input type="password" name="pass"  value="<c:out value="${user.pass}" />" /> <br>
 <% if (((action1!=null)||(action!=null))&&((action1.length()>0)||(action.length()>0))) {%>
            Email : <input type="text" name="email"
                               value="<c:out value="${user.email}" />" readonly="readonly"/> (You Can't Change this)<br /> 
            <%} else {%>
            Email : <input type="text" name="email"
                               value="<c:out value="${user.email}" />" /> <br />
            <%}%>
Contact No :      <input type="text" name="contact" value="<c:out value="${user.contact}" />"/><br>
First Name :      <input type="text" name="fname" value="<c:out value="${user.fname}" />"/><br>
Last Name  :      <input type="text" name="lname" value="<c:out value="${user.lname}" />"/><br>
Sex        :      <input type="text" name="sex" value="<c:out value="${user.sex}" />"/><br> 
Address    :      <input type="text" name="addr" value="<c:out value="${user.addr}" />"/><br>

                  <input type="hidden" name="role" value="admin" value="<c:out value="${user.id}" />"/><br/>
	
 
<input type="submit" value="update"/>

</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validateForm() {
    var x = document.forms["form"]["name"].value;
    var y = document.forms["form"]["pass"].value; 
    var n=y.length;
    var y1 = document.forms["form"]["email"].value;
    var y2 = document.forms["form"]["contact"].value;
    var y3 = document.forms["form"]["fname"].value;
    var y4 = document.forms["form"]["lname"].value;
    var y5 = document.forms["form"]["sex"].value;
    var y6 = document.forms["form"]["addr"].value;
 if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
 }else
    if ((y == null || y == "")||(n<=6)) {
        alert(" password atleast 6 character length");
        return false;
    }          else   	
    	
    

    if (y1 == null || y1 == "") {
        alert("email must be filled out");
        return false;
 

}else

    if (y2 == null || y2 == "") {
        alert("contact no must be filled out");
        return false;
 

}else

    if (y3 == null || y3 == "") {
        alert("firstname must be filled out");
        return false;
 

}else

    if (y4 == null || y4 == "") {
        alert("lastname must be filled out");
        return false;
 

}else

    if (y5 == null || y5 == "") {
        alert("sex must be filled out");
        return false;
 

}else

    if (y6 == null || y6 == "") {
        alert("address must be filled out");
        return false;
        

}else
	{
	
	}

}
</script>
</head>
<body>
	<form name="form"onsubmit="return validateForm()" action="UserController" method="get">



		<%
			HttpSession hs = request.getSession(true);
			String action1 = (String) hs.getAttribute("action");
		%>
		<%
			if ((action1 != null) && (action1.length() > 0)) {
		%>
		User Name : <input type="hidden" name="name" value=sdfsf 
			value="<c:out value="${user.name}" />" readonly="readonly" /> (You
		Can't Change this)<br /> <input type="hidden" name="action"
			value="update">

		<%
			} else {
		%>
		User Name : <input type="text" name="name"
			value="<c:out value="${user.name}" />" /> <br />

		<%
			}
		%>
		Password : <input type="password" name="pass"
			value="<c:out value="${user.pass}" />" /> <br>
		<%
			if ((action1 != null) && (action1.length() > 0)) {
		%>
		Email : <input type="hidden" name="email" value=fdsfs
			value="<c:out value="${user.email}" />" readonly="readonly" /> (You
		Can't Change this)<br />
		<%
			} else {
		%>
		Email : <input type="text" name="email"
			value="<c:out value="${user.email}" />" /> <br />
		<%
			}
		%>
		Contact No : <input type="text" name="contact"
			value="<c:out value="${user.contact}" />" /><br> First Name : <input
			type="text" name="fname" value="<c:out value="${user.fname}" />" /><br>
		Last Name : <input type="text" name="lname"
			value="<c:out value="${user.lname}" />" /><br> Sex : <input
			type="text" name="sex" value="<c:out value="${user.sex}" />" /><br>
		Address : <input type="text" name="addr"
			value="<c:out value="${user.addr}" />" /><br> <input
			type="hidden" name="role" value="admin"
			value="<c:out value="${user.id}" />" /><br /> <input type="submit"
			value="update" />

	</form>


</body>
</html>
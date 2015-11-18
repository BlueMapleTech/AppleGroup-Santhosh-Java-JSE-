<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show list of user</title>
</head>
<body>
	<jsp:include page="link.html" />
	<table border=1>
		<thead>
			<tr>
				<th>user_id</th>
				<th>username</th>
				<th>password</th>
				<th>email</th>
				<th>contactno</th>
				<th>firstname</th>
				<th>lastname</th>
				<th>sex</th>
				<th>addr</th>
				<th>createdby</th>
				<th>updatebdy</th>
				<th>createddate</th>
				<th>updateddate</th>
				<th>role_role_id</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.user_id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.pass}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.contact}" /></td>
					<td><c:out value="${user.fname}" /></td>
					<td><c:out value="${user.lname}" /></td>
					<td><c:out value="${user.sex}" /></td>
					<td><c:out value="${user.addr}" /></td>
					<td><c:out value="${user.createdby}" /></td>
					<td><c:out value="${user.updatedby}" /></td>
					<td><c:out value="${user.createddate}" /></td>
					<td><c:out value="${user.updateddate}" /></td>
					<td><c:out value="${user.id}" /></td>

					<td><a
						href="UserController?action=delete&userId=<c:out value="${user.name}"/>">Delete</a></td>
					<td><a
						href="UserController?action=edit&userId=<c:out value="${user.name}"/>">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
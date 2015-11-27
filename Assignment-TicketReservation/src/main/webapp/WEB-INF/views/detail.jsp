<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

	<h1>Book U6 Show</h1>
    
	<br>
	<h2>Admin Page</h2>

	<a href="hom">home</a>!!
	<a href="llists">movielist</a>!!
	<a href="timelist">timing</a>!!
	<a href="count">tikcount</a>!!
	<p>------------------------------------------------------------------------------------------------------------------------------------</p>
	<div class="row">
		<div class="col-sm-12" >
			<div class="col-sm-6" style="background-color: lavender;">
				MOVIE LIST
				<table border=1 class="table">
					<thead>
						<tr>
							<th>name</th>
							<th>Release</th>
							<th colspan=1>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${details}" var="user">
							<tr>
								<td><c:out value="${user.moviename}" /></td>
								<td><c:out value="${user.release_date}" /></td>
								<td><a href="edit?name=<c:out value="${user.movie_id}"/>">edit</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-sm-6" style="background-color: lavender;">
				TIME LIST
				<table border=1 class="table">
					<thead>
						<tr>
							<th>timing</th>
							<th colspan=1>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${timel}" var="user">
							<tr>
								<td><c:out value="${user.timing}" /></td>
								<td><a
									href="edittime?id=<c:out value="${user.timing_id}"/>">edit</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>
</html>
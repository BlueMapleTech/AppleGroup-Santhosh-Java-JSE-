<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<h4>${msg}</h4>
<form action="log" method="post">
UserName :<input type="text" name="username"/><br>
Password :<input type="password" name="password"/><br/>
<input type="submit" value="login"/>
</form>
<form action="signup" method="get">
<input type="submit" value="registration"/>
</form>
</body>
</html>

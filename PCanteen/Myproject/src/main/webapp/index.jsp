<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body align="center" background="22.jpg">
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<center>
<form action="Login" method="post">
<div class="container">
	<div class="row">
		<div class="text-center">
			<br>
				<div class="col-lg-30 col-md-30 col-sm-30 col-sx-50"></div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-sx-12">
						<div class="jumbotron-center">
						<h1 class="text-center" style="color:blue">Login Page</h1>
						<br>
						<br>
							<div class="form-group">
							<label class="control-label" for="username" style="color:yellow">Enter UserName:</label><br>
							<br>
							<input type="text" name="uname" class="form-control" placeholder="UserName">
							</div>
							<br>
							<div class="form-group">
							<label class="control-label" for="password" style="color:red">Enter Password:</label>
							<br>
							<br>
							<input type="password" name="pass" class="form-control" placeholder="PassWord">
							</div>
							<br>
						<div>
						<button type="submit" class="btn btn-outline-warning">Login</button>
						</div>
						</div>
					</div>
			</div>
	</div>
</div>
</form>
</center>
</body>
</html>
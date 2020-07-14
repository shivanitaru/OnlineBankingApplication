<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<center>
		<form action="LoginController" method="post">
			<h4>
					<%
				    if(null!=request.getAttribute("errorMessage"))
				    {
				        out.println(request.getAttribute("errorMessage"));
				    }
					%>
			</h4>
			<label>Username: </label>
			<input type="text" name="uname" placeholder="Enter your username" required><br>
			<label>Password: </label>
			<input type="password" name="pass" placeholder="Enter your password" required><br>
			<input type="submit" value="Login"><br>
			Don't have an account? <a href="RegistrationPage.jsp">Register Now</a><br>
			<a href="ForgotPassword.jsp">Forgot Your Password? </a><br>
		</form>
	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Page</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="css/login_form.css">
	<link rel="stylesheet" href="all.min.css">
</head>

<body>
	<div class="inner-login">
		<div class="photo">
			<img src="assets/images/login_page.png">
			<button class="bt" onclick="location.href='IndexPage.jsp'">Home</button>
		</div>
		<div class="user-form">
			<h1>Login here</h1>
			<form action="LoginController" method="post">
				<h4>
					<%
					    if(null!=request.getAttribute("errorMessage"))
					    {
					        out.println(request.getAttribute("errorMessage"));
					    }
					%>
				</h4>
				<i class="fa fa-user fa-lg fa-fw"></i>
				<input type="text" name="uname" placeholder="Enter your username" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$" title="e.g. abc@gmail.com"required><br>
				<i class="fa fa-key fa-lg fa-fw"></i>
				<input type="password" name="pass" placeholder="Enter your password"  
							title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required><br>
				<a href="ForgotPassword.jsp">Forgot your password?</a><br></br>
				<div class="action-btn">
					<input id="login_btn" class="btn primary" type="submit" value="Log In"><br>
				</div>
				<br>
				<div class="registration_link">
					Don't have an account? <a href="RegistrationPage.jsp">Register Now</a><br>
				</div>
			</form>
		</div>
	</div>
</body>

</html>
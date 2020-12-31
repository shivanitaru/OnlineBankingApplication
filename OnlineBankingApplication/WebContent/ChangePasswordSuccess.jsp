<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
</head>
<body>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // http 1.1
response.setHeader("Pragma","no-cache"); // http 1.0
response.setHeader("Expires","0"); // proxies

if(session.getAttribute("uname")==null){
response.sendRedirect("LoginPage.jsp");}
 %>
	<div id="RegisterMessage">
		<center>

			<h1 class="text-center my-5">Your password is changed is Successfully.</h1>
	<form action="LoginPage.jsp">
				<button type="submit" class="btn btn-primary">OK</button>
			</form>
		</center>
	</div>
</body>
</html>
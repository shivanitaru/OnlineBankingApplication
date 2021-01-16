<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Home Page</title>
	<link rel="stylesheet" href="css/style.css" >
	<link rel="stylesheet"  href="css/home_page.css">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
</head>

<body>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // http 1.1
response.setHeader("Pragma","no-cache"); // http 1.0
response.setHeader("Expires","0"); // proxies

if(session.getAttribute("uname")==null){
response.sendRedirect("LoginPage.jsp");}
 String uname=(String) session.getAttribute("uname");
		String CustomerName = (String)session.getAttribute("CustName"); %>
	<marquee class="bg-light">
		<% out.println("Hello " + CustomerName + " , Welcome to Home Page!!!"); %>
	</marquee>

	<!-- Header -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand header-img" href=""> <img
				src="assets/images/bank_logo.png" width="70px" height="70px" alt="logo" />
		</a> <a class="navbar-brand bank-name" href="#">Bank of Pune</a>

		<button class="navbar-toggler" id="menu-toggle">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<!-- Header -->

	<div class="d-flex" id="wrapper">
		<!-- Sidebar -->
		<div class="bg-light border-right" id="sidebar-wrapper">
			<div class="list-group list-group-flush">
				<a href="AccountDetails.jsp" class="list-group-item list-group-item-action bg-light">Account
					Details</a>
				<a href="BeneficiaryDetails.jsp" class="list-group-item list-group-item-action bg-light">Beneficiary
					Details</a>
				<a href="BankStatement.jsp" class="list-group-item list-group-item-action bg-light">Bank
					Statement</a>
				<a href="FundTransfer.jsp" class="list-group-item list-group-item-action bg-light">Fund
					Transfer</a>
				<a href="MyProfile.jsp" class="list-group-item list-group-item-action bg-light">My
					Profile</a>
				<a href="ChangePassword.jsp" class="list-group-item list-group-item-action bg-light">Change Password</a>
				<a href="UserLogoutServlet" class="list-group-item list-group-item-action bg-light">Logout</a>
			</div>
		</div>
		<!-- Sidebar -->
		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="page-bg">
				<marquee>
					<h2 align="center">
						<font size="6" color="white">WELCOME TO ONLINE SERVICES OF
							BANK OF PUNE!!!</font>
					</h2>
				</marquee>

				<p align="center">
					<font size="5" color="white">We provide you the online money
						transferring and account handling services to make you easy to
						handle banking activities anywhere and anytime!! </font>
				</p>

				<h3 align="center">
					<font size="6" color="white" >HOPE YOU WILL BE SATISFIED BY
						THE SERVICE!!</font>
				</h3>
			</div>
		</div>
		<!-- Page Content -->

		<!-- Font Awesome CDN -->
		<script src="https://kit.fontawesome.com/66c71429b9.js" crossorigin="anonymous"></script>

		<!-- Bootstrap JS CDN -->
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
			integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
		</script>

		<!-- JQuery CDN -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

		<script type="text/jQuery">
			// Toggle Click Function
	    $('#menu-toggle').on('click', function (e) {
	      e.preventDefault();
	      $('#wrapper').toggleClass('toggled');
	    });
		</script>
</body>

</html>
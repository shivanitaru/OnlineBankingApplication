<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Home Page</title>
	<link rel="stylesheet" href="css/style.css" />

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
</head>

<body>
	<% String uname=(String) session.getAttribute("uname");
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
					Statement</a> <a href="FundTransfer.jsp"
					class="list-group-item list-group-item-action bg-light">Fund
					Transfer</a> <a href="MyProfile.jsp" class="list-group-item active-link list-group-item-action">My
					Profile</a> <a href="ChangePassword.jsp"
					class="list-group-item list-group-item-action bg-light">Change Password</a> <a href="IndexPage.jsp"
					class="list-group-item list-group-item-action bg-light">Logout</a>
			</div>
		</div>
		<!-- Sidebar -->
		<!-- Page Content -->
		<div id="page-content-wrapper">

			<h1 class="text-center mb-5 mt-2">My Profile</h1>

			<%
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System",
							"123456789");
					Statement stmt = conn.createStatement();
					String query = "select * from CustomerPersonalDetails where EMAIL_ID='" + uname + "'";
					ResultSet rs1 = stmt.executeQuery(query);
			%>
			<!-- Personal Details -->
			<h3 class="text-center">Personal Details</h3>
			<table border=1 align=center style="text-align: center">
				<%
						while (rs1.next()) {
				%>
				<tr>
					<th>Name</th>
					<td><%=rs1.getString("CUSTOMER_NAME")%></td>
				</tr>
				<tr>
					<th>Father's Name</th>
					<td><%=rs1.getString("CUSTOMER_FATHERS_NAME")%></td>
				</tr>
				<tr>
					<th>Date of Birth</th>
					<td><%=rs1.getDate("DOB")%></td>
				</tr>
				<tr>
					<th>Gender</th>
					<td><%=rs1.getString("GENDER")%></td>
				</tr>
				<tr>
					<th>Mobile Number</th>
					<td><%=rs1.getLong("MOBILE_NUMBER")%></td>
				</tr>
				<tr>
					<th>Email Id</th>
					<td><%=rs1.getString("EMAIL_ID")%></td>
				</tr>
				<tr>
					<th>Nationality</th>
					<td><%=rs1.getString("NATIONALITY")%></td>
				</tr>
				<%
					}
						query = "select * from CustomerIdentityDetails where EMAIL_ID='" + uname + "'";
						ResultSet rs2 = stmt.executeQuery(query);
						while (rs2.next()) {
				%>
				<tr>
					<th>Aadhaar Number</th>
					<td><%=rs2.getString("AADHAR_NO")%></td>
				</tr>
				<tr>
					<th>Pan Card Number</th>
					<td><%=rs2.getString("PANCARD_NO")%></td>
				</tr>

				<%
					}
				%>
			</table>
			<br>

			<!-- Personal Details -->

			<!-- Address Details -->
			<h3 class="text-center">Address Details</h3>
			<table border=1 align=center style="text-align: center">
				<%
				query = "select * from CustomerAddressDetails where EMAIL_ID='" + uname + "'";
				ResultSet rs3 = stmt.executeQuery(query);
					while (rs3.next()) {
				%>
				<tr>
					<th>Address</th>
					<td><%=rs3.getString("ADDRESS")%></td>
				</tr>
				<tr>
					<th>City</th>
					<td><%=rs3.getString("CITY")%></td>
				</tr>
				<tr>
					<th>Pin Code</th>
					<td><%=rs3.getInt("PINCODE")%></td>
				</tr>
				<tr>
					<th>State</th>
					<td><%=rs3.getString("STATE")%></td>
				</tr>
				<%
					}
				%>
			</table>
			<!-- Address Details -->
			<br>
			<%
				} catch (Exception e) {
					out.print(e.getMessage());
			%><br>
			<%
				}
			%>



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
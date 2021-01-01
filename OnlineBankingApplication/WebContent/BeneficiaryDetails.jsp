<%@page import="com.DAO.BeneficiaryDAO" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
	<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // http 1.1
	response.setHeader("Pragma","no-cache"); // http 1.0
	response.setHeader("Expires","0"); // proxies

	if(session.getAttribute("uname")==null){
	response.sendRedirect("LoginPage.jsp");}
 
	String uname=(String) session.getAttribute("uname"); String CustomerName=(String)
					session.getAttribute("CustName"); %>
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
					Details</a> <a href="BeneficiaryDetails.jsp"
					class="list-group-item active-link list-group-item-action">Beneficiary
					Details</a> <a href="BankStatement.jsp" class="list-group-item list-group-item-action bg-light">Bank
					Statement</a> <a href="FundTransfer.jsp"
					class="list-group-item list-group-item-action bg-light">Fund
					Transfer</a> <a href="MyProfile.jsp" class="list-group-item list-group-item-action bg-light">My
					Profile</a> <a href="ChangePassword.jsp"
					class="list-group-item list-group-item-action bg-light">Change
					Password</a> 				<a href="UserLogoutServlet" class="list-group-item list-group-item-action bg-light">Logout</a>

			</div>
		</div>
		<!-- Sidebar -->
		<!-- Page Content -->
		<div id="page-content-wrapper">


			<h1 class="text-center mb-5 mt-2">Beneficiary Details</h1>

			<!-- Add Beneficiary -->
			<div class="mx-4 my-4 row justify-content-center align-items-center">
				<div class="col-lg-8 col-md-8 col-sm-12 col-xs-8 shadow">
					<form action="AddBeneficiaryController" method="post" class="px-4 py-4">
					<h6 style="color:red">
					<%
					    if(null!=request.getAttribute("invalidBeneficiaryAccountNumberErrorMessage"))
					        out.println(request.getAttribute("invalidBeneficiaryAccountNumberErrorMessage"));
					    else if(null!=request.getAttribute("alreadyExistBeneficiaryAccountNumberErrorMessage"))
					        out.println(request.getAttribute("alreadyExistBeneficiaryAccountNumberErrorMessage"));
					%>
				</h6>
						<h3 class="mx-auto text-center">Add beneficiary</h3>
						<!-- Beneficiary Account No. -->
						<label for="beneficiaryAccountNo" class="field-label">Beneficiary
							Account No.</label> <input type="number" class="form-control" name="beneficiaryAccountNo"
							id="beneficiaryAccountNo" required pattern="[0-9]{7}$*"
							onkeypress="return event.charCode >= 48" min="0">
						<!-- Beneficiary Account No. -->

						<!-- Beneficiary Name -->
						<label for="beneficiaryName" class="field-label">Beneficiary
							Name</label> <input type="text" class="form-control" name="beneficiaryName"
							id="beneficiaryName" required pattern="[a-zA-Z0-9\s]+">
						<!-- Beneficiary Name -->

						<!-- IFSC Code -->
						<label for="IFSCCode" class="field-label">IFSC Code</label> <input type="text" name="IFSCCode"
							class="form-control" id="IFSCCode" required pattern="[A-Z]{4}0[A-Z]{6}"title="ABCD0ABCDEF">
						<!-- IFSC Code -->

						<!-- Branch Name -->
						<label for="branchName" class="field-label">Branch Name</label> <input type="text"
							name="branchName" class="form-control" id="branchName" required pattern="[a-zA-Z0-9\s]+">
						<!-- Branch Name -->

						<!-- Bank Name -->
						<label for="bankName" class="field-label">Bank Name</label> <input type="text" name="bankName"
							class="form-control" id="bankName" required pattern="[a-zA-Z0-9\s]+">
						<!-- Bank Name -->

						<div class="text-center pt-4">
							<button type="submit" class="btn btn-primary">Add</button>
							<button type="reset" class="btn btn-danger">Cancel</button>
						</div>
					</form>
				</div>
			</div>
			<!-- Add Beneficiary -->

			<!-- Display Beneficiary List -->
			<h3 class="text-center mt-5 mb-2">List of Beneficiary</h3>
			<% BeneficiaryDAO BeneficiaryDAOobj=new BeneficiaryDAO();
								long accountNumber=BeneficiaryDAOobj.getAccountNumber(uname);
								try {
								Class.forName("oracle.jdbc.OracleDriver"); 
								Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "123456789" ); 
								Statement stmt=conn.createStatement(); 
								String query="select * from BeneficiaryDetails where ACCOUNT_NO='" + accountNumber + "'" ;
								ResultSet rs1=stmt.executeQuery(query); 
								if (rs1!=null){
								%>
								
			<table border=1 align=center style="text-align: center">
				<tr>
					<th>Account No</th>
					<th>Name</th>
					<th>IFSC Code</th>
					<th>Branch Name</th>
					<th>Bank Name</th>
				</tr>
				<tr>
					<% while (rs1.next()) { %>
					<td>
						<%=rs1.getLong("BENEFICIARY_ACCOUNT_NO")%>
					</td>

					<td>
						<%=rs1.getString("BENEFICIARY_NAME")%>
					</td>

					<td>
						<%=rs1.getString("IFSC_CODE")%>
					</td>
					<td>
						<%=rs1.getString("BRANCH_NAME")%>
					</td>
					<td>
						<%=rs1.getString("BANK_NAME")%>
					</td>
					<% } %>
				</tr>
			</table>
			<%}
			else{%>
			<br>
			<div class="text-center">
				<h5>No Beneficary Added</h5>
			</div>
			<% }
					} catch (Exception e) { out.print(e.getMessage()); %><br>
			<% } %>
			<br>
			<!-- Display Beneficiary List -->
		</div>
		<!-- Page Content -->
	</div>
	<!-- Font Awesome CDN -->
	<script src="https://kit.fontawesome.com/66c71429b9.js" crossorigin="anonymous"></script>

	<!-- Bootstrap JS CDN -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
	</script>

	<!-- JQuery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- <script type="text/jQuery">
		// Toggle Click Function
	    $('#menu-toggle').on('click', function (e) {
	      e.preventDefault();
	      $('#wrapper').toggleClass('toggled');
	    });
		</script> -->
</body>

</html>
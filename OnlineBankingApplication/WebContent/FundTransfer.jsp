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
	<% String uname=(String) session.getAttribute("uname"); String
			CustomerName=(String)session.getAttribute("CustName"); %>
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
				<a href="FundTransfer.jsp" class="list-group-item active-link list-group-item-action">Fund
					Transfer</a>
				<a href="MyProfile.jsp" class="list-group-item list-group-item-action bg-light">My
					Profile</a>
				<a href="ChangePassword.jsp" class="list-group-item list-group-item-action bg-light">Change
					Password</a>
				<a href="IndexPage.jsp" class="list-group-item list-group-item-action bg-light">Logout</a>
			</div>
		</div>
		<!-- Sidebar -->
		<!-- Page Content -->
		<div id="page-content-wrapper">

			<h1 class="text-center mb-5 mt-2">Fund Transfer</h1>

			<!-- Fund Transfer -->
			<div class="mx-4 my-4 row justify-content-center align-items-center">
				<div class="col-lg-8 col-md-8 col-sm-12 col-xs-8 shadow">
					<form action="FundTransferController" method="post" class="px-4 py-4">
					<h6 style="color:red">
					<%
					    if(null!=request.getAttribute("invalidRemitterAccountNumberErrorMessage"))
					        out.println(request.getAttribute("invalidRemitterAccountNumberErrorMessage"));
					    else if(null!=request.getAttribute("invalidBeneficiaryAccountNumberErrorMessage"))
					        out.println(request.getAttribute("invalidBeneficiaryAccountNumberErrorMessage"));
					    else if(null!=request.getAttribute("invalidAmountErrorMessage"))
					        out.println(request.getAttribute("invalidAmountErrorMessage"));
					%>
				</h6>
						<!-- Remitter Account No. -->
						<label for="remitterAccountNo" class="field-label">Remitter
							Account No.</label> <input type="number" class="form-control" name="remitterAccountNo"
							id="remitterAccountNo" required pattern="[0-9]{7}" onkeypress="return event.charCode >= 48"
							min="0">
						<!-- Remitter Account No. -->

						<!-- Beneficiary Account No. -->
						<label for="beneficiaryAccountNo" class="field-label">Beneficiary
							Account No.</label> <input type="number" class="form-control" name="beneficiaryAccountNo"
							id="beneficiaryAccountNo" required pattern="[0-9]{7}"
							onkeypress="return event.charCode >= 48" min="0">
						<!-- Beneficiary Account No. -->

						<!-- Beneficiary Name -->
						<label for="beneficiaryName" class="field-label">Beneficiary
							Name</label> <input type="text" class="form-control" name="beneficiaryName"
							id="beneficiaryName" required pattern="[a-zA-Z0-9\s]+">
						<!-- Beneficiary Name -->

						<!-- IFSC Code -->
						<label for="IFSCCode" class="field-label">IFSC Code</label> <input type="text" name="IFSCCode"
							class="form-control" id="IFSCCode" required pattern="[A-Z]{4}0[A-Z]{6}" title="ABCD0ABCDEF">
						<!-- IFSC Code -->

						<!-- Amount -->
						<label for="amount" class="field-label">Amount</label> <input type="number" name="amount"
							class="form-control" id="amount" required pattern="^[0-9]*$" onkeypress="return event.charCode >= 48" min="1">
						<!-- Amount -->

						<div class="text-center pt-4">
							<button type="submit" class="btn btn-primary">Transfer</button>
							<button type="reset" class="btn btn-danger">Cancel</button>
						</div>
					</form>
				</div>
			</div>
			<!-- Fund Transfer -->
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Home Page</title>
		<link rel="stylesheet" href="css/style.css" />

		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous" />
	</head>

	<body>
		<% String uname=(String) session.getAttribute("uname");
		String CustomerName = (String)session.getAttribute("CustName"); %>
			<marquee class="bg-light">
				<% out.println("Hello " + CustomerName + " , Welcome to Home Page!!!"); %>
			</marquee>

			<!-- Header -->
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand header-img" href=""> <img
						src="assets/images/15106766.jpg" width="70px" height="70px" alt="logo" />
				</a> <a class="navbar-brand bank-name" href="#">Bank Name</a>

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
						<a href="BeneficiaryDetails.jsp" class="list-group-item active-link list-group-item-action">Beneficiary Details</a>
						<a href="BankStatement.jsp" class="list-group-item list-group-item-action bg-light">Bank
							Statement</a>
						<a href="FundTransfer.jsp" class="list-group-item list-group-item-action bg-light">Fund
							Transfer</a>
						<a href="MyProfile.jsp" class="list-group-item list-group-item-action bg-light">My
							Profile</a>
						<a href="ChangePassword.jsp" class="list-group-item list-group-item-action bg-light">Change Password</a>
						<a href="IndexPage.jsp" class="list-group-item list-group-item-action bg-light">Logout</a>
					</div>
				</div>
				<!-- Sidebar -->
				<!-- Page Content -->
				<div id="page-content-wrapper">
				
				
		<h1 class="text-center mb-5 mt-2">Beneficiary Details</h1>

		<div class="mx-4 my-4 row justify-content-center align-items-center">
			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-8 shadow">
			  <form class="formGroup px-4 py-4"
				[class.has-error]="(firstName.invalid && firstName.touched) || (lastName.invalid && lastName.touched) || (email.invalid && email.touched) || (courses.invalid && courses.touched)">
				<h3 class="mx-auto text-center">Add beneficiary</h3>
		  
				<!--FirstName-->
				<label for="firstName">FirstName</label>
				<input type="text" class="form-control" id="FirstName" pattern="^[a-zA-Z]*$" formControlName="firstName">
				<div class="text-danger" *ngIf="(firstName.invalid && firstName.touched)">
				  *FirstName is required
				</div>
				<div *ngIf="firstName.errors?.pattern" style="color: red">
				  *Firstname not valid.
				</div> <br>
				<!--FirstName end-->
		  
				<!--LastName-->
				<label for="lastName">LastName</label>
				<input type="text" class="form-control" id="lastName" pattern="^[a-zA-Z]*$" formControlName="lastName">
				<div class="text-danger" *ngIf="lastName.invalid && (lastName.dirty || lastName.touched)">
				  *LastName is required
				</div>
				<div *ngIf="lastName.errors?.pattern" style="color: red">
				  *Lastname not valid.
				</div><br>
				<!--Lastname end-->
		  
				<!--Email-->
				<label for="email">E-mail</label>
				<input type="email" class="form-control" id="email"
				  pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$" formControlName="email">
				<div class="text-danger" *ngIf="email.invalid && (email.dirty || email.touched)">
				  *Email is Required
				</div>
				<div *ngIf="email.errors?.pattern" style="color: red">
				  *Email not valid.
				</div><br>
				<!--Email end-->
		  
				<!--Course-->
				<label>Course</label>
				<ng-multiselect-dropdown name="courses" [settings]="dropdownSettings" [data]="Courses" formControlName="courses"
				  [attr.disabled]="disabled"></ng-multiselect-dropdown>
		  
				<div class="text-danger" *ngIf="courses.invalid && (courses.dirty || courses.touched)">
				  *Course is Required
				</div>
				<br>
				<!--Course end-->
		  
				<button (click)="register()" tyoe = "button" [disabled]="studentRegistrationForm.invalid" class="btn btn-primary">Register</button>
				<button
				  (click)="cancel()" type= "button" class="btn btn-danger">Cancel</button><br><br>
			  </form>
			</div>
		  </div>
		  
				</div>
				<!-- Page Content -->

				<!-- Font Awesome CDN -->
				<script src="https://kit.fontawesome.com/66c71429b9.js" crossorigin="anonymous"></script>

				<!-- Bootstrap JS CDN -->
				<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
					integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
					crossorigin="anonymous"></script>

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
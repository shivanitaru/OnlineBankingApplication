<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Registration Page</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="css/registerform.css">
    <link rel="stylesheet" href="all.min.css">
    	<link rel="stylesheet" href="css/style.css" />
    
	<script type="text/javascript">
		function nonumberspacetext(x) {

			if ((x.keyCode > 90 && x.keyCode < 97)) {
				alert("No special character allowed");
				return false;
			} else if (x.keyCode < 65 && x.keyCode > 57) {
				alert("No special character allowed");
				return false;
			} else if (x.keyCode < 48 && x.keyCode > 32) {
				alert("No special character allowed");
				return false;
			} else if (x.keyCode > 122) {
				alert("no special character allowed");
				return false;
			} else if (x.keyCode == 32) {
				alert("no space allowed");
				return false;
			} else if (x.keyCode > 47 && x.keyCode < 58) {
				alert("no digit allowed");
				return false;
			}
			return true;
		}


		function nonumbertext(x) {

			if ((x.keyCode > 90 && x.keyCode < 97)) {
				alert("No special character allowed");
				return false;
			} else if (x.keyCode < 65 && x.keyCode > 57) {
				alert("No special character allowed");
				return false;
			} else if (x.keyCode < 48 && x.keyCode > 32) {
				alert("No special character allowed");
				return false;
			} else if (x.keyCode > 122) {
				alert("no special character allowed");
				return false;
			} else if (x.keyCode > 47 && x.keyCode < 58) {
				alert("no digit allowed");
				return false;
			}
			return true;
		}
	</script>

</head>

<body>
	<div class="inner">
	    <!--<div class="photo">
	        <img src="..\images\Register.svg">
	        <button class="bt" onclick="location.href='IndexPage.jsp'">Home</button> 
	    </div>  -->
	    <div class="user-form">
        	<h1>Welcome! Register here</h1>
			<form action="RegisterController" method="post">
				<h4>
					<% if(null!=request.getAttribute("errorMessage")) {
		        	out.println(request.getAttribute("errorMessage")); } %>
				</h4>

		<label>Your Name :</label>
		<br>
		<div class="custom">
			<input type="text" name="FirstName" oninput="inputOn()" placeholder="First Name" required maxlength="15"
			class="input1" autocomplete="off" onkeydown="return nonumberspacetext(event)" />
			<input type="text" name="MiddleName" oninput="inputOn()" placeholder="Middle Name" maxlength="15"
			class="input1" autocomplete="off" onkeydown="return nonumberspacetext(event)" />
			<input type="text" name="LastName" oninput="inputOn()" placeholder="Last Name" required maxlength="15"
			class="input1" autocomplete="off" onkeydown="return nonumberspacetext(event)" />
			<br />
		</div>

		<label>Father's / Guardian's Name :</label>
		<br>
		<div class="custom">
			<input type="text" name="FatherFirstName" oninput="inputOn()" placeholder="First Name" required
				maxlength="15" class="input1" autocomplete="off" onkeydown="return nonumberspacetext(event)" />
			<input type="text" name="FatherMiddleName" oninput="inputOn()" placeholder="Middle Name" maxlength="15"
				class="input1" autocomplete="off" onkeydown="return nonumberspacetext(event)" />
			<input type="text" name="FatherLastName" oninput="inputOn()" placeholder="Last Name" required
				maxlength="15" class="input1" autocomplete="off" onkeydown="return nonumberspacetext(event)" />
			<br />
		</div>

		<label>Gender :</label>
		<br>
		<div class="custom_radio">
			<input type="Radio" name="gender" oninput="inputOn()" required value="Male" class="input1" /><span>Male</span>
			<input type="Radio" name="gender" oninput="inputOn()" required value="Female" class="input1" /><span>Female</span>
			<input type="Radio" name="gender" oninput="inputOn()" required value="Other" class="input1" /><span>Other</span>
			<br>
		</div>

		<label>Date of Birth :</label>
		<input type="date" name="dob" required class="input1" /><br />

		<label>Address :</label>
		<input type="text" name="address" placeholder="Enter your address" required class="input1"
			autocomplete="off" /><br />

		<label>City :</label>
		<input type="text" name="city" oninput="inputOn()" placeholder="Enter your city" required
			class="input1" autocomplete="off" title="e.g. Pune" onkeydown="return nonumbertext(event)" /><br>

		<label>State :</label>
		<input list="states" name="state" placeholder="Select your state" required class="input1" />
		<datalist id="states">
			<option>Andhra Pradesh</option>
			<option>Arunachal Pradesh</option>
			<option>Assam</option>
			<option>Bihar</option>
			<option>Chattisgarh</option>
			<option>Goa</option>
			<option>Gujarat</option>
			<option>Haryana</option>
			<option>Himachal Pradesh</option>
			<option>Jammu & Kashmir</option>
			<option>Jharkhand</option>
			<option>Karnataka</option>
			<option>Kerala</option>
			<option>Madhya Pradesh</option>
			<option>Maharashtra</option>
			<option>Manipur</option>
			<option>Meghalaya</option>
			<option>Mizoram</option>
			<option>Nagaland</option>
			<option>Odisha</option>
			<option>Punjab</option>
			<option>Rajasthan</option>
			<option>Sikkim</option>
			<option>Tamilnadu</option>
			<option>Telengana</option>
			<option>Tripura</option>
			<option>Uttarakhand</option>
			<option>Uttar Pradesh</option>
			<option>West Bengal</option>
		</datalist>
		<br />

		<label>Pin Code :</label>
		<input type="number" name="pincode" placeholder="Enter your pincode" pattern="[1-9]{1}[0-9]{5}"
			title="e.g. 411001" required class="input1" autocomplete="off"  onkeypress="return event.charCode >= 48" min="0"/><br />

		<label>Nationality :</label>
		<input type="text" name="nationality" placeholder="Enter your nationality" title="e.g. Indian" required
			class="input1" autocomplete="off" onkeydown="return nonumberspacetext(event)" /><br />

		<label>Mobile No :</label>
		<input type="number" name="mobile" oninput="inputOn()" placeholder="Enter your mobile no."
			pattern="[789]{1}[0-9]{9}" title="e.g. 9876543210" required class="input1" autocomplete="off" onkeypress="return event.charCode >= 48" min="0"/><br />
			

		<label>Email ID :</label>
		<input type="text" name="email" oninput="inputOn()" placeholder="Enter your email id"
			pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$" title="e.g. abc@gmail.com" required
			class="input1" autocomplete="off"/><br />

		<label>Aadhaar No. :</label>
		<input type="number" name="aadhaar" placeholder="Enter your aadhaar no." pattern="[0-9]{12}"
			title="e.g. 123456789012" required class="input1" autocomplete="off" onkeypress="return event.charCode >= 48" min="0"/><br />

		<label>Pancard No. :</label>
		<input type="text" name="pancard" placeholder="Enter your pancard no." pattern="[A-Z]{5}[0-9]{4}[A-Z]{1}"
			title="e.g. ABCDE1234F" required class="input1" autocomplete="off" /><br />

		<label>Account Type :</label>
		<input list="accounts" name="accountType" placeholder="Select Account Type" required class="input1" />
		<datalist id="accounts">
			<option>Saving</option>
			<option>Current</option>
		</datalist>
		<br />

		<label>Branch Name :</label>
		<input list="branches" name="branchName" placeholder="Select Branch" required class="input1" />
		<datalist id="branches">
			<option>Bund Garden</option>
			<option>Hadapsar</option>
			<option>JM Road</option>
			<option>Swargate</option>
		</datalist>
		<br />

		<div class="action-btn">
			<input class="btn primary" name="submit" type="submit" value="Register" />
			<input class="btn danger" name="cancel" type="reset" value="Reset" /><br>
        </div>
		
		<div class="login_link">
			Already have an account? <a href="LoginPage.jsp">Click here to Login</a><br>
		</div>
		
	</form>
	</div>
	</div>
</body>

</html>
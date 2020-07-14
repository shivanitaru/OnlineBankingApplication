<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<script src="assets/js/jquery-2.2.0.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body>
  <!--
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
   <script>
    function checkPasswordMatch() {
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        if (password != confirmPassword)
            $("#CheckPasswordMatch").html("Passwords does not match!");
        else
            $("#CheckPasswordMatch").html("Passwords match.");
    }
    $(document).ready(function () {
       $("#confirmPassword").keyup(checkPasswordMatch);
    });
    </script>
    -->
<!-- banner -->
	<section>
		<div class="container text-center">
			
							<div class="card-header  ">
								<h1 class="card-title">
									<span class="text-primary"><b>Change Password</b>
									</span>
								</h1>
							</div>
							<br>

							<form action="ResetPasswordController" method="post">
								<fieldset>
								
									<div class="form-group ">
											<input type="password"
												placeholder="New Password" id="password" name="password"
												class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
									</div>
									
									<div class="form-group">
											<input
												type="password" placeholder="Confirm New Password" 
												id="confirmPassword" name="confirmPassword" class="form-control" required>
									</div>
										<div class="registrationFormAlert" style="color:green;" id="CheckPasswordMatch">
   
											<input class="btn btn-lg btn-success " type="submit" 
												value="Reset Password" onclick="return Validate()" >
											<a href="LoginPage.jsp" class="btn btn-lg btn-danger ">Cancel</a>
								</fieldset>
							</form>
					</div>
				
	</section>
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
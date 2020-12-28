<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		<% String uname=(String) session.getAttribute("uname"); %>
			<marquee>
				<% out.println("Hello " + uname + " , Welcome to Home Page!!!"); %>
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
													<a href="BeneficiaryDetails.jsp" class="list-group-item list-group-item-action bg-light">Beneficiary Details</a>
							
						<a href="BankStatement.jsp" class="list-group-item active-link list-group-item-action">Bank
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
				
									<h1 style="color: black;" class="text-center mb-5 mt-2">Bank
							Statement</h1>
				<%
try{
	
	Class.forName("oracle.jdbc.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","123456789");	
String query="select * from transaction_details";
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
%><table border=1 align=center style="text-align:center">
<thead>
    <tr>
    
           <th>Transaction Id</th>
       <th>Remitter Account Number</th>
       <th>Beneficiary Name</th>
       <th>Beneficiary Account Number</th>
       <th>Amount</th>
       <th>Date Of Transaction</th>
    </tr>
</thead>
<tbody>
<%while(rs.next()){
	%>
	 <tr>
	 <td> <%=rs.getInt("TRANSACTION_ID")%></td>
	 <td><%=rs.getString("ACC_NO")%></td>
    <td><%=rs.getString("BENF_NAME")%></td>
    <td><%=rs.getString("BENF_ACCNO")%></td>
    <td><%=rs.getLong("Amount")%></td>
    <td><%=rs.getString("DATE_OF_TRANSACTION")%></td>
    </tr>
        <%
        } %>
        </tbody>
     </table><br>
      <%}
    catch(Exception e){
        out.print(e.getMessage());%><br><%
    }
    
 %>

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
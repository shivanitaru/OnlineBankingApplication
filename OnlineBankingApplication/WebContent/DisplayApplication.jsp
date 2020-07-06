<%@page import="com.Model.RegisterModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<script language="javascript" type="text/javascript">
		
	</script>
	
<body leftmargin="0" align="center">

	<h1 align="center">
		<b><i class="fa fa-retweet"></i>JM ROAD BANK</b>
	</h1>
	<br>

	<h2 align="center">
		<b>APPLICANT DETAILS</b>
	</h2>

	<table cellpadding="5" border="1" align="center" >
		<tr>
			<th>Applicant Name</th>
			<th>Applicant Father Name</th>
			<th>Gender</th>
			<th>Date Of Birth</th>
			<th>Address</th>
			<th>State</th>
			<th>City</th>
			<th>Pin Code</th>
			<th>Nationality</th>
			<th>MobileNumber</th>
			<th>Aadhar card</th>
			<th>Pan Card</th>
			<th>Email Id</th>
			<th>Account Type</th>
			<th>Branch Name</th>
			<th>Status</th>
			<th>Approve</th>
			<th>Reject</th>
		</tr>
	<%!List<RegisterModel> list;
	String emailId;%>
	<%
		if (!session.isNew()) {

			list = (List<RegisterModel>) session.getAttribute("ApplicantDetails");
			for (RegisterModel applicantdetails : list) {
	%>
		<tr>
			<td><%=applicantdetails.getCustomerName()%></td>
			<td><%=applicantdetails.getCustomerFathersName()%></td>
			<td><%=applicantdetails.getGender()%></td>
			<td><%=applicantdetails.getDateOfBirth()%></td>
			<td><%=applicantdetails.getAddress()%></td>
			<td><%=applicantdetails.getState()%></td>
			<td><%=applicantdetails.getCity()%></td>
			<td><%=applicantdetails.getPinCode()%></td>
			<td><%=applicantdetails.getNationality()%></td>
			<td><%=applicantdetails.getMobileNumber()%></td>
			<td><%=applicantdetails.getAadharNumber()%></td>
			<td><%=applicantdetails.getPanCardNumber()%></td>
			<td><%=applicantdetails.getEmailId()%></td>
			<td><%=applicantdetails.getAccountType()%></td>
			<td><%=applicantdetails.getBranchName()%></td>
			<td><%=applicantdetails.getStatus() %></td>			
			<%emailId=applicantdetails.getEmailId(); %>
			<td>
				<button type="button" value="Approve" onclick="accountApproved('<%=emailId%>')">Approve</button>
			</td>
			<td>
				<input type="button" onClick="donotSubmit();" value="Reject" align="middle" height="30" width="100" />
			</td>
		</tr>
	<%
		}
	%>

	
	<%
		}
	%>
	</table>
	<script>
function myFunction(name) {
  alert("hello"+name);
}
function accountApproved(emailId) {
	window.location.assign("/OnlineBankingApplication/SendEmailServlet?emailId="+emailId);
}
function donotSubmit() {
	window.open("Sendemail.jsp", "_self");
}
</script>
	</body>

	

	</html>

<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
</head>

<body>
	<div id="RegisterMessage">
		<center>

			<h1 class="text-center my-5">Your transaction is Successful.</h1>
			<%
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System",
							"123456789");
					Statement stmt = conn.createStatement();
					String query = "select MAX(TRANSACTION_ID) from TransactionDetails";
					ResultSet rs1 = stmt.executeQuery(query);
					long transactionId = 0;
					//System.out.println("jsp"+transactionId+rs1.next());
					while (rs1.next()) {
						transactionId = rs1.getLong(1);
						System.out.println("jsp" + transactionId);
					}
					query = "select * from TransactionDetails where TRANSACTION_ID=" + transactionId;
					ResultSet rs2 = stmt.executeQuery(query);
			%>
			<table border=5 align=center style="text-align: center">
				<%
					while (rs2.next()) {
				%>
				<tr>
					<th>Transaction Id</th>
					<td><%=rs2.getLong("TRANSACTION_ID")%></td>
				</tr>
				<tr>
					<th>Remitter Account No</th>
					<td><%=rs2.getLong("REMITTER_ACCOUNT_NO")%></td>
				</tr>
				<tr>
					<th>Beneficiary Account No</th>
					<td><%=rs2.getLong("BENEFICIARY_ACCOUNT_NO")%></td>
				</tr>
				<tr>
					<th>Beneficiary Name</th>
					<td><%=rs2.getString("BENEFICIARY_NAME")%></td>
				</tr>
				<tr>
					<th>IFSC Code</th>
					<td><%=rs2.getString("IFSC_CODE")%></td>
				</tr>
				<tr>
					<th>Amount</th>
					<td>Rs <%=rs2.getLong("AMOUNT")%></td>
				</tr>
				<tr>
					<th>Date Of Transaction</th>
					<td><%=rs2.getDate("DATE_OF_TRANSACTION")%></td>
				</tr>
				<tr>
					<th>Status</th>
					<th style="color: red;"><%=rs2.getString("STATUS")%></th>
				</tr>
				<%
					}
				%>
			</table>
			<br>
			<%
				} catch (Exception e) {
					out.print(e.getMessage());
			%><br>
			<%
				}
			%>


			<form action="HomePage.jsp">
				<button type="submit" class="btn btn-primary">OK</button>
			</form>
		</center>
	</div>
</body>

</html>
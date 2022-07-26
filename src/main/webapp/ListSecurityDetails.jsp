<%@page import="com.bean.SecurityBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">

	
<meta charset="ISO-8859-1">
<title>List Security Details</title>
</head>
<body>
<jsp:include page="AdminNavbar.jsp"></jsp:include>
	<%
	ArrayList<SecurityBean> securityDetails = (ArrayList<SecurityBean>) request.getAttribute("securityDetails");
	%>


	<div class="container-fluide" ">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<table class="display" id="users">
					<thead class="thead-dark">
						<tr>
							<th scope="col">SEcurity Id</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Contact Number</th>
							<th scope="col">IsActive</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (SecurityBean securityDetail : securityDetails) {
						%>
						<tr>
							<td><%=securityDetail.getSecurityId() %>
							<td><%=securityDetail.getFirstName()%></td>
							<td><%=securityDetail.getLastName()%></td>
							<td><%=securityDetail.getContactNumber()%></td>
							<td><%=securityDetail.getIsActive()%></td>
							
							<td><a
								href="DeleteController?securityid=<%=securityDetail.getSecurityId()%>">Delete</a></td>
							<%
							}
							%>
						</tr>
					</tbody>

				</table>
				<br>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>

</body>
</html>
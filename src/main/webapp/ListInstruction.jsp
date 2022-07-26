<%@page import="com.bean.InstructionBean"%>
<%@page import="com.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.HouseBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Instruction</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
<body>
	<jsp:include page="SecurityNavbar.jsp"></jsp:include>
	<%
	ArrayList<InstructionBean> instructions = (ArrayList<InstructionBean>) request.getAttribute("instructions");
	%>
	<div class="container-fluid" style="margin-top: 7%;">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<table class="display" id="users">
					<thead class="thead-dark">
						<tr>
							<th scope="col">First Name</th>
							<th scope="col">Type</th>
							<th scope="col">Time</th>
							<th scope="col">Allow</th>
							<th scope="col">UserId</th>
							<!-- <th scope="col">Action</th> -->
						</tr>
					</thead>
					<tbody>
						<%
						for (InstructionBean instruction : instructions) {
						%>
						<tr>
							<td><%=instruction.getFirstName()%></td>
							<td><%=instruction.getType()%></td>
							<td><%=instruction.getTime()%></td>
							<td><%=instruction.getAllow()%></td>
							<td><%=instruction.getUserid()%></td>
							<%-- <td><a
								href="DeleteController?userid=<%=instruction.getInstructionid()%>">Delete</a></td>
 --%>
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
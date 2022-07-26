<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add House details</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
.error {
	color: red;
}

body {
	background-color: #eee;
}

*[role="form"] {
	max-width: 530px;
	padding: 15px;
	margin: 0 auto;
	background-color: #fff;
	border-radius: 0.3em;
}

*[role="form"] h2 {
	margin-left: 5em;
	margin-bottom: 1em;
}
</style>


</head>
<body>
	<%
	String genderError = (String) request.getAttribute("genderError");
	String genderValue = (String) request.getAttribute("genderValue");
	%>

	<div class="container" style="margin-top: 10%;">
		<form class="form-horizontal" role="form" action="AddHouseDetailsController"
			method="post">
			<h2>Add House Details </h2>
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">Flate Name</label>
				<div class="col-sm-9">
					<input type="text" id="houseNo" placeholder="Flate Name"
						class="form-control" name="flatename" autofocus
						value="${flateNameValue}"> <span class="help-block">
						${flateNameError}</span>
				</div>
			</div>
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">House Number</label>
				<div class="col-sm-9">
					<input type="text" id="houseNumber" placeholder="HouseNumber"
						class="form-control" name="housenumber" autofocus
						value="${lastNameValue}"> <span class="help-block">${houseNumberError}</span>
				</div>
			</div>
			
			
			
					
			<div class="form-group">
				<div class="col-sm-7 col-sm-offset-3">
					<button type="submit" value="addhouseDetail"
						class="btn btn-primary btn-block">Add House Details</button>
				</div>
			</div>

			

		</form>
	</div>
</body>
</html>
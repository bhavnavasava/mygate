<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Sleek Dashboard - Free Bootstrap 4 Admin Dashboard Template and UI Kit. It is very powerful bootstrap admin dashboard, which allows you to build products like admin panels, content management systems and CRMs etc.">
  
    <title>Form Validation - Sleek Admin Dashboard Template</title>
    
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500|Poppins:400,500,600,700|Roboto:400,500" rel="stylesheet">

    <link href="https://cdn.materialdesignicons.com/4.4.95/css/materialdesignicons.min.css" rel="stylesheet">
  
    <!-- PLUGINS CSS STYLE -->
    <link href="assets/plugins/simplebar/simplebar.css" rel="stylesheet">
    <link href="assets/plugins/nprogress/nprogress.css" rel="stylesheet">
  
    <!-- No Extra plugin used -->
    
    
    
    
    
    
    
    
    
    
    

    <!-- SLEEK CSS -->
    <link id="sleek-css" rel="stylesheet" href="assets/css/sleek.css">
  
    <!-- FAVICON -->
    <link href="assets/img/favicon.png" rel="shortcut icon">
  
    <!--
      HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries
    -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="assets/plugins/nprogress/nprogress.js"></script>
  </head>
<body>
<div class="col-lg-6">
		<div class="card card-default">
			<div class="card-header card-header-border-bottom">
				<h2>Highlighted Input Field</h2>
			</div>

			<div class="card-body">
				<form>
					<div class="form-row">
						<div class="col-md-12 mb-3">
							<label for="validationServer01">First name</label>

							<input type="text" class="form-control is-valid" id="validationServer01" placeholder="First name" value="Md" required="">

							<div class="valid-feedback">
								Looks good!
							</div>
						</div>

						<div class="col-md-12 mb-3">
							<label for="validationServer02">Last name</label>

							<input type="text" class="form-control is-valid" id="validationServer02" placeholder="Last name" value="Rahad" required="">

							<div class="valid-feedback">
								Looks good!
							</div>
						</div>

						<div class="col-md-12 mb-3">
							<label for="validationServerUsername">Username</label>

							<input type="text" class="form-control is-invalid" id="validationServerUsername" placeholder="Username" aria-describedby="inputGroupPrepend3" required="">

							<div class="invalid-feedback">
								Please choose a username.
							</div>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-6 mb-3">
							<label for="validationServer03">City</label>

							<input type="text" class="form-control is-invalid" id="validationServer03" placeholder="City" required="">

							<div class="invalid-feedback">
								Please provide a valid city.
							</div>
						</div>

						<div class="col-md-3 mb-3">
							<label for="validationServer04">State</label>

							<input type="text" class="form-control is-invalid" id="validationServer04" placeholder="State" required="">

							<div class="invalid-feedback">
								Please provide a valid state.
							</div>
						</div>

						<div class="col-md-3 mb-3">
							<label for="validationServer05">Zip</label>

							<input type="text" class="form-control is-invalid" id="validationServer05" placeholder="Zip" required="">

							<div class="invalid-feedback">
								Please provide a valid zip.
							</div>
						</div>
					</div>

					<button class="btn btn-primary" type="submit">Submit form</button>
				</form>
			</div>
		</div>
	</div>
	<script src="assets/plugins/jquery/jquery.min.js"></script>  <script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script><script src="assets/plugins/simplebar/simplebar.min.js"></script><script src="assets/js/sleek.js"></script>
<script src="assets/options/optionswitcher.js"></script><link href="assets/options/optionswitch.css" rel="stylesheet">
</body>
</html>
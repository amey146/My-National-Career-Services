<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>My NCS</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">

<!-- Page Specific -->


</script>
</head>

<body>
	<div class="container-xxl bg-white p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem;" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->


		<!-- Navbar Start -->
		<nav
			class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
			<a href="index.jsp"
				class="navbar-brand d-flex align-items-center text-center py-0 px-4 px-lg-5">
				<h3 class="m-0 text-primary">
					<img src="img/logoNCS.webp" class="rounded float-start img-fluid"
						style="height: 24px;" alt="">&nbsp;&nbsp; <span
						class="sp-nav">My National Career Services</span>
				</h3>
			</a>
			<button type="button" class="navbar-toggler me-4"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<div class="navbar-nav ms-auto p-4 p-lg-0">
					<a href="index.jsp" class="nav-item nav-link active">Home</a> <a
						href="about.jsp" class="nav-item nav-link">About</a>
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown">Jobs</a>
						<div class="dropdown-menu rounded-0 m-0">
							<a href="job-list.jsp" class="dropdown-item">Job List</a> <a
								href="job-detail.jsp" class="dropdown-item">Job Detail</a>
						</div>
					</div>
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown">Pages</a>
						<div class="dropdown-menu rounded-0 m-0">
							<a href="category.jsp" class="dropdown-item">Job Category</a> <a
								href="testimonial.jsp" class="dropdown-item">Testimonial</a> <a
								href="404.jsp" class="dropdown-item">404</a>
						</div>
					</div>
					<a href="contact.jsp" class="nav-item nav-link">Contact</a>
				</div>
				<a href="job-search.jsp"
					class="btn btn-primary rounded-0 py-4 px-lg-5 d-none d-lg-block">Post
					A Job<i class="fa fa-arrow-right ms-3"></i>
				</a>
			</div>
		</nav>
		<!-- Navbar End -->
		<!-- Header End -->

		<!-- Form Starts -->
		<div class="container mt-5">
			<div class="row justify-content-center">
				<div class="col-md-6">
					<div class="card">
						<div class="card-header">Register</div>
						<div class="card-body">
							<form action="Register" method="post">
								<div class="col-sm-10">
									<label class="form-check-label" for=role>Register as</label>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="role"
											id="emp" value="1"> <label class="form-check-label"
											for="Employer">Employer</label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="role"
											id="job" value="2"> <label class="form-check-label"
											for="Jobseeker">Jobseeker</label>
									</div>
								</div>
								<br>
								<div class="form-group">
									<label for="name">Full Name:</label> <input type="text"
										class="form-control" name="name"
										placeholder="Fisrt Middle Last">
								</div>
								<br>
								<div class="form-group">
									<label for="age">Age (years):</label> <input type="number"
										class="form-control" id="age" min="18" max="80"
										placeholder="18 - 80" name="age">
								</div>
								<br>
								<div class="form-group">
									<label for="gender">Select Gender:</label> <select
										class="form-select" aria-label="Default select example"
										name="gender">
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>
								</div>
								<br>
								<div class="form-group">
									<label for="state">Select State:</label> <select
										class="form-select" aria-label="Default select example"
										name="state">
										<option value="AndhraPradesh">Andhra Pradesh</option>
										<option value="ArunachalPradesh">Arunachal Pradesh</option>
										<option value="Assam">Assam</option>
										<option value="Bihar">Bihar</option>
										<option value="Chhattisgarh">Chhattisgarh</option>
										<option value="Goa">Goa</option>
										<option value="Gujarat">Gujarat</option>
										<option value="Haryana">Haryana</option>
										<option value="HimachalPradesh">Himachal Pradesh</option>
										<option value="Jharkhand">Jharkhand</option>
										<option value="Karnataka">Karnataka</option>
										<option value="Kerala">Kerala</option>
										<option value="MadhyaPradesh">Madhya Pradesh</option>
										<option value="Maharashtra">Maharashtra</option>
										<option value="Manipur">Manipur</option>
										<option value="Meghalaya">Meghalaya</option>
										<option value="Mizoram">Mizoram</option>
										<option value="Nagaland">Nagaland</option>
										<option value="Odisha">Odisha</option>
										<option value="Punjab">Punjab</option>
										<option value="Rajasthan">Rajasthan</option>
										<option value="Sikkim">Sikkim</option>
										<option value="TamilNadu">Tamil Nadu</option>
										<option value="Telangana">Telangana</option>
										<option value="Tripura">Tripura</option>
										<option value="UttarPradesh">Uttar Pradesh</option>
										<option value="Uttarakhand">Uttarakhand</option>
										<option value="WestBengal">West Bengal</option>
										<option value="AndamanNicobar">Andaman and Nicobar
											Islands</option>
										<option value="Chandigarh">Chandigarh</option>
										<option value="DadraNagarHaveli">Dadra and Nagar
											Haveli</option>
										<option value="DamanDiu">Daman and Diu</option>
										<option value="Delhi">Delhi</option>
										<option value="Lakshadweep">Lakshadweep</option>
										<option value="Puducherry">Puducherry</option>
									</select>
								</div>
								<br>
								<div class="form-group">
									<label for="district">District:</label> <input type="text"
										class="form-control" id="district"
										placeholder="Enter your district" name="district">
								</div>
								<br>
								<div class="form-group">
									<label for="district">City:</label> <input type="text"
										class="form-control" id="city" placeholder="Enter your city"
										name="city">
								</div>
								<br>
								<div class="form-group">
									<label for="pincode">Pin Code:</label> <input type="number"
										class="form-control" id="pincode" name="pincode"
										placeholder="Enter your pincode" pattern="[1-9][0-9]{5}">
								</div>
								<br>
								<div class="form-group">
									<label for="username">Aadhar UID:</label> <input type="text"
										class="form-control" id="username"
										placeholder="Enter your username" name="aadhar">
								</div>
								<br>
								<div class="form-group">
									<label for="password">Create Password:</label> <input
										type="password" class="form-control" id="password"
										placeholder="Enter your password" name="password"> <small
										id="passwordHelp" class="form-text text-muted"> Create
										a strong password with a minimum of 8 characters. </small>
								</div>
								<div class="form-group">
									<label for="password">Confirm Password:</label> <input
										type="password" class="form-control" id="password2"
										placeholder="Enter your password">
								</div>
								<div class="d-grid gap-2 d-md-flex justify-content-md-end py-2">
									<a href="login.jsp" class="btn btn-outline-warning btn-lg"
										role="button">Old User? Login</a>
									<button type="submit" class="btn btn-primary btn-lg">Register</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Form Ends -->


		<!-- Footer Start -->
		<div
			class="container-fluid bg-dark text-white-50 footer pt-5 mt-5 wow fadeIn"
			data-wow-delay="0.1s">
			<div class="container py-5">
				<div class="row g-5">
					<div class="col-lg-3 col-md-6">
						<h5 class="text-white mb-4">Company</h5>
						<a class="btn btn-link text-white-50" href="">About Us</a> <a
							class="btn btn-link text-white-50" href="">Contact Us</a> <a
							class="btn btn-link text-white-50" href="">Our Services</a> <a
							class="btn btn-link text-white-50" href="">Privacy Policy</a> <a
							class="btn btn-link text-white-50" href="">Terms & Condition</a>
					</div>
					<div class="col-lg-3 col-md-6">
						<h5 class="text-white mb-4">Quick Links</h5>
						<a class="btn btn-link text-white-50" href="">About Us</a> <a
							class="btn btn-link text-white-50" href="">Contact Us</a> <a
							class="btn btn-link text-white-50" href="">Our Services</a> <a
							class="btn btn-link text-white-50" href="">Privacy Policy</a> <a
							class="btn btn-link text-white-50" href="">Terms & Condition</a>
					</div>
					<div class="col-lg-3 col-md-6">
						<h5 class="text-white mb-4">Contact</h5>
						<p class="mb-2">
							<i class="fa fa-map-marker-alt me-3"></i>123 Street, New York,
							USA
						</p>
						<p class="mb-2">
							<i class="fa fa-phone-alt me-3"></i>+012 345 67890
						</p>
						<p class="mb-2">
							<i class="fa fa-envelope me-3"></i>info@example.com
						</p>
						<div class="d-flex pt-2">
							<a class="btn btn-outline-light btn-social" href=""><i
								class="fab fa-twitter"></i></a> <a
								class="btn btn-outline-light btn-social" href=""><i
								class="fab fa-facebook-f"></i></a> <a
								class="btn btn-outline-light btn-social" href=""><i
								class="fab fa-youtube"></i></a> <a
								class="btn btn-outline-light btn-social" href=""><i
								class="fab fa-linkedin-in"></i></a>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<h5 class="text-white mb-4">Newsletter</h5>
						<p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
						<div class="position-relative mx-auto" style="max-width: 400px;">
							<input class="form-control"
								class="form-control bg-transparent w-100 py-3 ps-4 pe-5"
								type="text" placeholder="Your email">
							<button type="button"
								class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="copyright">
					<div class="row">
						<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
							&copy; <a class="border-bottom" href="#">Your Site Name</a>, All
							Right Reserved.

							<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
							Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML
								Codex</a>
						</div>
						<div class="col-md-6 text-center text-md-end">
							<div class="footer-menu">
								<a href="">Home</a> <a href="">Cookies</a> <a href="">Help</a> <a
									href="">FQAs</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer End -->


		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
			class="bi bi-arrow-up"></i></a>
	</div>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/wow/wow.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>

</html>
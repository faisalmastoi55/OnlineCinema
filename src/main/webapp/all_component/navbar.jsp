<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<div class="container-fluid"
	style="height: 10px; background-color: #01579b"></div>

<div class="container-fluid p-3" style="background: white;">
	<div class="row">
		<div class="col-md-9">
			<h2 class="text-success fw-bold">
				<i class="fa-solid fa-film"></i> Online Cinema
			</h2>
		</div>

		<c:if test="${not empty userObj }">
			<div class="col-md-3" id="btnLR">

			<!-- 	<a href="checkout.jsp" class="p-1"><i class="fas fa-cart-plus fa-2x"></i></a> -->

				<a href="#" class="btn btn-primary"><i
					class="fa-solid fa-user"></i> ${userObj.name }</a> <a
					href="logoutUser" class="btn btn-success" data-bs-toggle="modal"
					data-bs-target="#exampleModal"><i
					class="fa-solid fa-right-to-bracket"></i> Logout</a>
			</div>
		</c:if>
		<c:if test="${empty userObj }">
			<div class="col-md-3" id="btnLR">
				<a href="login.jsp" class="btn btn-primary"><i
					class="fa-solid fa-user-plus"></i> Login</a> <a href="register.jsp"
					class="btn btn-success"><i class="fa-solid fa-right-to-bracket"></i>
					Register</a>
			</div>
		</c:if>

	</div>
</div>


<!-- Logout Model -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body text-center py-5">
				<h2 class="mb-3 fw-bold" style="color: #545454;">Do you want logout</h2>
				<button type="button" class="btn btn-dark text-white"
					data-bs-dismiss="modal">Close</button>
				<a href="logoutUser" class="btn btn-dark text-white">Logout</a>

			</div>
		</div>
	</div>
</div>


<!-- End Logout Model -->


<!-- Start User Login Home Page  -->

<c:if test="${not empty userObj }" > 

	<nav class="navbar navbar-expand-lg navbar-dark bg-navbar-color rounded">
		<div class="container-fluid">
			<a class="navbar-brand" href="userHome.jsp"><i
				class="fa-solid fa-house"></i></a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="userBookMovie.jsp">Book Movie</a></li>
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="userBookingShow.jsp">View Bookings</a></li>
				</ul>
				<form class="d-flex">
					<a href="#" class="btn btn-light me-2">
						<i class="fa-solid fa-address-card"></i> About Us
					</a>
					<a class="btn btn-light" href="#">
						<i	class="fa-solid fa-user"></i> Contact
					</a>
				</form>
			</div>
		</div>
	</nav>

</c:if>

<!-- End User Login Home Page  -->


<!-- Start Index Page  -->

<c:if test="${empty userObj }" > 

	<nav class="navbar navbar-expand-lg navbar-dark bg-navbar-color rounded">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fa-solid fa-house"></i></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Home</a></li>
			</ul>
			<form class="d-flex">
				<a href="#" class="btn btn-light me-2">
					<i class="fa-solid fa-address-card"></i> About Us
				</a>
				<a class="btn btn-light" href="#">
					<i	class="fa-solid fa-user"></i> Contact
				</a>
			</form>
		</div>
	</div>
</nav>

</c:if>

<!-- End User Index Page  -->





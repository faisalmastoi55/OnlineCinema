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
		<div class="col-md-3">

			<c:if test="${not empty userObj }">
				<a class="btn btn-success text-white"> <i
					class="fa-solid fa-user"></i> ${userObj.name }
				</a>
				<a href="../logout" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#exampleModal"><i
					class="fa-solid fa-sign-in-alt"></i> Logout</a>
			</c:if>

			<c:if test="${empty userObj }">
				<a href="#" class="btn btn-primary"> <i
					class="fa-solid fa-user-plus"></i> Login
				</a>

				<a href="#" class="btn btn-success"><i
					class="fa-solid fa-right-to-bracket"></i> Register</a>
			</c:if>

		</div>
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
				<a href="../logout" class="btn btn-dark text-white">Logout</a>

			</div>
		</div>
	</div>
</div>


<!-- End Logout Model -->



<nav class="navbar navbar-expand-lg navbar-dark bg-navbar-color ">
	<div class="container-fluid">
		<a class="navbar-brand" href="adminHome.jsp"><i
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
					aria-current="page" href="addMovie.jsp">Add Movie</a></li>
					<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="showMovies.jsp">Show Movie</a></li>
					<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="bookMovie.jsp">Book Movie</a></li>
					<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="showBookings.jsp">View Bookings</a></li>
			</ul>
		</div>
	</div>
</nav>
<%@page import="com.cinema.entities.User"%>
<%@page import="com.cinema.entities.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.cinema.helper.ConnectionProvider"%>
<%@page import="com.cinema.dao.impl.MovieServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<%@include file="allCss.jsp" %>

<style type="text/css">

.bg {
	background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)), url("../img/background.jpg");
	background-size: cover;
	background-attachment: fixed;
	height: 82.5vh;
	
}

.crd:hover {
	background-color: #fcf7f7;
}

#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}

@
keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}

</style>

</head>
<body class="bg">

	<%@include file="navbar.jsp" %>
	
	<%
	User u = (User) session.getAttribute("userObj");
	%>

	<div class="">
		<div class="conatiner">
		<div class="row p-3 m-0">
			<%
			MovieServiceImpl dao = new MovieServiceImpl(ConnectionProvider.getConnection());
			List<Movie> list = dao.getAllMovies();

			for (Movie m : list) {
			%>

			<div class="col-md-3" id="cards">
				<div class="card crd mt-3">
					<div class="card-body text-center">
						<img alt="" src="../img/<%= m.getPhoto() %>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%= m.getTitle() %></p>
						<p>Tickets : <%= m.getTickets() %></p>
						<p>
							Release :
							<%= m.getRelease_date() %></p>
						<div>

							<%
							if (u == null) {
							%>
							<a href="../login.jsp" class="btn btn-danger"><i
								class="fa-sharp fa-solid fa-cart-plus"></i>Booking</a>

							<%
							} else {
							%>

							<a href="bookMovie.jsp"
								class="btn btn-danger"><i
								class="fa-sharp fa-solid fa-cart-plus"></i>Booking</a>


							<%
							}
							%>


							<a href="showMovieDetails.jsp?id=<%= m.getMovie_id() %>"
								class="btn btn-success">View</a> <a href="#"
								class="btn btn-warning"><i class="fa-solid fa-bookmark"></i> </a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			%>
		</div>
	</div>		
	</div>

</body>
</html>
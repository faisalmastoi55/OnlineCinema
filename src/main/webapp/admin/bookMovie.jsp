<%@page import="java.util.List"%>
<%@page import="com.cinema.entities.Movie"%>
<%@page import="com.cinema.helper.ConnectionProvider"%>
<%@page import="com.cinema.dao.impl.MovieServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Movie</title>
<%@include file="allCss.jsp" %>

<style type="text/css">

.bg {
	background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)), url("../img/background.jpg");
	background-size: cover;
	background-attachment: fixed;
	height: 80vh;
	width: 100%;
}

</style>


</head>
<body>

	<%@include file="navbar.jsp" %>
	
	<div class="bg d-flex justify-content-center">
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card mt-5">
						<div class="card-body">
							<h2 class="text-center mb-4">Book Movie</h2>
						    <c:if test="${not empty succMsg}">
						        <h5 class="text-center text-success">${succMsg}</h5>
						        <c:remove var="succMsg" scope="session" />
						    </c:if>
						    <c:if test="${not empty failMsg}">
						        <h5 class="text-center text-danger">${failMsg}</h5>
						        <c:remove var="failMsg" scope="session" />
						    </c:if>
						    <form action="../bookMovie" method="post">
						        <div class="mb-3">
						            <label for="movie_id" class="form-label">Select Movie</label>
						            <select class="form-select" name="movie_id" id="movie_id" required>
						                <option value="">Choose...</option>
						                <% 
						                    MovieServiceImpl dao = new MovieServiceImpl(ConnectionProvider.getConnection());
						                    List<Movie> movies = dao.getAllMovies();
						                    for (Movie m : movies) {
						                %>
						                <option value="<%= m.getMovie_id() %>"><%= m.getTitle() %></option>
						                <% } %>
						            </select>
						        </div>
						        <div class="mb-3">
						            <label for="tickets" class="form-label">Number of Tickets</label>
						            <input type="number" class="form-control" name="tickets" id="tickets" required>
						        </div>
						        <button type="submit" class="btn btn-primary">Book</button>
						    </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>

<%@page import="com.cinema.entities.User"%>
<%@page import="com.cinema.entities.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.cinema.helper.ConnectionProvider"%>
<%@page import="com.cinema.dao.impl.MovieServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Movie</title>

<style>
    .clickable-row {
        cursor: pointer;
    }
</style>

<%@include file="allCss.jsp" %>

</head>
<body>

	<%@include file="navbar.jsp" %>

	<c:if test="${not empty succMsg}">
		<h5 class="text-center text-success">${succMsg}</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failMsg}">
		<h5 class="text-center text-danger">${failMsg}</h5>
		<c:remove var="failMsg" scope="session" />
	</c:if>
	
	<div class="container">
		<div class="row">
			<h5 class="py-3 fw-bold text-center">SHOW MOVIES</h5>
			<table class="table table-striped">
			  <thead>
			    <tr class="text-center">
			      <th scope="col">ID</th>
			      <th scope="col">Title</th>
			      <th scope="col">Release Date</th>
			      <th scope="col">Tickets</th>
			      <th scope="col">Status</th>
			      <th scope="col">Photo</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			      <%
			      	HttpSession s = request.getSession();
			      	User user = (User) s.getAttribute("userObj");
			      	
			      	if(user != null && "ADMIN".equals(user.getRole())) {
			      
			      	MovieServiceImpl dao = new MovieServiceImpl(ConnectionProvider.getConnection());
			      	List<Movie> list = dao.getMovieByAdminId(user.getId());
			      	
			      	for(Movie m : list) {
			      	
			      %>
			      
			    <tr class="text-center clickable-row" data-href="showMovieDetails.jsp?id=<%= m.getMovie_id() %>">
			    
			      <th> <%= m.getMovie_id() %> </th>
			      <td> <%= m.getTitle() %> </a> </td>
			      <td><%= m.getRelease_date() %></td>
			      <td><%= m.getTickets() %></td>
			      <td><%= m.getStatuss() %></td>
			      <td><img alt="" src="../img/<%= m.getPhoto() %>"
					style="width: 50px; height: 50px;"></td>
			      <td><a href="edit_movie.jsp?id=<%= m.getMovie_id() %>"
					class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i> Edit</a> 
					<a href="../delete_movie?id=<%= m.getMovie_id() %>"
					class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i> Delete</a>
					
                        <a href="showMovieDetails.jsp?id=<%= m.getMovie_id() %>" class="btn btn-sm btn-info"><i class="fa-solid fa-eye"></i> View</a></td>
			      
			      <%
			      	}
			      	}
			      %>
			      
			    </tr>
			  </tbody>
			</table>
		</div>
	</div>

</body>
</html>
<%@page import="com.cinema.entities.Movie"%>
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
<title>User Show Movie</title>

<%@include file="all_component/allCss.jsp" %>

</head>
<body>

	<%@include file="all_component/navbar.jsp" %>
	
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		MovieServiceImpl dao = new MovieServiceImpl(ConnectionProvider.getConnection());
		Movie m = dao.getMovieById(id);
	%>
	
	<div class="vh-110 " style="background-color: #9A616D;">
		<div class="container py-5 h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-xl-10">
					<div class="card" style="border-radius: 1rem;">
						<div class="row g-0">
							<div class="col-md-6 col-lg-5 d-none d-md-block">
								<img src="img/<%= m.getPhoto() %>" alt="login form" class="img-fluid"
									style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 ">
								<div class="card-body p-4 p-lg-5 text-black">

									<form>

										<div class="d-flex align-items-center pb-1">
											<i class="fas fa-cubes fa-2x me-2" style="color: #ff6219;"></i>
											<span class="h3 fw-bold mb-0 me-2"><%= m.getTitle() %></span>
											<span class="h3 fw-bold mb-0"></span>
										</div>

										<h5 class="fw-normal  pb-3"
											style="letter-spacing: 1px;"><%= m.getRelease_date() %></h5>

										<div class="table-responsive">
											<table class="table table-hover table-sm">
												<thead>
													<tr>
														<th scope="col">#ID</th>
														<th scope="col"><span><%= m.getMovie_id() %></span></th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<th scope="row">Publish Date</th>
														<td><span><%= m.getAdd_date() %></span></td>
													</tr>
													<tr>
														<th scope="row">Tickets</th>
														<td><span><%= m.getTickets() %></span></td>
													</tr>
													<tr>
														<th scope="row">Status</th>
														<td><span><%= m.getStatuss() %></span></td>
													</tr>
												</tbody>
											</table>
											<div class="description text-dark">
												<span class="h4 fw-bold mb-0 me-2">Description :-</span>
												<th:block><%= m.getDescriptio() %></th:block>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
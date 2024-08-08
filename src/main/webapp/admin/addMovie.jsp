<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Movie Page</title>
<%@include file="allCss.jsp" %>

<style type="text/css">

.bg {
	background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)), url("../img/background.jpg");
	background-size: cover;
	background-attachment: fixed;
	height: 120vh;
	width: 100%;
}

</style>

</head>
<body>

	<%@include file="navbar.jsp" %>
	
	<div class="bg d-flex justify-content-center align-items-center">
		<!-- start Add Movie form -->

	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h2 class="text-center">Add Movies</h2>

						<c:if test="${not empty succMsg}">
							<div class="d-flex justify-content-center gap-2">
								<p class="text-center text-success">${succMsg}</p>
							</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<c:if test="${not empty failedMsg}">
							<p class="text-center text-danger">${failedMsg}</p>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<form action="../addMovie" method="post" enctype="multipart/form-data">
							<div class="mb-3">
								<label for="exampleInputName1" class="form-label">Title*</label>
								<input type="text" class="form-control" id="exampleInputName1"
									required="required" name="title">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Release Date*</label> 
								<input type="text" class="form-control" id="datepicker" name="release_date" required="required">
							</div>
							<div class="form-floating mb-3">
							  <textarea class="form-control" placeholder="Leave a comment here" name="descriptio" required="required" id="floatingTextarea2" style="height: 100px"></textarea>
							  <label for="floatingTextarea2">Description</label>
							</div>
							<div class="mb-3">
							    <label for="inputState" class="form-label">Tickets</label>
							    <select id="inputState" class="form-select" name="tickets">
							      <option name="tickets" value="10">10</option>
							      <option name="tickets" value="20">20</option>
							      <option name="tickets" value="30">30</option>
							      <option name="tickets" value="40">40</option>
							      <option name="tickets" value="50">50</option>
							      <option name="tickets" value="60">60</option>
							      <option name="tickets" value="70">70</option>
							      <option name="tickets" value="80">80</option>
							      <option name="tickets" value="90">90</option>
							      <option name="tickets" value="100">100</option>
							    </select>
							  </div>
							  <div class="mb-3">
							    <label for="inputState" class="form-label">Status</label>
							    <select id="inputState" class="form-select" >
							      <option name="statuss" value="1">Active</option>
							      <option name="statuss" value="0">Inactive</option>
							    </select>
							  </div>
							  <div class="mb-3">
								<label class="form-label">Upload Photo</label> <input
									class="form-control" type="file" name="photo" required="required">
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- end Add Movie form -->
	</div>

	<script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap5',
            minDate: new Date()
        });
    </script>

</body>
</html>
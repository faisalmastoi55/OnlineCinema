<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<%@include file="all_component/allCss.jsp" %>

<style type="text/css">

.bg {
	background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)), url("./img/background.jpg");
	background-size: cover;
	background-attachment: fixed;
	height: 82.5vh;
	width: 100%;
	color: white;
}

</style>

</head>
<body>

	<%@include file="all_component/navbar.jsp" %>
	
	
	<div class="bg d-flex justify-content-center align-items-center">
		<div class="text-center">
			<h1 class="fw-bold">Online Cinema Project</h1>
			<p>
				
			</p>
			<button class="btn bg-primary btn-lg text-white text-uppercase">Get Start</button>
		</div>
	</div>



</body>
</html>
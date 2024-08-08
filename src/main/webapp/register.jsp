<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>

<%@include file="all_component/allCss.jsp" %>

</head>
<body style="background: #f7f7f7">

	<%@include file="all_component/navbar.jsp" %>
	
	<!-- start register form -->

	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h2 class="text-center">Registration</h2>

						<c:if test="${not empty succMsg}">
							<div class="d-flex justify-content-center gap-2">
								<p class="text-center text-success">${succMsg}</p>
							<a href="login.jsp">Login</a>
							</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<c:if test="${not empty failedMsg}">
							<p class="text-center text-danger">${failedMsg}</p>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<form action="register" method="post">
							<div class="mb-3">
								<label for="exampleInputName1" class="form-label">Name*</label>
								<input type="text" class="form-control" id="exampleInputName1"
									required="required" name="name">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address*</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									required="required" name="email">
							</div>
							<div class="mb-3">
								<label for="exampleInputNumber1" class="form-label">Phone*</label>
								<input type="number" class="form-control" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
									id="exampleInputNumber1" required="required" name="phone" maxlength="11">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password*</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1" required="required" name="password">
							</div>
							<select class="form-select mb-3" aria-label="Default select example" name="role">
							  <option name="role" value="ADMIN">Admin</option>
							  <option name="role" value="USER">User</option>
							</select>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input" name="check"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Agree terms & conditions</label>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- end register form -->

	<script >
	document.getElementById("#exampleInputNumber1").maxLength = "8";
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="all_component/allcss.jsp" %>

<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid div-color ">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-5">
					<div class="card-header text-center text-white bg-custom">
					<i class="fa fa-user-plus fa-3x " aria-hidden="true"></i>
					<h4>Login</h4>
					</div>
					
					<%
					String regMsg = (String) session.getAttribute("login-success");

					if (regMsg != null) {
					%>
					<div class="alert alert-success">
						<%=regMsg%>
						
					</div>

					<%
					
					session.removeAttribute("login-success");
					}
					%>

					<%
					String failedMsg = (String) session.getAttribute("failed-msg");

					if (failedMsg != null) {
					%>
					<div class="alert alert-danger">
						<%=failedMsg%>
					</div>

					<%
					
					session.removeAttribute("failed-msg");
					}
					%>

					<div class="card-body">
						<form method="post" action="LoginServlet">
						
							<div class="form-group">
							<label>Enter Email</label>
								 <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail"> 
							</div>
							<div class="form-group">
							<label>Enter Password</label>
								 <input
									type="password" class="form-control" id="exampleInputPassword1" name="upassword">
							</div>
							
							<button type="submit" class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>








</body>
</html>
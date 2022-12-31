<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<%@page import="java.util.List"%>
<%@page import="com.Library.bean.Book_Bean"%>
<%@page import="com.Library.dao.ConnectionDao"%>
<%@page import="com.Library.dao.BookDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	BookDao bkd = new BookDao(ConnectionDao.getConnection());
	Book_Bean b = bkd.getSingleBook(id);
	request.setAttribute("editbook", b);	
%>


<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<title>Edit Book Data</title>
<style>
.inner {
	position: relative;
	margin: 0 auto;
	width: 650px;
	display: block;
	padding: 50px 0;
}

h3 {
	text-align: center;
	border-bottom: 2px solid midnightblue;
	margin-bottom: 20px;
}

nav li a {
	font-size: 25px;
	font-weight: 500;
}

a {
	color: #fff;
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-light">
			<a class="navbar-brand"><h3><em> Ajaz's Central Library </em></h3></a>
			<ul class="navbar-nav ml-auto mt-3 mx-5">
				<li class="nav-item"><a class="nav-link active"
					href="index.jsp">Home</a></li>
			</ul>
		</nav>
	</div>
	<div class="inner">
		<div class=" container">
			<div class="row">
				<div class="col-12">
					<h3>Edit Book Details</h3>
					<form action="EditBooksServlet" method="post">
						<div class="form-group">
							<label>Book ID</label> <input class="form-control" name="bid"
								value="${editbook.id}" required>
						</div>
						<div class="form-group">
							<label>Book Name</label> <input class="form-control"
								name="bname" value="${editbook.bookName}" required>
						</div>
						<div class="form-group">
							<label>Description</label> <input class="form-control"
								name="bdesc" value="${editbook.bookDesc}" required>
						</div>
						<div class="form-group">
							<label>Author Name</label> <input class="form-control"
								name="authorname" value="${editbook.authName}" required>
						</div>
						<div class="form-group">

							<label>Category</label> <select id="inputState"
								class="form-control" name="category" required>
								<option selected disabled>Choose Category</option>
								<option value="Novel">Novel</option>
								<option value="Science Fiction">Science Fiction</option>
								<option value="Drama">Drama</option>
								<option value="Programming & Development">Programming &
									Development</option>
							</select>
						</div>
						<button type="submit" class="btn btn-outline-primary">Submit</button>
						<button class="btn btn-primary">
							<a href="index.jsp">Cancel</a>
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>


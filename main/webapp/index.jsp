<%@page import="java.util.List"%>
<%@page import="com.Library.bean.Book_Bean"%>
<%@page import="com.Library.dao.ConnectionDao"%>
<%@page import="com.Library.dao.BookDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
   
    BookDao b = new BookDao(ConnectionDao.getConnection());
	List<Book_Bean> bk = b.getAllBooks();
	request.setAttribute("book_list", bk);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management-CRUD</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
.inner {
	margin: 15px 0;
}

/* body{
background-image: url("library.jfif");
} */
</style>
</head>
<body>

	<div class="container-fluid">
		<nav class="navbar navbar-light">
			<a class="navbar-brand"> <h3><em> Ajaz's Central Library </em></h3></a>
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</nav>
	</div>
	<div class="container">
		<div class="inner">
			<div class="row">
				<div class="col-md-3">
					<h3><u>Book Details</u></h3>
					
					<form action="AddBooksServlet" method="post">
						<div class="form-group">
							<label>Book Name</label> <input class="form-control"
								name="bookname" place-holder="Book Name" required>
						</div>
						<div class="form-group">
							<label>Description</label> <input class="form-control"
								name="bookdesc" place-holder="Book Name" required>
						</div>
						<div class="form-group">
							<label>Author Name</label> <input class="form-control"
								name="authorname" place-holder="Book Name" required>
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
						<button type="reset" class="btn btn-outline-primary">Reset</button>
					</form>
				</div>
				<div class="col-md-9">
					<h3>Book Information From Database</h3>
					<table class="table">
						<thead class="bg-light">
							<tr>
								<th scope="col">Book Name</th>
								<th scope="col">Description</th>
								<th scope="col">Author</th>
								<th scope="col">Category</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="library" items="${book_list}">
								<tr>
								<td>${library.bookName}</td>
								<td>${library.bookDesc}</td>
								<td>${library.authName}</td>
								<td>${library.category}</td>
								<td><a href="editBook.jsp?id=${library.id}">Edit</a> 
								<a href="deleteBook?id=${library.id }">Delete</a> 
								</td>
								
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
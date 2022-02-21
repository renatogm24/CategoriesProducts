<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show book</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<div class="container justify-center">
		<h1 class="text-danger">All Products</h1>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td> <a href="/products/${product.getId()}"><c:out value="${product.getName()}" /></a></td>
						<td><c:out value="${product.getDescription()}" /></td>
						<td><c:out value="${product.getPrice()}" /></td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2 class="text-center mb-3">Create a new Product!</h2>
		<div style="width: 60%;" class="mx-auto">
			<form:form
				class="row g-2 justify-content-center bg-dark text-light py-4 px-3 rounded"
				action="/products" method="post" modelAttribute="product">

				<form:label for="name" path="name" class="form-label">Name:</form:label>
				<form:errors path="name" class="text-danger" />
				<form:input type="text" path="name" class="form-control" id="name" />
				
				<form:label for="description" path="description" class="form-label">Description:</form:label>
				<form:errors path="description" class="text-danger" />
				<form:input type="text" path="description" class="form-control"
					id="description" />
					
				<form:label for="price" path="price" class="form-label">Price:</form:label>
				<form:errors path="price" class="text-danger" />
				<form:input type="number" path="price" class="form-control"
					id="price" />
				
				<button class="btn btn-primary mt-4" type="submit">Add product</button>
			</form:form>
		</div>

	</div>
</body>
</html>
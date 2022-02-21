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
		<h1 class="text-danger">${category.getName()}</h1>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Product Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${category.getProducts()}">
					<tr>
						<td><c:out value="${product.getName()}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2 class="text-center mb-3">Add new Product!</h2>

		<div style="width: 60%;" class="mx-auto">
			<form:form
				class="row g-2 justify-content-center bg-dark text-light py-4 px-3 rounded"
				action="/categories/${category.getId()}/addProduct" method="post">

				<select name="product_id">
					<c:forEach var="productAux" items="${products}">
						<option value="${productAux.getId()}">
							${productAux.getName()}
						</option>
					</c:forEach>
				</select>

				<button class="btn btn-primary mt-4" type="submit">Add
					Product to category</button>
			</form:form>
		</div>


	</div>
</body>
</html>
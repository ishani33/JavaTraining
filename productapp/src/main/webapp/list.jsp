<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
	<h2>Product List</h2>
	<form method="post" action="cart">
		<table border=1>
			<tr> <th> Name </th> <th> Price </th> <th> Category </th> </tr>
			<c:forEach items="${products}" var = "p">
				<tr>
					<td> ${p.name} </td><!-- p.name invokes getName() getter : p should not be followed by the variable name but the getter -->
					<td> ${p.price} </td>
					<td> ${p.category} </td>
					<td> <input type="checkbox" name="prds" value="${p.id}"/></td>
				</tr>
			</c:forEach>
		</table>
		<button type="submit">Add to cart</button>
	</form>
</body>
</html>
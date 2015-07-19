<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Shopping list</title>
	</head>
	<body>
		<h2>Shopping List from: ${userName}</h2>
		<c:if test="${not empty items}">
		<table border="1" width="15%" cellpadding="1">
			<tr>
				<th>Name</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${items}" var="item">
				<tr>
				<td>${item.name}</td>
				<td>${item.quantity}</td>
				</tr>
			</c:forEach>
	  	</table>
	  	</c:if>
	  	<c:if test="${empty items}">
	  		User List is Empty
	  	</c:if>
	  	</br></br>
	    <form class="addItem" action="list" method="post">
	      New Item: <br />
	      <textarea name="name" maxlength="50"  rows="1" cols="15"></textarea><br />
	      Item Quantity: <br />
	      <textarea name="quantity" maxlength="3"  rows="1" cols="15"></textarea><br />
	      <input type="submit" value="Add">
	    </form>
	</body>
</html>

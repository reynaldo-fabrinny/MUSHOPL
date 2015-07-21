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
	  	</br>
	  	</br>
	    <form class="addItem" action="list" method="post">
		      New Item: <br />
		      <input type="text" name="name" maxlength="50"><br />
		      Item Quantity: <br />
		      <input name="quantity" type="number" min="0"  maxlength="3"><br />
		      <input type="submit" value="Add">
	    </form>
	    <form class="logoutButton" method="post" action="logout">
	    	<input type="submit" value="Submit" />
	    </form>
	    <div class="logoutButton">
			<a href="<c:url value="j_spring_security_logout" />">Logout</a>
		</div>
	</body>
</html>

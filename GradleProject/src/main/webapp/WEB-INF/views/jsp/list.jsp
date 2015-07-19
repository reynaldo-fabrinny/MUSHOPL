<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>List</title>
	</head>
	<body>
		<div class="container">
		  <div class="row">
			<div class="col-md-4">
				<h2>Heading</h2>
				<p>ABC</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details</a>
				</p>
			</div>
		  </div>
		  <hr>
		</div>
	    <form action="addItem" method="post">
	      New Item: <br />
	      <textarea name="name" maxlength="50"  rows="1" cols="15"></textarea><br />
	      Item Quantity: <br />
	      <textarea name="quantity" maxlength="3"  rows="1" cols="15"></textarea><br />
	      <input type="submit" value="Add">
	    </form>
	</body>
</html>

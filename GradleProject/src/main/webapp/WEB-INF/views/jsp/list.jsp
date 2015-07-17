<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>List</title>
	</head>
	<body>
		<div class="jumbotron">
		  <div class="container">
			<h1>${title}</h1>
			<p>
				<c:if test="${not empty msg}">
					Hello ${msg}
				</c:if>
		 
				<c:if test="${empty msg}">
					Welcome Welcome!
				</c:if>
		        </p>
		        <p>
				<a class="btn btn-primary btn-lg" 
		                    href="#" role="button">Learn more</a>
			</p>
			</div>
		</div>
		 
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
	</body>
</html>

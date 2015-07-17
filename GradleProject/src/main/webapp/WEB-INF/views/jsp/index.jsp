<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>The Ultra Shop List</title>
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
	   <form method="post" action="list.jsp">
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name/E-mail</td>
                        <td><input type="text" name="uname" value="" size=15 /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" size=15 /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
	  </div>
	  <hr>
	</div>

</body>
</html>

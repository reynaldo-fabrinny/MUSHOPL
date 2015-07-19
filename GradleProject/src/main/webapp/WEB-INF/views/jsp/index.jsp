<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>The Shop List</title>
	</head>
	<body>
		<div class="container">
		   <form method="post" action="">
	            <table border="1" width="30%" cellpadding="3">
	                <thead>
	                    <tr>
	                        <th colspan="2">Login Here</th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<c:if test="${not empty msg}">
							${msg}
						</c:if>
	                    <tr>
	                        <td>Username/E-mail</td>
	                        <td><input type="text" name="email" size=15 /></td>
	                    </tr>
	                    <tr>
	                        <td>Password</td>
	                        <td><input type="password" name="password" value="" size=15 /></td>
	                    </tr>
	                    <tr>
	                        <td><input type="submit" value="Submit" /></td>
	                    </tr>
	                </tbody>
	            </table>
	        </form>
		  </div>
	</body>
</html>

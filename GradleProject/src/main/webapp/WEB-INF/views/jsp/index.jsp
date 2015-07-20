<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>The Shop List</title>
	</head>
	<body>
		<div class="container">
		   <form name="form" method="post" action="j_spring_security_check">
	            <table border="1" width="30%" cellpadding="3">
	                <thead>
	                    <tr>
	                        <th colspan="2">Mushopl Login</th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						      <font color="red">
						        Your login attempt was not successful due to <br/><br/>
						        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
						      </font>
						</c:if>
	                    <tr>
	                        <td>E-mail</td>
	                        <td><input type="text" name="email" size=15 /></td>
	                    </tr>
	                    <tr>
	                        <td>Password</td>
	                        <td><input type="password" name="password" value="" size=15 /></td>
	                    </tr>
	                    <tr>
	                        <td><input name="submit" type="submit" value="Login" /></td>
	                    </tr>
	                </tbody>
	            </table>
	        </form>
		  </div>
	</body>
</html>

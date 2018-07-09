<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Custom Login Page</title>
<style>
.failed{

color: red;

}
</style>
</head>
<body>
<h3>My custom LOgin Page</h3>


<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

<c:if test ="${param.error != null }">

<i class = "failed">Sorry you entered invalid username/password</i>

</c:if>
<p>
User name:<input type="text" name="Username"/>

Password:<input type="text" name="Password"/>

<input type="submit" value="Login"/>


</p>
</form:form>
</body>
</html>
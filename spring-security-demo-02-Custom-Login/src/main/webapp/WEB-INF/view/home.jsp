<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>
User:<security:authentication property = "principal.username"/>
<br><br>
Role(s): <security:authentication property = "principal.authorities"/>
</p>
<hr>
<!--  Add a link to point to leaders.. this is for managers -->

<!--  how to display links based on roles  -->

<security:authorize access="hasRole('MANAGER')">
<p>
<a href = "${pageContext.request.contextPath }/leaders">Leadership Meeting</a>
(only for Manager peeps)
</p>
</security:authorize>

<!--  how to display links based on roles  -->
<security:authorize access="hasRole('ADMIN')">
<p>
<a href = "${pageContext.request.contextPath }/systems">Admin Meeting</a>
(only for Admin peeps)
</p>
</security:authorize>

<hr>
<h2> view page</h2>

 <form:form action="${pageContext.request.contextPath}/logout" 
 method="POST" class="form-horizontal">
<input type = "submit" value = "Logout" />
					    
</form:form>
</body>
</html>
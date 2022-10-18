<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<c:if test = "${sessionScope.message != null}">
		<script>
			alert("<c:out value = '${message}'/> ");
		</script>
    <c:remove var="error" />
        
	</c:if>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="newUserForm" action = "newUserAccount" method="post"  >
	
		<label>Name</label>
		<input type="text" name="name" id="name">
		
		<br/>
		
		<label>Username</label>
		<input type="text" name="username" id="username">
		
		<br/>
		
		<label for = "profile">Choose Profile: </label>
		<select class="form-control" name="userProfile">
        	<c:forEach var="userProfile" items="${userProfileList}">
            	<option value ="<c:out value='${userProfile.id }' />">
            		<c:out value = "${userProfile.profile }" />
            	</options>
            </c:forEach>
       </select>
		
		<br/>
		<label>password</label>
		<input type="password" name="password" id="password" >
		
		<br/>
		
		<button type= "submit">Submit</button>
		
		
	
	</form>
</body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		
		<label>Name</label>
		<input type="text" name="name" id="name" value="<c:out value='${userAccount.name}' />">
		
		<br/>
		
		<label>Username</label>
		<input type="text" name="username" id="username" value="<c:out value='${userAccount.username}' />">
		
		<br/>
		
		<label>Status</label>
		<input type="text" name="username" id="username" value="<c:out value='${userAccount.status}' />" readonly>
		
		<br/>
		
		<label>Profile</label>
		<select name="userProfile" id="userProfile">
			<c:forEach var="userProfile" items = "${userProfileList}" >
				<option value="<c:out value='${userProfile.id}' />" >
					<c:out value = '${userProfile.profile }'/> 
				</option>
			</c:forEach>

		
		</select>
		
		<br/>
		<button type="submit">Button</button>
	</form>
</body>
</html>
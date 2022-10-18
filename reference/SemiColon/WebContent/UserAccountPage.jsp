<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All User Account</h1>
	<br/>

	<form action = "searchUserAccount" method = "post">
		<label>Search </label>
		<input name = "searchbox" id = "searchbox" type = "text" placeholder = "search by name" > 
		<button type="submit">Find</button>
	</form>


	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>name</th>
				<th>username</th>
				<th>password</th>
				<th>Role </th>
				<th>Status</th>
				<th> </th>
				

			</tr>

		</thead>
		<tbody>
			<c:forEach var ="user" items = "${userAccountList}">
				<tr>
					<td>
						<c:out value="${user.id}" />
					</td>
					<td>
						<c:out value="${user.name}" />
					</td>
					<td>
						<c:out value="${user.username}" />
					</td>
					<td>
						<c:out value="${user.password}" />
					</td>
					<td>
						<c:out value= "${user.userProfile.profile }"/>
					</td>
					<td>
						<c:out value="${user.status}" />
					</td>
					<td>
						<a href="editUserAccountForm?id=<c:out value = '${ user.id}'  />" >
						Edit
						</a>
					</td>
					

						
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
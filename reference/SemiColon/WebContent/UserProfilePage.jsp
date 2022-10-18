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
	<h1>All User Profile</h1>
	<br/>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Profile</th>
				<th>Description</th>
				<th>" " </th>
				

			</tr>

		</thead>
		<tbody>
			<c:forEach var ="user" items = "${userProfileList}">
				<tr>
					<td>
						<c:out value="${user.id}" />
					</td>
					<td>
						<c:out value="${user.profile}" />
					</td>
					<td>
						<c:out value="${user.description}" />
					</td>
					
					<td>
						<a href="<%=request.getContextPath()%>/EditAccountForm?id=<c:out value = '${ user.id}'  />" >
						Edit
						</a>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
		
</body>
</html>
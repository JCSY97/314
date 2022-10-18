    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Insert title here</title>
	<c:if test = "${sessionScope.error != null}">
		<script>
			alert("<c:out value = '${error}'/> ");
		</script>
    <c:remove var="error" />
        
	</c:if>
</head>
<body>

	 <form id="loginForm" action="login" method="post"  onsubmit="return loginValidation();">
	     <h2>Login</h2>
	     <fieldset class="form-group">
	        <label>Username</label>
	        <input type="text" class="form-control" name="username" id="username">
	        <i class="fa-solid fa-circle-check symbol valid"></i>
	        <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
	        <small>Error</small>
	     </fieldset>
	     <fieldset class="form-group">
	        <label>Password</label>
	        <input type="password" class="form-control" name="password" id="password">
	        <i class="fa-solid fa-circle-check symbol valid"></i>
	        <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
	        <small>Error</small>
	     </fieldset>
	     <label for = "profile">Choose Profile: </label>
		 <select name = "profile" id = "profile" >
			<option value = "System Admin" >SysAdmin</option>
			<option value = "Reviewer" >Reviewer</option>
			<option value = "Conference" >Conference Chair</option>
			<option value = "Author" >Author</option>
			
		 </select> 
	     <div class="btn-toolbar pull-right">
	        <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Login</button>
	     </div>
	  </form>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Site Users</h1>
        
        <h3>User Details</h3>
        <hr>
        <form action="./updateUser" method="post">
		
		<label>Email:</label>
		<input type="text" autofocus="autofocus" name="email" value="${selectedUser.email}" readonly><br><br>
		
		<label>First Name:</label>
		<input type="text" name="firstName" value="${selectedUser.firstName}" required><br><br>
		
		<label>Last Name:</label>
		<input type="text" name="lastName" value="${selectedUser.lastName}" ><br><br>
                
                <label>Password:</label>
		<input type="text" name="passwd" value="${selectedUser.passwd}"><br><br>
                
                <label>Role: </label> <br>  <!--look at making this db driven -->
                <select name="role" required>
                    <option value="user" ${selectedUser.role == 'user' ? 'selected' : ''}>User</option>
                    <option value="admin" ${selectedUser.role == 'admin' ? 'selected' : ''}>Administrator</option>
                </select>
                
                <br><br>
                <label>&nbsp;</label>
		<input type="submit" value="Update User" id="submit">
                
	</form>
    </body>
</html>

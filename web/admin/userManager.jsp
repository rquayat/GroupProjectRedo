<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Manager</title>
    </head>
      <body>
        <a href="${pageContext.request.contextPath}/auth/logout.jsp">Logout</a>
        &nbsp; | &nbsp;
        <a href="${pageContext.request.contextPath}/admin/index.jsp">Admin-Home</a>
        <h1>Manage Site Users</h1>
        
        <h3>New User</h3>
        <hr>
        <form action="./newUser" method="post">
		
		<label>Email:</label>
		<input type="text" autofocus="autofocus" name="email" required><br><br>
		
		<label>First Name:</label>
		<input type="text" name="firstName" required><br><br>
		
		<label>Last Name:</label>
		<input type="text" name="lastName" ><br><br>
                
                <label>Password:</label>
		<input type="password" name="passwd" ><br><br>
                
                <label>Role: </label> <br>  <!--look at making this db driven -->
                <select name="role" required>
                    <option value="" selected> -choose option- </option>
                    <option value="user">User</option>
                    <option value="admin">Administrator</option>
                </select>
                
                <br><br>
                <label>&nbsp;</label>
		<input type="submit" value="Add New User" id="submit">
                <input type="reset" value="Clear" id="reset">
	</form>
        
        <br><br><br><br>
        <h3>Manage Users</h3>
        <hr>
        <table border="1">
                 <tr>
                    <th>First Name</th>
                    <th>Last Name</th> 
                    <th>Email</th>
                    <th>Password</th>
                    <th>Role</th>
                  </tr>
                  
            <c:forEach items="${allUsers}" var="user" varStatus="status">
                    <tr>
                        <td> ${user.firstName} </td>
                        <td> ${user.lastName} </td>
                        <td> ${user.email} </td>
                        <td> ${user.passwd} </td>
                        <td> ${user.role} </td>
                        <td> <a href="./deleteUser?email=${user.email}"> delete </a>
                        <td> <a href="./getUser?email=${user.email}"> update </a>
                    </tr>
            </c:forEach>
    
        </table>
        
        
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Bookmarks | Application Administrator</title>
    </head>
    
   
     
    <body>
        <a href="${pageContext.request.contextPath}/auth/logout.jsp">Logout</a>
       
        
       
        
        <h5> Admin Functionality </h5><hr>
        <a href="${pageContext.request.contextPath}/admin/usermanager">User Manager</a>
        <br>
        <a href="${pageContext.request.contextPath}/admin/readAllBooks">View Everyone's Books</a>
        
        <br>
        <br>
        <br>
        <h5> User Functionality </h5><hr>
        
    </body>
</html>

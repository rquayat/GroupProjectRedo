<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bookmarks | Logout</title>
    </head>
    <body>
        <h1>You have been logged out.</h1>
        
        <%
            session.invalidate();
            
                String url = request.getContextPath() + "/index.jsp";
                
                response.sendRedirect(url);
        %>
    </body>
</html>

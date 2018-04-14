<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Bookmarks | Application Administrator</title>
    </head>
    
    <%
	// Prevents page from being cached, allowing attacker to use the back button to access the page.
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //Proxy servers
	
        // Additional layer of security, ensuring a blank (unauthencitecated user) cannot connect. 
        String url = request.getContextPath() + "/auth/login.jsp";
        String username = request.getUserPrincipal().getName().toString();
	if (username == null)
			response.sendRedirect(url);
%>
     
    <body>
        <a href="${pageContext.request.contextPath}/auth/logout.jsp">Logout</a>
       
        
        <h1>Hello Admin!</h1> <h3><%= username %></h3>
        
        <h5> Admin Functionality </h5><hr>
        
        
        
        <br>
        <br>
        <br>
        <h5> User Functionality </h5><hr>
        
    </body>
</html>

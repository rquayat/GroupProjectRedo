<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Bookmarks | Manager</title>
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
        <a href="<%=request.getContextPath()%>/auth/logout.jsp">Logout</a>
        <br>
        <h1>My Bookmarks</h1>
        
        <h5>Hello user - <%= username %></h5>
        
       
        <br>
        <br>
        <hr>
        <br>
        
    </body>
</html>

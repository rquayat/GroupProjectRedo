<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bookmarks | Login Error</title>
        
        <script> 
            function showPwdFunction() {
                var x = document.getElementById("pwd");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
        </script>
        
    </head>
    <body>
        <h1>Login Error</h1>
        <p>You did not log in successfully.</p>
        <p>Please check your username and password and try again.</p>

        <form action="j_security_check" method="post">
            <label>Email:</label>
            <input type="text" autofocus="autofocus" name="j_username" autocomplete="off"><br>
            <!-- autocomplete="off" increases security by preventing caching of form data -->
            <label>Password:</label>
            <input type="password" id="pwd" name="j_password" autocomplete="off"><br>
            
            <!-- An element to toggle between password visibility -->
            <input type="checkbox" onclick="showPwdFunction()">Show Password
            
            <br>
            
            <label>&nbsp;</label>
            <input type="submit" value="Login">
        </form>
        
    </body>
</html>

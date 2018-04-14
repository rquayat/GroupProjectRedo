<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bookmarks Application</title>
    </head>
    <body>
        
        <h1>Mike's Bookmarks Application</h1>
        <a href="./user/">User Login</a>
        <p>
        To test authenticated user functionality, login as test@test.com with 'password' (no quotes). This user can see their own books
        add new books to their list, delete books from their list, and update their books.
        </p>

        <br>
        
        <a href="./admin/">Admin Login</a>
        <p>
        To test admin functionality, login as mike@mike.com with 'password' (no quotes). This account can see everyone's books, view all users
        add new users, delete users, and update users.
        </p>
       
        <hr>
        <p>If web.xml is missing:
        <ul>
            <li>Right-click the root of the project and choose New --> Other </li>
            <li>Search for "Standard Deployment Descriptor" --> Next</li>
            <li>A basic web.xml appears under "Configuration Files"</li>
        </ul>
        </p>
    </body>
</html>

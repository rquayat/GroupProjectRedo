

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="WEB_INF/newcss.css">
        <title>Add an Asset </title>
    </head>
    <body>
        <h1>Add an Asset</h1>
        
        <form name="addForm" action="Add" method="get">
            
            <label> Category: </label>
            <input type="text" name="category" value="" />
            <br>
            <label> Name: </label>
            <input type="text" name="name" value="" />
            <br>
            <label> Value: </label>
            <input type="text" name="value" value="" />
            <br>
            <label> Date of Purchase: </label>
            <input type="text" name="dateofpurchase" value="" />
            <br>
            <label> Submit: </label>
            <input type="submit" name="submit" value="Submit" />
            <br>
      
        </form>
    </body>
</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="WEB-INF/newcss.css">
        <title>Search Assets</title>
    </head>
    <body>
        <h1>Search Assets by Category </h1>
        <br>
        <h3>Assets are categorized as follow: </h3>
        
        <h4>Real Estate, Car, Stock, Investment, and Misc </h2>
        
        <form name="searchForm" action="search" method="get">
            <label> Category: </label>
            <input type="text" name="searchVal" value="" />
            
            <br>
            
            <input type="submit" name="submit" value="Search" />
                        
        </form>
    </body>

</html>

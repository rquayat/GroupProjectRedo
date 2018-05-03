

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Assets"%>
<%Assets asset = (Assets) request.getAttribute("asset"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="WEB-INF/newcss.css">
        <title>Update an Asset</title>
    </head>
    <body>
        <h1>Update an Asset</h1>
        
        <form name="updateForm" action="update" method="get">
            <table class="table">
                <br>
                <tr> 
                    <td> Category: </td>
                    <td><input type="text" name="category" value="<% asset.getCategory(); %>" > </td>
                </tr>
            <br>
                <tr> 
                    <td> Name: </td>
                    <td><input type="text" name="name" value="<% asset.getName(); %>" > </td>
                </tr>           
            <br>
            <tr> 
                    <td> Value: </td>
                    <td><input type="text" name="value" value="<% asset.getValue(); %>" > </td>
                </tr>           
            <br>
            <tr> 
                    <td> Date of Purchase: </td>
                    <td><input type="text" name="dateofpurchase" value="<% asset.getDateOfPurchase(); %>" > </td>
                </tr>           
            <br>
            
            </table>
            <br>
            <input type="reset" name="reset" value="Clear" />
            <input type="submit" name="updateasset" value="Update" />
            <br>
        </form>
    </body>
</html>

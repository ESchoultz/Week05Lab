<%-- 
    Document   : register
    Created on : Oct 9, 2018, 12:38:05 PM
    Author     : 669385
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            Username: <input type="text" name="user" >
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register Name">
        </form>
    </c:if>
</body>
</html>

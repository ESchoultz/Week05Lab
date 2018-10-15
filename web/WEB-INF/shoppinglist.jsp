<%-- 
    Document   : shoppinglist
    Created on : Oct 9, 2018, 12:22:42 PM
    Author     : 669385
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Shopping List</title>
    </head>

    <h1>Shopping List</h1>
    Hello, <c:out value="${user}"></c:out> <a href="?action=logout">Logout</a>
        <h2>List</h2>
        <form  action="" method="POST">
            <input type="text" name="item">
            <input type="hidden" name="action" value="add" >
            <input type="submit" value="Add" >
        </form>

    <c:if test="${shoppinglist != null}">
        <form action="" method="POST">
            <ul>
                <c:forEach var="item" items="${shoppinglist}" >
                    <li><input type="radio" name="rbutton" value="${item}">${item}</li><br>
                    </c:forEach>
            </ul>
            <input type="hidden" name="action" value="delete" >
            <input type="submit" value="Delete" >
        </form>
    </c:if>
</html>
<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 5/17/2021
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JPA TUTORIAL</title>
</head>
<body>
<form action="./edit-edition">
    <input type="hidden" id="editionId" name="editionId" value ="<%= request.getParameter("editionId") %>">
    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">

    Description: <input type="text" id="description" name="description">
    <br />
    Release Year: <input type="date" id="release_year" name="release_year">

    <input type="submit" value="Edit Edition!">
</form>
</body>
</html>

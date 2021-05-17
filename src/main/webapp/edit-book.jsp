<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 5/16/2021
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="./edit-Book">

  <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">

  Book title: <input type="text" id="title" name="title">
  <br />
  Book ISBN: <input type="text" id="isbn" name="isbn">
  <br />
  Book Genre: <input type="text" id="genre" name="genre">
  <br />
  <input type="submit" value="Edit book!">
</form>
</body>
</html>

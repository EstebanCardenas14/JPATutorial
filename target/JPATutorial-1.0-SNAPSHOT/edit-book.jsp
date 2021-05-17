
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

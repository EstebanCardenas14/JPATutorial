
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JPA Tutorial</title>
</head>
<body>
<form action="./edit-author">
    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
    Author name: <input type="text" id="name" name="name">
    Author country: <input type="text" id="country" name="country">
    <input type="submit" value="Edit Author!">
</form>

</body>
</html>

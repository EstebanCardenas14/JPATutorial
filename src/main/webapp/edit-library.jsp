
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JPA TUTORIAL</title>
</head>
<body>
<form action="./edit-library">
    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">
     Library Name: <input type="text" id="Lname" name="Lname">
     <br />
    <input type="submit" value="Edit Library!">
</form>
</body>
</html>

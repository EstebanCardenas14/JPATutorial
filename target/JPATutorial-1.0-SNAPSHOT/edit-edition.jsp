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
    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">

</body>
</html>

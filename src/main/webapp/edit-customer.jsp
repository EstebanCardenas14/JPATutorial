<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 5/17/2021
  Time: 12:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JPA TUTORIAL</title>
</head>
<body>
<form action="./edit-customer">


    Customer First Name: <input type="text" id="first_name" name="first_name">
    <br />
    Customer Last Name: <input type="text" id="last_name" name="last_name">
    <br />
    Customer Email: <input type="email" id="email" name="email">
    <br />
    Customer Gender: <input type="text" id="gender" name="gender">
    <br />
    Customer Age: <input type="text" id="age" name="age">
    <br />
    <input type="submit" value="Edit Customer!">
</form>


</body>
</html>

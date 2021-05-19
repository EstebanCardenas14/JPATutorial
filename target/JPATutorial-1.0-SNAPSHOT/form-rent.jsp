<<<<<<< HEAD
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="./create-Rent">
    <input type="hidden" id="email" name="email" value ="<%= request.getParameter("email") %>">
    Choose your Book to rent: <select name="books_view" id="books_view">
</select>
    <input type="submit" value="Create Rent!">
</form>
<script>
    var dataBook = document.getElementById("books_view");
    var databookOption = document.createElement('option');
    var data = JSON.parse(xhr.responseText);
</script>
</body>
</html>
=======
<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 5/19/2021
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JPA TUTORIAL</title>
</head>
<body>
<form action="./create-rent">

    Email: <input type="text" id="email" name="email">

    ID_Edition : <input type="text" id="id_edition" name="id_edition">

    Year: <input type="date" id="release_year" name="release_year">

    <input type="submit" value="Create Rent!">

</form>



</body>
</html>
>>>>>>> 90bf4324d0d3cbc56af888b576ed628e9aea8a42

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
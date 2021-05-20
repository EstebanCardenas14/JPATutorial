<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
    <link rel="stylesheet" href="./CSS/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<%--<form action="./create-book">--%>
<%--    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">--%>
<%--    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">--%>
<%--    Book title: <input type="text" id="title" name="title">--%>
<%--    <br />--%>
<%--    Book ISBN: <input type="text" id="isbn" name="isbn">--%>
<%--    <br />--%>
<%--    Book Genre: <input type="text" id="genre" name="genre">--%>
<%--    <br />--%>
<%--    Release Year: <input type="date" id="release_year" name="release_year">--%>
<%--    <br />--%>
<%--    Description: <input type="text" id="description" name="description">--%>
<%--    <br />--%>
<%--    <input type="submit" value="Create book!">--%>
<%--</form>--%>



<br><br>
<h1 class="titulo">Crear Libro</h1>
<form class="row g-3 formulario_1" action="./create-book">
    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">
    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
    <div class="mb-3">
        <label for="isbn" class="form-label">Book Title </label>
        <input type="text" id="title" name="title" class="form-control" placeholder="Book Title">
    </div>
    <div class="mb-3">
        <label for="isbn" class="form-label">Book ISBN </label>
        <input type="text" id="isbn" name="isbn" class="form-control" placeholder="Book ISBN">
    </div>
    <div class="mb-3">
        <label for="genre" class="form-label">Book Genre </label>
        <input type="text" id="genre" name="genre"class="form-control" placeholder="Book Genre ">
    </div>
    <div class="mb-3">
        <label for="release_year" class="form-label">Realise year </label>
        <input type="date" id="release_year" name="release_year" class="form-control" placeholder="Realise year">
    </div>
    <div class="mb-3">
        <label for="description" class="form-label">Description </label>
        <input type="text" id="description" name="description" class="form-control"  placeholder="Description ">
    </div>

    <div class="col-md-12">
        <input class="btn" type="submit" value="Create book!">
    </div>


</form>

</body>
</html>
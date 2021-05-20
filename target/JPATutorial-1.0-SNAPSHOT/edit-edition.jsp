
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./CSS/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>JPA Tutorial</title>
</head>
<body>
<%--<form action="./edit-edition">--%>
<%--    <input type="hidden" id="editionId" name="editionId" value ="<%= request.getParameter("editionId") %>">--%>
<%--    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">--%>

<%--    Description: <input type="text" id="description" name="description">--%>
<%--    <br />--%>
<%--    Release Year: <input type="date" id="release_year" name="release_year">--%>

<%--    <input type="submit" value="Edit Edition!">--%>
<%--</form>--%>


<br><br>
<h1 class="titulo">Editar Edition</h1>
<form class="row g-3 formulario_1" action="./edit-edition">
    <input type="hidden" id="editionId" name="editionId" value ="<%= request.getParameter("editionId") %>">
    <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">
    <div class="mb-3">
        <label for="description" class="form-label">Description </label>
        <input type="text" id="description" name="description" class="form-control"  placeholder="Description">
    </div>
    <div class="mb-3">
        <label for="release_year" class="form-label"> Release Year </label>
        <input type="date" id="release_year" name="release_year" class="form-control"  placeholder=" Release Year">
    </div>

    <div class="col-md-12">
        <input class="btn" type="submit" value="Edit Edition!"></input>
    </div>
</form>



</body>
</html>
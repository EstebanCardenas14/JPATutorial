
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="./CSS/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>JPA Tutorial</title>
</head>
<body>
<br><br>
<h1 class="titulo">Editar Autor</h1>
<form class="row g-3 formulario_1" action="./edit-author">
    <div class="mb-3">
        <input type="hidden" id="authorId" name="authorId"  value ="<%= request.getParameter("authorId") %>">
        <label for="name" class="form-label">Nombre autor </label>
        <input type="text" id="name" name="name" class="form-control"  placeholder="Nombre autor">
    </div>
    <div class="mb-3">
        <label for="country" class="form-label">Author country </label>
        <input type="text" id="country" name="country" class="form-control" placeholder="Author country">
    </div>
        <div class="col-md-12">
    <input class="btn" type="submit" value="Edit Author!">
        </div>

</form>

</body>
</html>

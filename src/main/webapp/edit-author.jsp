
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JPA Tutorial</title>
    <link rel="stylesheet" href="./CSS/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<%--<form action="./edit-author">--%>
<%--    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">--%>
<%--    Author name: <input type="text" id="name" name="name">--%>
<%--    Author country: <input type="text" id="country" name="country">--%>
<%--    <input type="submit" value="Edit Author!">--%>
<%--</form>--%>


<br><br>
<h1 class="titulo">Editar autor</h1>
<form class="row g-3 formulario_1" action="./edit-author">
    <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
    <div class="mb-3">
        <label for="name" class="form-label"> Author name </label>
        <input type="text" id="name" name="name" class="form-control"  placeholder="Author name">
    </div>
    <div class="mb-3">
        <label for="country" class="form-label">Author country </label>
        <input  type="text" id="country" name="country" class="form-control"  placeholder="Author country">
    </div>

    <div class="col-md-12">
        <input class="btn" type="submit" value="Edit Author!">Editar Autor</input>
    </div>
</form>



</body>
</html>

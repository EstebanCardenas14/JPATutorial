<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
    <link rel="stylesheet" href="./CSS/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<%--        <form action="./create-library">--%>
<%--            Library name: <input type="text" id="name" name="name">--%>
<%--            <input type="submit" value="Create library!">--%>
<%--        </form>--%>

<br><br>
<h1 class="titulo">Crear libreria</h1>
<form class="row g-3 formulario_1" action="./create-library">
    <div class="mb-3">
        <label for="name" class="form-label" >Nombre Libreria</label>
        <input type="text" id="name" name="name" type="text" class="form-control"  placeholder="Nombre Libreria">
    </div>

    <div class="col-md-12">
        <input class="btn" type="submit" value="Create library!"></input>
    </div>

</form>



</body>
</html>
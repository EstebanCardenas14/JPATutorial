<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
    <link rel="stylesheet" href="./CSS/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<%--<form action="./create-customer">--%>
<%--    Customer First Name: <input type="text" id="first_name" name="first_name">--%>
<%--    <br />--%>
<%--    Customer Last Name: <input type="text" id="last_name" name="last_name">--%>
<%--    <br />--%>
<%--    Customer Email: <input type="email" id="email" name="email">--%>
<%--    <br />--%>
<%--    Customer Gender: <input type="text" id="gender" name="gender">--%>
<%--    <br />--%>
<%--    Customer Age: <input type="text" id="age" name="age">--%>
<%--    <br />--%>
<%--    <input type="submit" value="Create Customer!">--%>
<%--</form>--%>


<br><br>
<h1 class="titulo">Crear usuario</h1>
<form class="row g-3 formulario_1" action="./create-customer">
    <div class="mb-3">
        <label for="first_name" class="form-label">Nombre usuario </label>
        <input type="text" id="first_name" name="first_name" class="form-control" placeholder="Ingrese nombre">
    </div>
    <div class="mb-3">
        <label for="last_name" class="form-label">Apellido </label>
        <input type="text" id="last_name" name="last_name" class="form-control"  placeholder="Ingrese apellido">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email </label>
        <input type="email" id="email" name="email" class="form-control"  placeholder="Email">
    </div>
    <div class="col-md-6">
        <label for="gender" class="form-label">Genero </label>
        <input  type="text" id="gender" name="gender" class="form-control" placeholder="Genero">
    </div>
    <div class="col-md-6">
        <label for="age" class="form-label">Edad </label>
        <input  type="text" id="age" name="age" class="form-control" placeholder="Edad">
    </div>

    <div class="col-md-12">
        <input class="btn" type="submit" value="Create Customer!">Crear usuario</input>
    </div>

</form>



</body>
</html>

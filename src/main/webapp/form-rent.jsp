<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
    <link rel="stylesheet" href="./CSS/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<h1 class="titulo">Crear Renat</h1>
<form  class="row g-3 formulario_1" action="./create-rent">
    <div class="mb-3">
        <label for="email" class="form-label">Email </label>
        <input type="text" id="email" name="email" class="form-control" placeholder="Ingrese email">
    </div>

    <div class="mb-3">
        <label for="email" class="form-label">Email </label>
        <input type="text" id="id_edition" name="id_edition" class="form-control" placeholder="Ingrese Id de edition">
    </div>

    <div class="mb-3">
        <label for="release_year" class="form-label">Realise year </label>
        <input type="date" id="release_year" name="release_year" class="form-control" placeholder="Realise year">
    </div>

    <div class="col-md-12">
        <input class="btn" type="submit" value="Create Rent!">
    </div>
</form>



</body>
</html>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./CSS/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>JPA Tutorial</title>
</head>
<body>
<%--<form action="./edit-customer">--%>


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
<%--    <input type="submit" value="Edit Customer!">--%>
<%--</form>--%>

<br><br>
<h1 class="titulo">Editar usuario</h1>
<form class="row g-3 formulario_1" action="./edit-customer">
    <div class="mb-3">
        <label for="first_name" class="form-label">Customer First Name </label>
        <input type="text" id="first_name" name="first_name" class="form-control"  placeholder="Customer First Name">
    </div>
    <div class="mb-3">
        <label for="last_name" class="form-label">  Customer Last Name </label>
        <input type="text" id="last_name" name="last_name"class="form-control"  placeholder="Customer Last Name">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">   Customer Email </label>
        <input type="email" id="email" name="email" class="form-control"  placeholder=" Customer Email">
    </div>
   <div class="mb-3">
        <label for="gender" class="form-label">   Customer Gender </label>
        <input type="text" id="gender" name="gender" class="form-control"  placeholder=" Customer Gender">
    </div>

    <div class="mb-3">
        <label for="age" class="form-label">  Customer Age</label>
        <input type="text" id="age" name="age" class="form-control"  placeholder="Customer Age">
    </div>

    <div class="col-md-12">
        <input class="btn" value="Edit Customer!" type="submit">Editar usuario</input>
    </div>
</form>


</body>
</html>

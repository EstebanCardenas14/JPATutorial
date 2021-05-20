
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./CSS/css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>JPA Tutorial</title>
</head>
<body>
<%--<form action="./edit-library">--%>
<%--    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">--%>
<%--     Library Name: <input type="text" id="Lname" name="Lname">--%>
<%--     <br />--%>
<%--    <input type="submit" value="Edit Library!">--%>
<%--</form>--%>



<br><br>
<h1 class="titulo">Editar Library</h1>
<form class="row g-3 formulario_1" action="./edit-library">
    <input type="hidden" id="libraryId" name="libraryId" value ="<%= request.getParameter("libraryId") %>">
    <div class="mb-3">
        <label for="Lname" class="form-label"> Library Name </label>
        <input type="text" id="Lname" name="Lname" class="form-control"  placeholder=" Library Name">
    </div>
    <div class="col-md-12">
        <input class="btn" type="submit" value="Edit Library!"></input>
    </div>
</form>


</body>
</html>

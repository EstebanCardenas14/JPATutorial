
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="./CSS/css.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <title>JPA Tutorial</title>
</head>
<body>

<%--<form action="./edit-Book">--%>

<%--  <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">--%>
<%--  <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">--%>

<%--  Book title: <input type="text" id="title" name="title">--%>
<%--  <br />--%>
<%--  Book ISBN: <input type="text" id="isbn" name="isbn">--%>
<%--  <br />--%>
<%--  Book Genre: <input type="text" id="genre" name="genre">--%>
<%--  <br />--%>
<%--  <input type="submit" value="Edit book!">--%>
<%--</form>--%>


<br><br>
<h1 class="titulo">Editar libro</h1>
<form class="row g-3 formulario_1" action="./edit-Book">

  <input type="hidden" id="bookId" name="bookId" value ="<%= request.getParameter("bookId") %>">
  <input type="hidden" id="authorId" name="authorId" value ="<%= request.getParameter("authorId") %>">
  <div class="mb-3">
    <label for="title" class="form-label">Book title</label>
    <input type="text" id="title" name="title" class="form-control" placeholder="Book title">
  </div>
  <div class="mb-3">
    <label for="isbn" class="form-label"> Book ISBN </label>
    <input type="text" id="isbn" name="isbn" class="form-control"  placeholder="Book ISBN">
  </div>

  <div class="mb-3">
  <label for="genre" class="form-label"> Book Genre </label>
  <input type="text" id="genre" name="genre"class="form-control"  placeholder="Book Genre">
</div>

  <div class="col-md-12">
    <input class="btn" type="submit" value="Edit book!">Editar libro</input>
  </div>
</form>


</body>
</html>

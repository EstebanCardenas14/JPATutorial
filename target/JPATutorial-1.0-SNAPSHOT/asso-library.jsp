<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./CSS/css.css">
    <title>JPA Tutorial</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<br><br><br>
<h1>View of edition Book ></h1>
<p class="subtitulo">Grupo : Syntax Error</p>
<br><br><br>
<div class="containerTablas">
<table id="editionBookTbl">
    <thead>
    <tr>
        <th>Id</th>
        <th>Description</th>
        <th>Release_Year</th>
        <th>book_id</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<script>
    function printTable(elementId, servlet, columns, actions = []) {
        console.log()
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);
                var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];
                data.map(d => {
                    //Este if se encarga de verificar que las ediciones al libro
                    if ((<%= request.getParameter("bookID") %>) == d['book_id']) {
                        var newRow = tbodyRef.insertRow();
                        columns.map(c => {
                            var cell = newRow.insertCell();
                            var text = document.createTextNode(d[c]);
                            cell.appendChild(text);
                        });
                        if (actions.includes('delete-edition')) {
                            var cell = newRow.insertCell();
                            var action = document.createElement('button');
                            action.setAttribute('onclick', 'location.href="./delete-edition?edition_id=' + d['edition_Id'] + '";');
                            var text = document.createTextNode('Delete edition');
                            action.appendChild(text);
                            cell.appendChild(action);
                        }
                    }
                    if ((<%= request.getParameter("assosingLibIntro") %>) == true) {
                        var newRow = tbodyRef.insertRow();
                        columns.map(c => {
                            var cell = newRow.insertCell();
                            var text = document.createTextNode(d[c]);
                            cell.appendChild(text);
                        });
                        if(actions.includes('associate')){
                            var cell = newRow.insertCell();
                            var action = document.createElement('button');
                            var libraryID = (<%= request.getParameter("libraryId") %>);
                            action.onclick = function() {
                                alert("Libro asociado a la librería.");
                                location.href='./assos-edition?edition_id=' + d['edition_Id']+'&libraryId=' + libraryID;
                            };
                            var text = document.createTextNode('asociar');
                            action.appendChild(text);
                            cell.appendChild(action);
                        }
                    }
                    if ((<%= request.getParameter("aso") %>) == true) {
                        var newRow = tbodyRef.insertRow();
                        columns.map(c => {
                            var cell = newRow.insertCell();
                            var text = document.createTextNode(d[c]);
                            cell.appendChild(text);
                        });
                        if(actions.includes('disassociate')){
                            var cell = newRow.insertCell();
                            var action = document.createElement('button');
                            var libraryID = (<%= request.getParameter("libraryId") %>);
                            action.onclick = function() {
                                alert("Libro desasociado de la librería.");
                                location.href='./TERCERO-edition?edition_id=' + d['edition_Id'] +'&libraryId=' + libraryID;
                            };
                            var text = document.createTextNode('desasociar');
                            action.appendChild(text);
                            cell.appendChild(action);
                        }
                    }

                });
            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);
    }
    printTable(elementId = 'editionBookTbl', servlet = 'list-edition', columns = ['edition_Id','description', 'release_year', 'book_id'], actions = ['delete-edition','associate','disassociate']);
</script>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h3>View of edition book</h3>
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
                        console.log(d['edition_Id'])
                        var newRow = tbodyRef.insertRow();
                        columns.map(c => {
                            var cell = newRow.insertCell();
                            var text = document.createTextNode(d[c]);
                            cell.appendChild(text);
                        });
                        if (actions.includes('delete-edition')) {
                            var cell = newRow.insertCell();
                            var action = document.createElement('button');
                            console.log(d['edition_Id'])
                            action.setAttribute('onclick', 'location.href="./delete-edition?edition_id=' + d['edition_Id'] + '";');
                            var text = document.createTextNode('Delete book');
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
                            action.setAttribute('onclick', 'location.href="./assos-edition?edition_id=' + d['edition_Id'] + '";');
                            var text = document.createTextNode('segundo');
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
                            action.setAttribute('onclick', 'location.href="./TERCERO-edition?edition_id=' + d['edition_Id'] + '";');
                            var text = document.createTextNode('tercero');
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
</body>
</html>

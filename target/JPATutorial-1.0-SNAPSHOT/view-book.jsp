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
<h3>View of Book</h3>
<table id="viewBookTbl">
    <thead>
    <tr>
        <th>Id</th>
        <th>Genre</th>
        <th>ISBN</th>
        <th>title</th>
        <th>author_id</th>
        <th>acciones</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<h3>View of edition book</h3>
<table id="editionBookTbl">
    <thead>
    <tr>
        <th>Title</th>
        <th>ISBN</th>
        <th>Genre</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<script>

    function printTable(elementId, servlet, columns, actions = []) {

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);
                var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];
                data.map(d => {
                    var newRow = tbodyRef.insertRow();

                    columns.map(c => {
                        var cell = newRow.insertCell();
                        var text = document.createTextNode(d[c]);
                        cell.appendChild(text);
                    });

                    if (actions.includes('edition-book')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('Create book');
                        action.appendChild(text);
                        cell.appendChild(action);

                    }


                })
            }
        }
    }
    printTable(elementId = 'viewBookTbl', servlet = 'list-viewBooks', columns = ['bookId', 'genre','isbn_number','title','author_id'], actions = ['edition-book','delete-book']);

</script>
</body>
</html>

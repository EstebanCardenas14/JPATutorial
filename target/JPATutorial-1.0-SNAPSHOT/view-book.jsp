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
        <th>title</th>
        <th>ISBN</th>
        <th>author_id</th>
        <th>Genre</th>
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
        <th>Description</th>
        <th>Relase_Year</th>
        <th>book_id</th>
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
                    //Este if se encarga de verificar que los libros corresponden al autor
                    if ((<%= request.getParameter("authorId") %>) == d['author_id']) {
                        var newRow = tbodyRef.insertRow();
                        columns.map(c => {
                            var cell = newRow.insertCell();
                            var text = document.createTextNode(d[c]);
                            cell.appendChild(text);

                        });
                        if (actions.includes('edition-book')) {
                            var cell = newRow.insertCell();
                            var action = document.createElement('button');
                            action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['author-id'] + '";');
                            var text = document.createTextNode('Edition book');
                            action.appendChild(text);
                            cell.appendChild(action);

                        }

                        if (actions.includes('edit-book')) {
                            var cell = newRow.insertCell();
                            var action = document.createElement('button');
                            action.setAttribute('onclick', 'location.href="./edit-book.jsp?bookId=' + d['book_id']+'&authorId=' + d['author_id']+'";');
                            var text = document.createTextNode('Edit book');
                            action.appendChild(text);
                            cell.appendChild(action);
                        }

                        if (actions.includes('delete-book')) {
                            var cell = newRow.insertCell();
                            var action = document.createElement('button');
                            action.setAttribute('onclick', 'location.href="./delete-book?bookId=' + d['book_id'] + '";');
                            var text = document.createTextNode('Delete book');
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

    printTable(elementId = 'viewBookTbl', servlet = 'list-viewBooks', columns = ['book_id', 'title', 'isbn_number', 'author_id', 'genre'], actions = ['edition-book', 'delete-book', 'edit-book']);

    printTable(elementId = 'editionBookTbl', servlet = 'list-edition', columns = ['Description', 'Relase_Year', 'book_id'], actions = []);

</script>
</body>
</html>

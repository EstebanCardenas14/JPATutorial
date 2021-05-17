<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>JSP Tutorial</title>

        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>

        <h1>Library Manager</h1>

        <button onclick="location.href='./form-library.jsp';">Create library</button>
        <button onclick="location.href='./form-author.jsp';">Create author</button>
        <button onclick="location.href='./form-customer.jsp';">Create customer</button>

        <h3>Libraries</h3>

        <table id="librariesTbl">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

        <h3>Authors</h3>

        <table id="authorsTbl">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Country</th>
                <th># Books</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <h3>Customers</h3>

        <table id="customersTbl">
            <thead>
            <tr>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <script>

            function printTable(elementId, servlet, columns, actions = []) {

                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function() {
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

                            if (actions.includes('create-book')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Create book');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                            if (actions.includes('delete-author')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Delete author');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }
                            if (actions.includes('delete-customer')) {
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./delete-customer?email=' + d['email'] + '";');
                                var text = document.createTextNode('Delete customer');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }
                            if (actions.includes('edit-author')){
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./edit-author.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Edit author');
                                action.appendChild(text);
                                cell.appendChild(action);
                            }
<<<<<<< HEAD
                            if (actions.includes('view-books')){
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./form-viewbook.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Edit author');
=======
                            if (actions.includes('edit-book')){
                                var cell = newRow.insertCell();
                                var action = document.createElement('button');
                                action.setAttribute('onclick', 'location.href="./edit-book.jsp?authorId=' + d['authorId'] + '";');
                                var text = document.createTextNode('Edit book');
>>>>>>> 34ae7cdcacafc2b67bfdeee6242380bd661fb84e
                                action.appendChild(text);
                                cell.appendChild(action);
                            }

                        });

                    }
                }
                xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
                xhr.send(null);

            }

            // Printing libraries
            printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name'], actions = ['delete-library', 'edit-library']);

            // Printing authors
<<<<<<< HEAD
            printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId', 'name', 'country', 'numBooks'], actions = ['create-book','edit-author' ,'delete-author','View Books']);
=======
            printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId', 'name', 'country', 'numBooks'], actions = ['create-book','edit-author' ,'delete-author','edit-book']);
>>>>>>> 34ae7cdcacafc2b67bfdeee6242380bd661fb84e

            // Printing customer
            printTable(elementId = 'customersTbl', servlet = 'list-customers', columns = ['email', 'first_name', 'last_name', 'gender','age'], actions = ['create-rent','edit-customer' ,'delete-customer']);

        </script>

    </body>
</html>
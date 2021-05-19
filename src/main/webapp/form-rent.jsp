<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="./create-Rent">
    <input type="hidden" id="email" name="email" value ="<%= request.getParameter("email") %>">
    Choose your Book to rent: <select name="books_view" id="books_view">
    <option></option>
</select>
    <input type="submit" value="Create Rent!">
</form>
<script>
    function printTable(elementId, servlet, columns, actions = []) {

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);
                console.log(data)
                var tbodyRef = document.getElementById(elementId).getElementsByTagName('option')[0];
                data.map(d => {
                    var newRow = tbodyRef.insertAdjacentHTML(d,data.get(0))
                    columns.map(c => {
                        var cell = newRow.insertCell();
                        var text = document.createTextNode(d[c]);
                        cell.appendChild(text);
                    });
                });
            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);
    }
</script>
</body>
</html>
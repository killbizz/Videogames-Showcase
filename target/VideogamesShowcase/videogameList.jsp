<!DOCTYPE html>
<%@ page import ="java.util.*" %>
<%@ page import ="com.example.model.Videogame" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Videogames Catalog</title>
        <link rel="stylesheet" href="./style.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="pb-4">Videogames Catalog</h1>
        <table class="table pb-4">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Price</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                    <c:forEach items="${videogames}" var="entry">
                        <tr>
                            <td>${entry.value.getId()}</td>
                            <td>${entry.value.getName()}</td>
                            <td>${entry.value.getDescription()}</td>
                            <td>${entry.value.getPrice()}&euro;</td>
                        </tr>
                    </c:forEach>
                </tbody>
        </table>
        <br />
        <h3 class="pb-4">Click <a href="index.jsp">HERE</a> to visit the homepage</h3>
    </body>
</html>

<!DOCTYPE html>
<%@ page import ="java.util.*" %>
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
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    <%
                        //iterazione dell'attributo Map<Videogames> passato dalla Servlet
                    %>
                </tbody>
        </table>
        <br />
        <h3 class="pb-4">Click <a href="index.jsp">HERE</a> to visit the homepage</h3>
    </body>
</html>

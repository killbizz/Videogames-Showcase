<html>
    <head>
        <title>Videogames Showcase</title>
        <link rel="stylesheet" href="./style.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="pb-4">Welcome to the Videogames Showcase</h1>
        <h3 class="pb-4">Click <a href="Catalog" >HERE</a> to visit the catalog</h3>
        <br />
        <h3 class="pb-4">Insert a new videogame</h3>
        <form class="form-inline d-flex justify-content-center" method="post" action="InsertVideogameServlet" accept-charset=utf-8>
            <label class="sr-only" for="Name">Name</label>
            <input type="text" class="form-control mb-2 mr-sm-2" id="Name" name="Name" placeholder="Name">
            <label class="sr-only" for="Description">Description</label>
            <input type="textarea" class="form-control mb-2 mr-sm-2" id="Description" name="Description" placeholder="Description">
            <label class="sr-only" for="InputGroupPrice">Price</label>
            <div class="input-group mb-2 mr-sm-2">
              <div class="input-group-prepend">
                <div class="input-group-text">&euro;</div>
              </div>
              <input type="text" class="form-control" id="Price" name="Price" placeholder="Price">
            </div>
            <button type="submit" class="btn btn-primary mb-2">Submit</button>
        </form>
        <%
        if(request.getAttribute("VideogameInserted") != null){
            boolean flag = (boolean) request.getAttribute("VideogameInserted");
            if(flag == true) {
        %>
        <div class="alert alert-success text-center" role="alert">
            Item created correctly!
        </div>
        <% }
        %>

        <%
            if(flag == false) {
        %>
        <div class="alert alert-danger text-center" role="alert">
            Failed creating the new item, please retry!
        </div>
        <% }}
        %>
    </body>
</html>

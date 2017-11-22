<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
  </head>
 
    <body>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="../webObserver/inicio.asp">WebObserver</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
        
        
    <div class="container" style="margin-top: 90px;">
        <div class="row">
          <div class="col-sm-6">
            <div class="card">
              <div class="card-body">
                <h4 class="card-title">Administrar Sitios</h4>
                <p class="card-text">Todo lo necesario para administrar Sitios.</p>
                <a href="../overcomandant/addSitio.asp" class="btn btn-primary">Agregar Sitio</a>
                <a href="../overcomandant/listSitioAdmin.asp" class="btn btn-primary">Lista de Sitios</a>
              </div>
            </div>
          </div>
          <div class="col-sm-6">
            <div class="card">
              <div class="card-body">
                <h4 class="card-title">Administrar Usuarios</h4>
                <p class="card-text">Todo lo necesario para administrar Usuarios</p>
                <a href="../overcomandant/listUsuarioAdmin.asp" class="btn btn-primary">Lista de Usuarios</a>
                <a href="../overcomandant/addUsuario.asp" class="btn btn-primary">Agregar Usuario</a>
              </div>
            </div>
          </div>
        </div>
    </div>
        
        
        
        <!--
        <a href="../overcomandant/addSitio.asp">Agregar sitio</a>
        <a href="../overcomandant/listSitioAdmin.asp">Lista de sitios</a>
        <a href="#">Lista de usuarios</a>
        <a href="../overcomandant/addUsuario.asp">Agregar usuario</a>
        -->
        
         <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        
    </body>
</html>

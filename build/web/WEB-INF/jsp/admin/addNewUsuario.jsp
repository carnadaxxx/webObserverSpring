<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
      <a class="navbar-brand" href="../overcomandant/dashboard.asp">WebObserver.pe</a>
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

        <div class="card">
            
            <div class="card-header">
                Formulario de Ingreso de Usuarios
            </div>
            
            
            <div class="card-body">
                
                
                <form:form action="addUsuario.asp" method="POST" commandName="usuario">
                    
                    <form:errors path="*" element="div" cssClass="alert alert-danger" />
                       
                    <div class="form-group">
                    <form:label path="nombres">Nombres</form:label>
                    <form:input path="nombres" cssClass="form-control"/>
                    <form:errors path="nombres" element="div" cssClass="text-danger" />
                    </div>
                    
                    <div class="form-group">
                    <form:label path="apellidos">apellidos</form:label>
                    <form:input path="apellidos" cssClass="form-control"/>
                    <form:errors path="apellidos" element="div" cssClass="text-danger" />
                    </div>
                    
                    <div class="form-group">
                    <form:label path="email">email</form:label>
                    <form:input path="email" cssClass="form-control"/> 
                    <form:errors path="email" element="div" cssClass="text-danger" />
                    </div>
                    
                    <div class="form-group">
                    <form:label path="username">Nombre de Usuario</form:label>
                    <form:input path="username" cssClass="form-control"/>
                    <form:errors path="username" element="div" cssClass="text-danger" />
                    </div>
                    
                    <div class="form-group">
                    <form:label path="password">Contraseña</form:label>
                    <form:password path="password" cssClass="form-control"/>
                    <form:errors path="password" element="div" cssClass="text-danger" />
                    </div>
                    

                    <input type="submit" value="Enviar" class="btn btn-primary" />
                    <a href="../overcomandant/dashboard.asp">Cancelar</a>
                    
                </form:form>
                
          
            </div>
            
        </div>
           
          

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>
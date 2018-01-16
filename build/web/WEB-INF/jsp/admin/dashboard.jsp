<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/admin-header.jsp" />
                
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
               
<jsp:include page="includes/admin-footer.jsp" />        

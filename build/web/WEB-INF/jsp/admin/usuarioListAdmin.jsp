<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/admin-header.jsp" />

      <div class="container" style="margin-top: 90px;">

      <div class="starter-template">
        <h1>Lista de Usuarios</h1>
      </div>
          
          <a href="../overcomandant/addUsuario.asp">Crear Usuario nuevo</a>
          
          <div class ="card">
              
              <div class="card-header">Testing</div>
              <div class="card-body">
                  <table class="table">
                    <thead>
                      <tr>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Email</th>
                      </tr>
                    </thead>
                    <tbody>
                        
                        <c:forEach items="${datos}" var="dato">                            
                            
                            <tr>
                                <th scope="row"><c:out value="${dato.idusuario}"/></th>
                                <td><c:out value="${dato.nombres}"></c:out></td>
                                <td><c:out value="${dato.apellidos}"></c:out></td>
                                <td><c:out value="${dato.email}"></c:out></td>
                              </tr>              
                            
                        </c:forEach>
                    </tbody>
                  </table>
              </div>
          </div> 

 <jsp:include page="includes/admin-footer.jsp" />         

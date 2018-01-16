<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/admin-header.jsp" />

      <div class="container" style="margin-top: 90px;">

      <div class="starter-template">
        <h1>Lista de Paginas</h1>
      </div>
          
          <a href="../overcomandant/addSitio.asp">Crear sitio nuevo manulamente</a>
          
          <div class ="card">
              
              <div class="card-header">Testing</div>
              <div class="card-body">
                  <table class="table">
                    <thead>
                      <tr>
                        <th>#</th>
                        <th>Sitio</th>
                        <th>Nombre</th>
                        <th>Editar</th>
                      </tr>
                    </thead>
                    <tbody>
                        
                        <c:forEach items="${datos}" var="dato">                            
                            
                            <tr>
                                <th scope="row"><c:out value="${dato.idsitio}"/></th>
                                <td><c:out value="${dato.url}"></c:out></td>
                                <td><c:out value="${dato.nombre}"></c:out></td>
                                
                                <td>
                                    <a href="<c:url value="editSitio.asp?idsitio=${dato.idsitio}"/>" >editar</a> /
                                    <a href="<c:url value="sitio/eliminar.jsp?idsitio=${dato.idsitio}"/>" >eliminar</a>
                                </td>
                              </tr>              
                            
                        </c:forEach>
                    </tbody>
                    
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <c:forEach var = "i" begin = "1" end = "${t}">
                                    <li class="page-item"><a class="page-link" href="listSitioAdmin.asp?pagina=${i}">${i}</a></li>
                                </c:forEach>
                            </ul>
                        </nav>
                  </table>
              </div>
          </div> 

    </div><!-- /.container -->


<jsp:include page="includes/admin-footer.jsp" />

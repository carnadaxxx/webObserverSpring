<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/public-header.jsp" />


<div class="container" style="margin-top: 90px;">

    <div class="starter-template">
        <h1><c:out value="${sitio.nombre}" /><small> </small></h1>
        <p class="lead">${sitio.url}</p>
    </div>

    <div class ="card">

        <div class="card-header">Muestras</div>
        <div class="card-body">
            <c:choose>
                
            <c:when test="${ not empty hstry }">    
            <table class="table table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th>Fecha</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                    <c:forEach items="${hstry}" var="hstry">  

                        <tr>    
                            <td><c:out value="${hstry.fecha}"></c:out></td>
                            <td>                                
                                <c:choose>
                                  <c:when test = "${hstry.estado == 200}">
                                     <p class="text-success">Activo</p> 
                                  </c:when>
                                  <c:when test = "${hstry.estado == 404}">
                                     <p class="text-danger">Inactivo</p>
                                  </c:when>
                               </c:choose>
                            </td>
                        </tr>             

                    </c:forEach>
                
                </tbody>
            </table>
            </c:when>
            
            <c:otherwise>        
                <div class="alert alert-warning" role="alert">
                    Ups! No hay eventos registrados....
                </div>
            </c:otherwise> 
            
            </c:choose>
        </div>
    </div> 

</div><!-- /.container -->

<jsp:include page="includes/public-footer.jsp" />
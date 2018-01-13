<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/public-header.jsp" />

<div class="container" style="margin-top: 90px;">
    

    <div class ="card">

        <div class="card-header">Lista de sitios</div>
        <div class="card-body">

            <c:choose>

                <c:when test="${ not empty datos }">

                    
                    <table class="table table-bordered">
                        <thead class="thead-light">
                            <tr>
                                <th>#</th>
                                <th>Sitio</th>
                                <th>Nombre</th>
                                <th>Detalle</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${datos}" var="dato">  

                                <tr>
                                    <td><c:out value="${dato.idsitio}"></c:out></td>    
                                    <td><c:out value="${dato.url}"></c:out></td>
                                    <td><c:out value="${dato.nombre}"></c:out></td>
                                    <td><a href="<c:url value="detalleiStio.asp?idsitio=${dato.idsitio}"/>" >Ver Estado</a></td>
                                </tr>             

                            </c:forEach>

                        </tbody>
                        

                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <c:forEach var = "i" begin = "1" end = "${t}">
                                    <li class="page-item"><a class="page-link" href="inicio.asp?pagina=${i}">${i}</a></li>
                                </c:forEach>
                            </ul>
                        </nav>

                    </table>


                </c:when>         

                <c:otherwise>        
                    <div class="alert alert-warning" role="alert">
                        No hay sitios registrados....
                    </div>
                </c:otherwise>
            </c:choose>   



        </div>
    </div> 

</div><!-- /.container -->

<jsp:include page="includes/public-footer.jsp" />

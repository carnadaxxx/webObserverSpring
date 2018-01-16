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
            <table class="table table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th>#</th>
                        <th>Estado</th>
                        <th>Fecha</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>

                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>

                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Larry</td>
                        <td>the Bird</td>

                    </tr>
                </tbody>
            </table>
        </div>
    </div> 

</div><!-- /.container -->

<jsp:include page="includes/public-footer.jsp" />
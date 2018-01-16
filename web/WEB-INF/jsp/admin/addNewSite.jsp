<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="includes/admin-header.jsp" />

    <div class="container" style="margin-top: 90px;">

        <div class="card">
            
            <div class="card-header">
                Formulario de Ingreso de Sitios por Unidad / Editar
            </div>
            
            
            <div class="card-body">
                
                
                <form:form method="POST" commandName="sitio">
                    
                    <form:errors path="*" element="div" cssClass="alert alert-danger" />                   
                    
                    <div class="form-group">
                    <form:label path="url">URL</form:label>
                    <form:input path="url" cssClass="form-control"/>
                    <form:errors path="url" element="div" cssClass="text-danger" />
                    </div>
                    
                    <div class="form-group">
                    <form:label path="nombre">Nombre</form:label>
                    <form:input path="nombre" cssClass="form-control"/>
                    <form:errors path="nombre" element="div" cssClass="text-danger" />        
                    </div>
                                       
                    <input type="submit" value="Enviar" class="btn btn-primary" />
                    <a href="../overcomandant/dashboard.asp">Cancelar</a>
                    
                </form:form>
                
          
            </div>
            
        </div>
           
<jsp:include page="includes/admin-footer.jsp" />        


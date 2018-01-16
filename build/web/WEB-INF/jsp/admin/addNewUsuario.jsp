<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="includes/admin-header.jsp" />

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

 <jsp:include page="includes/admin-footer.jsp" />   
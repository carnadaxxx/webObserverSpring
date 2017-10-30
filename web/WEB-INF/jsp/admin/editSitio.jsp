<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
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
                    
                    <div class="form-group">
                    <form:label path="estado">Estado</form:label>
                    <form:select path="estado" cssClass="form-control">
                        <form:option value="0">Seleccione</form:option>
                        <form:options items="${estadoLista}" />
                    </form:select>
                    <form:errors path="estado" element="div" cssClass="text-danger" />
                    </div>
                    
                    <input type="submit" value="Enviar" class="btn btn-primary" />
                    <a href="../overcomandant/dashboard.asp">Cancelar</a>
                    
                </form:form>
    </body>
</html>

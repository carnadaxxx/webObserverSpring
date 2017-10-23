<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <p><c:out value="${url}"></c:out></p>
        <p><c:out value="${nombre}"></c:out></p>
        <p><c:out value="${estado}"></c:out></p>
              
         <a href="../overcomandant/addSitio.asp">Agregar sitio</a>
         <a href="../overcomandant/dashboard.asp" >inicio</a>
        
    </body> 
</html>

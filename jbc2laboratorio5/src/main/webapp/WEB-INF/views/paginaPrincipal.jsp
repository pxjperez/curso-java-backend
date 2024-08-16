<%-- 
    Document   : paginaPrincipal
    Created on : 20 abr. 2024, 18:14:21
    Author     : jpere
--%>

<%@page import="java.util.List"%>
<%@page import="edu.cibertec.entity.UsuarioEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal</title>
        <link rel="stylesheet" href="static/estilos.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <h1>Bienvenido ${usuario}</h1>
            <h2><%=application.getContextPath()%></h2>
            <h2><%=request.getMethod()%></h2>
            <%--<a href="mantenimientoUsuarios?usuario=${usuario}">Mantenimiento Usuarios</a>--%>
            <a href="mantenimientoUsuarios">Mantenimiento Usuarios</a>
            <br><a href="mantenimientoPersonas">Mantenimiento Personas</a>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>

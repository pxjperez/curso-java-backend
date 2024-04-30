<%-- 
    Document   : index
    Created on : 18 mar. 2024, 22:11:38
    Author     : jpere
--%>

<%@page import="edu.cibertec.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido ${usuario.user}</h1>
        <h2>Bienvenido <%=((Usuario) session.getAttribute("usuario")).getNombreCompleto() %></h2>
        <a href="mantenimientoUsuario">MANTENIMIENTO USUARIOS</a>
    </body>
</html>

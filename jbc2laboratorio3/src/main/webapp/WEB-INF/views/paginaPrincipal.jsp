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
        <title>JSP Page</title>
        <link rel="stylesheet" href="static/estilos.css"/>
    </head>
    <body>
        
        <table class="tabla">
            <thead>
                <tr>
                    <th>USER</th>
                    <th>PASSWORD</th>
                    <th>NOMBRE COMPLETO</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <%  
                    List<UsuarioEntity>listaUsuario = (List<UsuarioEntity>)request.getAttribute("listaUsuarios"); 
                   for(UsuarioEntity u: listaUsuario){
                %>
                <tr>
                    <td><%=u.getUser() %></td>
                    <td><%=u.getPassword()%></td>
                    <td><%=u.getNombreApellido()%></td>
                    <td><a>A</a><a href="eliminarUsuario?idUsuario=<%=u.getIdUsuario()%>">E</a></td>
                </tr>
                <%} %>
            </tbody>
        </table>
    </body>
</html>

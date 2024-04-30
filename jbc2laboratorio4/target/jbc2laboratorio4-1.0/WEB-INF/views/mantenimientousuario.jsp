<%-- 
    Document   : mantenimientousuario
    Created on : 20 mar. 2024, 20:33:42
    Author     : jpere
--%>

<%@page import="edu.cibertec.bean.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mantenimiento Usuario</h1>
        <table  border="1">
            <thead>
                <tr>
                    <th>Nombre Completo</th>
                    <th>User</th>
                    <th>Password</th>
                    <th>Aciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                   List<Usuario> listaUsuario = (List<Usuario>)request.getAttribute("listaUsuarios");                   
                %>
                <% 
                   for(Usuario usuario:listaUsuario){
                %>
                <tr>
                    <td><%=usuario.getNombreCompleto()%></td>
                    <td><%=usuario.getUser()%></td>
                    <td><%=usuario.getPassword()%></td>
                    <td><a href="eliminarUsuario?idUsuario=<%=usuario.getIdUsuario()%>" >E</a> - <a href="editarUsuario?idUsuario=<%=usuario.getIdUsuario()%>" >A</a></td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
            <br><label style="color: red">${msgError}</label>
            <br><a href="crearUsuario" >Crear Usuario</a>   
    </body>
</html>

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
        <title>Mantenimiento Usuario</title>
        <link rel="stylesheet" href="static/estilos.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    </head>
    <body>        
        <div class="container-fluid">
            <div class="row">
                <div class="col-10 mx-auto">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr class="table-dark">
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
                                <td><%=u.getNombreCompleto()%></td>
                                <td><a class="btn btn-warning" ><i class="bi bi-arrow-clockwise"></i></a><a class="btn btn-danger" href="eliminarUsuario?idUsuario=<%=u.getIdUsuario()%>"><i class="bi bi-trash"></i></a></td>
                            </tr>
                            <%} %>
                        </tbody>
                    </table>
                    <a class="btn btn-primary" href="formularioNuevoUsuario">Nuevo</a>
                    <%                                 
                            if(request.getAttribute("msgError")!=null){
                            %>
                            <div class="alert alert-danger" role="alert">						
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <center><label>${msgError}</label></center>
                                    <br>
                            </div>
                    <%}%>
                </div>        
            </div>
        </div>    
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    
</html>

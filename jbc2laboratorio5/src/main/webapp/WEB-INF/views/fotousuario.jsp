<%-- 
    Document   : fotousuario
    Created on : 22 mar. 2024, 20:22:09
    Author     : jpere
--%>

<%@page import="java.util.Base64"%>
<%@page import="edu.cibertec.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Foto del usuario ${usuario.nombreCompleto}</h1>
        <%
            if(request.getAttribute("usuario")!=null){
                Usuario usuario = (Usuario)request.getAttribute("usuario");
                if(usuario.getFoto()!=null){
        %>
                    <img src="data:image/jpeg;base64,<%=Base64.getEncoder().encodeToString(usuario.getFoto())%>">
        <%
                }else{
        %>
                    <h3>Usuario sin foto</h3>
        <%
                }
            }
        %>
    </body>
</html>

<%-- 
    Document   : crearusuario
    Created on : 20 mar. 2024, 20:51:12
    Author     : jpere
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ACTUALIZAR USUARIO</title>
    </head>
    <body>
        <h1>EDITAR USUARIO</h1>
        <mvc:form modelAttribute="usuario" action="actualizarUsuario"  enctype="multipart/form-data">
            <table>
                <tr>
                    <td>
                        <mvc:label path="user">User: </mvc:label>
                    </td>
                    <td>
                        <mvc:input path="user"/>
                        <mvc:hidden path="idUsuario"  />
                    </td>
                    <td>
                        <label style="color: red"><mvc:errors path="user"/></label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <mvc:label path="password">Passwod: </mvc:label>
                    </td>
                    <td>
                        <mvc:input path="password"/>
                    </td>
                    <td>
                        <label style="color: red"><mvc:errors path="password"/></label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <mvc:label path="nombreCompleto">Nombre Completo:</mvc:label>
                    </td>
                    <td>
                        <mvc:input path="nombreCompleto"/>
                    </td>
                    <td>
                        <label style="color: red"><mvc:errors path="nombreCompleto"/></label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Foto:</label>
                    </td>
                    <td>
                        <input type="file" name="archivo">
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2"> <input type="submit" value="ACTUALIZAR"/> </td>                   
                </tr>
                <tr>
                    <td colspan="2" >
                        <label style="color: red"> ${msgError}</label>
                    </td>
                </tr>
            </table>            
        </mvc:form>
        
    </body>
</html>

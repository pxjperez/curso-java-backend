<%-- 
    Document   : formularioNuevoUsuario
    Created on : 27 abr. 2024, 18:30:29
    Author     : jpere
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <style type="text/css">
            .fromFieldError{background-color: lightcoral;}
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-4 mx-auto">
                    <mvc:form cssClass="form-control" action="grabarUsuario" modelAttribute="usuarioBean">
                        <fieldset>
                            <table>
                                <tr>
                                    <td><mvc:label path="user" cssClass="form-label">Usuario:</mvc:label></td>
                                    <td>
                                        <mvc:input path="user" cssErrorClass="form-control fromFieldError" cssClass="form-control"  />
                                        <mvc:errors path="user" cssStyle="color:red"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><mvc:label path="password" cssClass="form-label">Clave:</mvc:label></td>
                                    <td>
                                        <mvc:input path="password" cssErrorClass="form-control fromFieldError" cssClass="form-control" />
                                        <mvc:errors path="password" cssStyle="color:red"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><mvc:label path="nombreCompleto" cssClass="form-label">Nombre Completo:</mvc:label></td>
                                    <td>
                                        <mvc:input path="nombreCompleto" cssErrorClass="form-control fromFieldError" cssClass="form-control" />
                                        <mvc:errors path="nombreCompleto" cssStyle="color:red"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" class="text-center">
                                        <input type="submit" value="GRABAR" class="btn btn-dark"/>
                                        <a class="btn btn-light" href="mantenimientoUsuarios">REGRESAR</a>
                                    </td>
                                </tr>
                            </table>
                            <div>
                                <label>${msgError}</label>
                            </div>
                        </fieldset>
                    </mvc:form>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>

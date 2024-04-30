<%-- 
    Document   : login
    Created on : 18 mar. 2024, 21:54:44
    Author     : jpere
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGIN USUARIO</h1>
        <form action="logear" method="post">
            <label>Usuario:</label> <input type="text" name="user"><br>
            <label>Password:</label> <input type="password" name="password"><br>
            <input type="submit" value="INGRESAR"><br>
            <label style="color: red">
            <%
               if(request.getAttribute("msgError")!=null){
                  out.print(request.getAttribute("msgError"));
                }
            %>
            </label>
        </form>
    </body>
</html>

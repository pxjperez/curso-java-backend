<%-- 
    Document   : login
    Created on : 20 abr. 2024, 17:58:48
    Author     : jpere
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
            <title>LOGIN</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="icon" type="image/png" href="static/images/icons/favicon.ico"/>
            <link rel="stylesheet" type="text/css" href="static/vendor/bootstrap/css/bootstrap.min.css">
            <link rel="stylesheet" type="text/css" href="static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" type="text/css" href="static/vendor/animate/animate.css">
            <link rel="stylesheet" type="text/css" href="static/vendor/css-hamburgers/hamburgers.min.css">
            <link rel="stylesheet" type="text/css" href="static/vendor/select2/select2.min.css">
            <link rel="stylesheet" type="text/css" href="static/css/util.css">
            <link rel="stylesheet" type="text/css" href="static/css/main.css">
    </head>
    <body>	
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-pic js-tilt" data-tilt>
                            <img src="static/images/img-01.png" alt="IMG">
                    </div>
                    <form class="login100-form validate-form"  action="accionLogin" method="post">
                            <span class="login100-form-title">
                                    LOGIN
                            </span>
                            <div class="wrap-input100 validate-input" data-validate = "El usuario es requerido">
                                    <input class="input100" type="text" name="user" placeholder="Usuario">
                                    <span class="focus-input100"></span>
                                    <span class="symbol-input100">
                                            <i class="fa fa-user" aria-hidden="true"></i>
                                    </span>
                            </div>

                            <div class="wrap-input100 validate-input" data-validate = "Password es requerido"">
                                    <input class="input100" type="password" name="password" placeholder="Password">
                                    <span class="focus-input100"></span>
                                    <span class="symbol-input100">
                                            <i class="fa fa-lock" aria-hidden="true"></i>
                                    </span>
                            </div>
                            <div class="container-login100-form-btn">
                                <input type="submit" value="Login"  class="login100-form-btn">
                            </div>
                            <br><br>
                            <%                                 
                            if(request.getAttribute("msgError")!=null){
                            %>
                            <div class="alert alert-danger" role="alert">						
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <center><label>${msgError}</label></center>
                                    <br>
                            </div>
                            <%}%>
                            <br><br><br>
                    </form>
                </div>
            </div>
        </div>
        <script src="static/vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="static/vendor/bootstrap/js/popper.js"></script>
        <script src="static/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="static/vendor/select2/select2.min.js"></script>
        <script src="static/vendor/tilt/tilt.jquery.min.js"></script>
        <script >
                $('.js-tilt').tilt({
                        scale: 1.1
                });
        </script>
        <script src="static/js/main.js"></script>
    </body>
</html>
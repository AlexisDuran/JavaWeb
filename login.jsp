<%-- 
    Document   : login
    Created on : 09-jul-2019, 12:41:59
    Author     : Equipo16

        SIASE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body style="background-color:powderblue;">
        <div style="text-align:center;" >
            <h1 style="font-size:50px;">Login</h1>
            
            <form action="${pageContext.request.contextPath}/loginControlador" method="post" >
                    <input class="input" type="text" name="user" placeholder="User..."><br>
                    <input class="input" type="Password" name="pass" placeholder="Password..."><br>
                    <select name="accion">
                        <option value="administrador">Administrador</option>
                        <option value="alumno">Alumno</option>
                        <option value="maestro">Maestro</option>
                    </select><br><br>
                    <input type="submit" class="button" onclick="alert('oli!')" value="Iniciar Sesion">
            </form>
        </div>
    </body>
</html>

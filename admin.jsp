<%-- 
    Document   : admin
    Created on : 09-jul-2019, 12:41:05
    Author     : Equipo16
--%>

<%@page import="Modelo.Alumno"%>
<%@page import="Modelo.Maestro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Siase/CSS/mystyle.css">
        <script>
            function mostrar(){document.getElementById('obj1').style.display  = 'block';}    
            function mostrar2(){document.getElementById('obj2').style.display  = 'block';}
                    function mostrar3(){document.getElementById('obj3').style.display  = 'inline-block';}
                    function mostrar4(){document.getElementById('obj4').style.display  = 'inline-block';}
        </script>
        <%--<script>
        function confirmar_envio(){
            if (confirm(‘Estas seguro de enviar los datos de este formulario?’))
                {document.frm_registro.submit()}}
        </script>--%>
       <%-- <script language=“JavaScript”>
            function validar_formulario(){
                var nombre = document.getElementsByName('nombre').value;
                var usuario = document.getElementsByName("usuario").value;
                var contraseña = document.getElementsByName("contraseña").value;
                var no_empleado = document.getElementsByName("no_empleado").value;
                var tipoEmpleadoId = document.getElementsByName("tipoEmpleadoId").value;
                var estatus = document.getElementsByName("estatus").value;
                var banderaRBTN = false;
                if(nombre == null || nombre.length == 0){
                    alert('ERROR: El campo nombre no debe ir vacío o lleno de solamente espacios en blanco');
                    return false;
                    }
            }
        </script>--%>
        <title>Administrador</title>
    </head>
    <body>
        
        <div class="header">
            <h1>Sistema Escolar</h1>
        </div>
        
        <div class="topnav">
            <a href="buscaAlumno.jsp">Buscar Alumno</a>
            <a href="buscaMaestro.jsp">Buscar Maestro</a>
            <a href="*">Salir</a>
        </div>
        
        
        <input type="button" class="button2" onclick="mostrar()" value="Alta Maestro"><br>
        
        <div id="obj1">
            <p>Ingresar datos de Maestro</p>
            <form id="insertarMaestro" name="insertarMaestro" action="${pageContext.request.contextPath}/adminControlador" method="post" >
                <input type="hidden" name="accion" value="insertarMaestro">
                <label>Nombre: </label><input class="input" type="text" name="nombre" placeholder="Nombre..."><br>
		<label>Usuario: </label><input type="text" name="usuario" placeholder="Usuario..."><br>
		<label>Contraseña: </label><input type="password" name="contraseña" placeholder="Contraseña.."><br>
                <label>N° de Empleado: </label><input type="text" name="no_empleado" placeholder=" (int) # Empleado..."><br>
		<label>Tipo de Empleado: </label><input type="text" name="tipoEmpleadoId" placeholder=" (int) Tipo..."><br>
		<label>Estatus: </label><input type="text" name="estatus" placeholder="(int)Estatus..."><br>
			
		<input type="submit" class="button2" onclick=”alert('Enviado')” value="Enviar">
                <input class="button2" type="reset" value="Reset">
            </form>
        </div><br><br>
        
        <input type="button" class="button2" onclick="mostrar2()" value="Alta Alumno"><br>
        
        <div id="obj2">
            <h2>Ingresar datos de Alumno</h2>
            <form id="insertarAlumno" name="insertarAlumno" action="${pageContext.request.contextPath}/adminControlador" method="post" >
                <input type="hidden" name="accion" value="insertarAlumno">
                <label>Nombre: </label><input class="input" type="text" name="nombre" placeholder="Nombre..."><br>
		<label>Usuario: </label><input type="text" name="usuario" placeholder="Usuario..."><br>
		<label>Contraseña: </label><input type="password" name="contraseña" placeholder="Contraseña.."><br>
                <label>Matricula: </label><input type="text" name="matricula" placeholder="Matricula..."><br>
                <label>Estatus: </label><input type="text" name="estatus" placeholder="Estatus..."><br>
                
                <input type="submit" class="button2" onclick=”alert('Enviado')” value="Enviar">
                <input class="button2" type="reset" value="Reset">
            </form>
        </div><br>
        
        <form action="${pageContext.request.contextPath}/adminControlador" method="post" >
            <input type="hidden" name="accion" value="obtenerMaestro">
            <input type="submit" class="button2" value="Obtener Maestros">
        </form>
    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Usuario</th>
                <th>Contraseña</th>
                <th>N° Empleado</th>
                <th>Tipo de Empleado</th>
                <th>Estatus</th>
                <th></th>
                <th></th>
            </tr>
        <%
                List maestros = (List) session.getAttribute("maestro");
                if(maestros != null){
        %>
        <%
            for (Object o : maestros){
                Maestro maestro = (Maestro) o;
        %>
            <tr>
                <td><%= maestro.getId() %></td>
                <td><%= maestro.getNombre() %></td>
                <td><%= maestro.getUsuario() %></td>
                <td><%= maestro.getContraseña() %></td>
                <td><%= maestro.getNo_empleado() %></td>
                <td><%= maestro.getTipoEmpleadoId() %></td>
                <td><%= maestro.getEstatus()%></td>
                <td></td>
                <td></td>
            </tr>
            <%}%>
            <%}else {%>
            
            <%}%>
        </table>
        </div>
        
        
        <form action="${pageContext.request.contextPath}/adminControlador" method="post" >
            <input type="hidden" name="accion" value="obtenerAlumno">
            <input type="submit" class="button2" value="Obtener Alumnos">
        </form>
            <div style="display:inline-block;">
            <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Usuario</th>
                <th>Contraseña</th>
                <th>Matricula</th>
                <th>Estatus</th>
                <th></th>
                <th></th>
            </tr>
        <%
                List alumnos = (List) session.getAttribute("alumno");
                if(alumnos != null){
        %>
        <%
            for (Object o : alumnos){
                Alumno alumno = (Alumno) o;
        %>
          
            <tr> 
                <td> <input type="text" name="id" value="<%= alumno.getId() %>"> </td>
                <td> <input type="text" name="nombre" value="<%= alumno.getNombre() %>"> </td>
                <td> <input type="text" name="usuario" value="<%= alumno.getUsuario() %>"> </td>
                <td> <input type="text" name="contraseña" value="<%= alumno.getContraseña() %>"> </td>
                <td> <input type="text" name="matricula" value="<%= alumno.getMatricula() %>"> </td>
                <td> <input type="text" name="estatus" value="<%= alumno.getEstatus() %>"> </td>
                <td> 
                    <%-- 
                    <form action="${pageContext.request.contextPath}/adminControlador" method="post">
                        <input type="hidden" name="accion" value="Editar">
                        <input type="submit" value="Editar"> 
                    </form>
                        --%>
                </td>
                <td> 
                    <%-- 
                    <form action="${pageContext.request.contextPath}/adminControlador" method="post">
                        <input type="hidden" name="accion" value="Eliminar">
                        <input type="submit" value="Eliminar"> 
                    </form>
                    --%>
                </td>
            </tr>
        
            <%}%>
            <%}else {%>
            nariz
            <%}%>
        </table>
        </div>
            
            
            
        
    </body>
</html>

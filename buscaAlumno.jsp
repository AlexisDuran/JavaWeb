<%-- 
    Document   : buscaAlumno
    Created on : 12/07/2019, 10:34:44 AM
    Author     : DURAN
--%>

<%@page import="Modelo.Alumno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Siase/CSS/mystyle.css">
        <script>
            function mostrar(){document.getElementById('obj1').style.display  = 'inline-block';}    
            function mostrar2(){document.getElementById('obj2').style.display  = 'inline-block';}
            function mostrar3(){document.getElementById('obj3').style.display  = 'inline-block';}
            function mostrar4(){document.getElementById('obj4').style.display  = 'inline-block';}
    <%--        
    function eliminar(){}
    {var mensaje; var opcion = confirm("Click en Aceptar o Cancelar");
    if (opcion == true) {
        mensaje = "Has aceptado OK";
	} else {
	    mensaje = "Has Cancelado";
	}
	document.getElementById("ejemplo").innerHTML = mensaje;}
    function editar(){  }--%>
        </script> 
        <title>Buscar Alumno</title>
    </head>
    <body>
        
        <div class="header">
            <h1>Sistema Escolar</h1>
        </div>
        
        <div class="topnav">
            <a href="admin.jsp">Regresar</a>
        </div>
        
        <div class="topnav">
            <a>
                <form action="${pageContext.request.contextPath}/adminControlador" method="post" >
                    <p>Buscar Alumno Por:</p>
                    <select name="por">
                        <option value="nombre">Nombre</option>
                        <option value="usuario">Usuario</option>
                        <option value="matricula">Matrícula</option>
                        <option value="estatus">Estatus</option>
                    </select>
                    <input type="text" name="txt" placeholder="Ingresa dato">
                    <input type="hidden" name="accion" value="buscaAlumno">
                    <input type="submit" class="button2" onclick="alert('Buscando...')" value="Buscar Alumno">
                </form>
            </a>
            
            <a href="*"><input type="button" class="button2" value="Salir"></a>
        </div>
                    
                    
                    
    <div>
        <%
                List alumnos = (List) session.getAttribute("alumno");
                if(alumnos != null){
        %>
        <%
            for (Object o : alumnos){
                Alumno alumno = (Alumno) o;
        %>
        <div>
    <form id="miFormulario1" action="${pageContext.request.contextPath}/adminControlador" method="post">
        <p>ID: <input type="text" name="id" value="<%= alumno.getId() %>">  </p><br>
        <p>Nombre: <input type="text" name="nombre" value="<%= alumno.getNombre() %>">  </p><br>
        <p>Usuario: <input type="text" name="usuario" value="<%= alumno.getUsuario() %>">   </p><br>
        <p>Contraseña: <input type="text" name="contraseña" value="<%= alumno.getContraseña() %>">  </p><br>
        <p>Matricula: <input type="text" name="matricula" value="<%= alumno.getMatricula() %>"> </p><br>
        <p>Estatus: <input type="text" name="estatus" value="<%= alumno.getEstatus() %>">   </p><br>
        <input type="hidden" name="accion" value="editarAlumno">
        <p><input type="submit" class="button2" onclick="avisoEditar()" value="Editar"></p>
    </form>   </div>
        
        <script type="text/javascript">
       function avisoEditar() {
         var form = document.getElementById('miFormulario1');
         form.addEventListener('submit', function(event) {
           // si es false entonces que no haga el submit
           if (!confirm('Realmente desea editar?')) {
             event.preventDefault();
           }
         }, false);
       }
     </script>
        
        
  <div>
    <form id="miFormulario" action="${pageContext.request.contextPath}/adminControlador" method="post">
        ID: <input type="text" name="id" value="<%= alumno.getId() %>">  <br>
        Nombre: <input type="text" name="nombre" value="<%= alumno.getNombre() %>">  <br>
        Usuario: <input type="text" name="usuario" value="<%= alumno.getUsuario() %>">   <br>
        Contraseña: <input type="text" name="contraseña" value="<%= alumno.getContraseña() %>">  <br>
        Matricula: <input type="text" name="matricula" value="<%= alumno.getMatricula() %>"> <br>
        Estatus: <input type="text" name="estatus" value="<%= alumno.getEstatus() %>">   <br>
        <input type="hidden" name="accion" value="eliminarAlumno">
        <input type="submit" class="button2" onclick="avisoEliminar()" value="Eliminar">
    </form></div>
        
        <script type="text/javascript">
       function avisoEliminar() {
         var form = document.getElementById('miFormulario');
         form.addEventListener('submit', function(event) {
           // si es false entonces que no haga el submit
           if (!confirm('Realmente desea eliminar?')) {
             event.preventDefault();
           }
         }, false);
       }
     </script>
        
        
            <%}%>
            <%}else {%>
                    <h2>Sin resultados</h2>
            <%}%>
    </div>       
            
     <%--      
    <div>
        <form action="${pageContext.request.contextPath}/adminControlador" method="post">
            <input type="hidden" name="accion" value="Eliminar">
            <input type="submit" class="button2" value="Eliminar"> 
        </form>
    </div>   --%>
        
        
    </body>
</html>

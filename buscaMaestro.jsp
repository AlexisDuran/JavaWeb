<%-- 
    Document   : buscaMaestro
    Created on : 12/07/2019, 10:34:33 AM
    Author     : DURAN
--%>

<%@page import="Modelo.Maestro"%>
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
        </script>
        <title>Buscar Maestro</title>
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
                    <p>Buscar Maestro Por:</p>
                    <select name="por">
                        <option value="nombre">Nombre</option>
                        <option value="usuario">Usuario</option>
                        <option value="tipoEmpleadoId">Tipo</option>
                        <option value="no_empleadoId">N° Empleado</option>
                        <option value="estatus">Estatus</option>
                    </select>
                    <input type="text" name="txt" placeholder="Ingresa dato">
                    <input type="hidden" name="accion" value="buscaMaestro">
                    <input type="submit" class="button2" onclick="alert('Buscando...')" value="Buscar Maestro">
                </form>
            </a>
            <a href="*"><input type="button" class="button2" value="Salir"></a>
        </div>
        
                    
        <div>
        <%
                List maestros = (List) session.getAttribute("maestro");
                if(maestros != null){
        %>
        <%
            for (Object o : maestros){
                Maestro maestro = (Maestro) o;
        %>
        <form id="miFormulario1" action="${pageContext.request.contextPath}/adminControlador" method="post">
            <p>ID: <input type="text" name="id" value="<%= maestro.getId() %>"></p><br>
            <p>Nombre: <input type="text" name="nombre" value="<%= maestro.getNombre() %>"></p><br>
            <p>Usuario: <input type="text" name="usuario" value="<%= maestro.getUsuario() %>"></p><br>
            <p>Contraseña: <input type="text" name="contraseña" value="<%= maestro.getContraseña() %>"></p><br>
            <p>N° Empleado: <input type="text" name="no_empleado" value="<%= maestro.getNo_empleado() %>"></p><br>
            <p>Tipo de Empleado: <input type="text" name="tipoEmpleadoId" value="<%= maestro.getTipoEmpleadoId() %>"></p><br>
            <p>Estatus: <input type="text" name="estatus" value="<%= maestro.getEstatus()%>"></p><br>
            <input type="hidden" name="accion" value="editarMaestro">
            <input type="submit" class="button2" onclick="avisoEditar()" value="Editar">
        </form>
            
            
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
            <p>ID: <input type="text" name="id" value="<%= maestro.getId() %>"></p><br>
            <p>Nombre: <input type="text" name="nombre" value="<%= maestro.getNombre() %>"></p><br>
            <p>Usuario: <input type="text" name="usuario" value="<%= maestro.getUsuario() %>"></p><br>
            <p>Contraseña: <input type="text" name="contraseña" value="<%= maestro.getContraseña() %>"></p><br>
            <p>N° Empleado: <input type="text" name="no_empleado" value="<%= maestro.getNo_empleado() %>"></p><br>
            <p>Tipo de Empleado: <input type="text" name="tipoEmpleadoId" value="<%= maestro.getTipoEmpleadoId() %>"></p><br>
            <p>Estatus: <input type="text" name="estatus" value="<%= maestro.getEstatus()%>"></p><br>
            <input type="hidden" name="accion" value="eliminarMaestro">
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
                    
                    
                    
                    
    </body>
</html>

<%-- 
    Document   : buscaAlumnoMateria
    Created on : 12/07/2019, 10:37:28 AM
    Author     : DURAN
--%>

<%@page import="Modelo.Alumno_materia"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Siase/CSS/mystyle.css">
        
        <title>Buscar Alumno Materia</title>
        
    </head>
    <body>
        
        <div class="header">
            <h1>Sistema Escolar</h1>
        </div>
        <div class="topnav">
            <a href="alumno.jsp">REGRESAR</a>
            <a href="*">Salir **test</a>
        </div>
        
        <div class="topnav">
            <a>
                <form action="${pageContext.request.contextPath}/alumnoControlador" method="post" >
                    <p>Buscar Registro por ID:</p>
                    <input type="text" name="id" placeholder="Ingresa dato">
                    <input type="hidden" name="accion" value="buscaMateria">
                    <input type="submit" class="button2" onclick="alert('Buscando...')" value="Buscar Registro">
                </form>
            </a>
            <a href="*"><input type="button" class="button2" value="Salir"></a>
        </div>
        
        <div>
        <%
                List sss = (List) session.getAttribute("alumno_materia");
                if(sss != null){
        %>
        <%
            for (Object o : sss){
                Alumno_materia alumno_materia = (Alumno_materia) o;
        %>
        <div>
    <form id="miFormulario1" action="${pageContext.request.contextPath}/alumnoControlador" method="post">
        <p>ID: <input type="text" name="id" value="<%= alumno_materia.getId() %>">  </p><br>
        <p>ID materia: <input type="text" name="materiaId" value="<%= alumno_materia.getMateriaId()%>">  </p><br>
        <p>ID Alumno: <input type="text" name="alumnoId" value="<%= alumno_materia.getAlumnoId() %>">   </p><br>
        
        <input type="hidden" name="accion" value="editar">
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
    <form id="miFormulario" action="${pageContext.request.contextPath}/alumnoControlador" method="post">
        <p>ID: <input type="text" name="id" value="<%= alumno_materia.getId() %>">  </p><br>
        <p>ID materia: <input type="text" name="materiaId" value="<%= alumno_materia.getMateriaId()%>">  </p><br>
        <p>ID Alumno: <input type="text" name="alumnoId" value="<%= alumno_materia.getAlumnoId() %>">   </p><br>
        
        <input type="hidden" name="accion" value="eliminar">
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

<%-- 
    Document   : buscaMateria
    Created on : 12/07/2019, 10:36:49 AM
    Author     : DURAN
--%>

<%@page import="Modelo.Materia"%>
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
        <title>Buscar Materia</title>
    </head>
    <body>
        
        <div class="header">
            <h1>Sistema Escolar</h1>
        </div>
        
        <div class="topnav">
            <a href="maestro.jsp">Regresar</a>
        </div>
        
        <div class="topnav">
            <a>
                <form action="${pageContext.request.contextPath}/maestroControlador" method="post" >
                    <p>Buscar Materia Por:</p>
                    <select name="por">
                        <option value="nombre">Nombre</option>
                        <option value="clave">Clave</option>
                        <option value="estatus">Estatus</option>
                    </select>
                    <input type="text" name="txt" placeholder="Ingresa dato">
                    <input type="hidden" name="accion" value="buscaMateria">
                    <input type="submit" class="button2" onclick="alert('Buscando...')" value="Buscar Materia">
                </form>
            </a>
            
            <a href="*"><input type="button" class="button2" value="Salir"></a>
        </div>
                    
                    
                    
    <div>
        <%
                List materias = (List) session.getAttribute("materia");
                if(materias != null){
        %>
        <%
            for (Object o : materias){
                Materia materia = (Materia) o;
        %>
        <div>
            <form id="miFormulario1" action="${pageContext.request.contextPath}/maestroControlador" method="post">
        <p>ID: <input type="text" name="id" value="<%= materia.getId() %>">  </p><br>
        <p>Nombre: <input type="text" name="nombre" value="<%= materia.getNombre() %>">  </p><br>
        <p>Clave: <input type="text" name="clave" value="<%= materia.getClave() %>"> </p><br>
        <p>Estatus: <input type="text" name="estatus" value="<%= materia.getEstatus() %>">   </p><br>
        <input type="hidden" name="accion" value="editarMateria">
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
      <form id="miFormulario" action="${pageContext.request.contextPath}/maestroControlador" method="post">
        ID: <input type="text" name="id" value="<%= materia.getId() %>">  <br>
        Nombre: <input type="text" name="nombre" value="<%= materia.getNombre() %>">  <br>
        Clave: <input type="text" name="clave" value="<%= materia.getClave() %>"> <br>
        Estatus: <input type="text" name="estatus" value="<%= materia.getEstatus() %>">   <br>
        <input type="hidden" name="accion" value="eliminarMateria">
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

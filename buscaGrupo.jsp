<%-- 
    Document   : buscaGrupo
    Created on : 12/07/2019, 10:36:59 AM
    Author     : DURAN
--%>

<%@page import="Modelo.Grupo"%>
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
        <title>Buscar Grupos</title>
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
                    <p>Buscar Grupo Por:</p>
                    <select name="por">
                        <option value="materiaid">ID Materia</option>
                        <option value="estatus">Estatus</option>
                    </select>
                    <input type="text" name="txt" placeholder="Ingresa dato">
                    <input type="hidden" name="accion" value="buscaGrupo">
                    <input type="submit" class="button2" onclick="alert('Buscando...')" value="Buscar Grupo">
                </form>
            </a>
            <a href="*"><input type="button" class="button2" value="Salir"></a>
        </div>
                    
                    
                    
    <div>
        <%
                List grupos = (List) session.getAttribute("grupo");
                if(grupos != null){
        %>
        <%
            for (Object o : grupos){
                Grupo grupo = (Grupo) o;
        %>
        <div>
    <form id="miFormulario1" action="${pageContext.request.contextPath}/maestroControlador" method="post">
        <p>ID: <input type="text" name="id" value="<%= grupo.getId() %>">  </p><br>
        <p>ID Materia: <input type="text" name="materiaid" value="<%= grupo.getMateriaid() %>">  </p><br>
        <p>Cantidad: <input type="text" name="cantidad" value="<%= grupo.getCantidad() %>"> </p><br>
        <p>Estatus: <input type="text" name="estatus" value="<%= grupo.getEstatus() %>">   </p><br>
        <input type="hidden" name="accion" value="editarGrupo">
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
        ID: <input type="text" name="id" value="<%= grupo.getId() %>">  <br>
        ID Materia: <input type="text" name="nombre" value="<%= grupo.getMateriaid() %>">  <br>
        Cantidad: <input type="text" name="clave" value="<%= grupo.getCantidad() %>"> <br>
        Estatus: <input type="text" name="estatus" value="<%= grupo.getEstatus() %>">   <br>
        <input type="hidden" name="accion" value="eliminarGrupo">
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

<%-- 
    Document   : maestro
    Created on : 09-jul-2019, 12:41:25
    Author     : Equipo16
--%>

<%@page import="Modelo.Grupo"%>
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
        <title>Maestro</title>
    </head>
    <body>
        <div class="header">
            <h1>Sistema Escolar</h1>
        </div>
        
        <div class="topnav">
            <a href="buscaMateria.jsp">Buscar Materia</a>
            <a href="buscaGrupo.jsp">Buscar Grupo</a>
            <a href="*">Salir</a>
        </div>
        
        <input type="button" class="button2" onclick="mostrar()" value="Alta Materia"><br>
        <div id="obj1">
            <p>Ingresar datos de Materia</p>
            <form action="${pageContext.request.contextPath}/maestroControlador" method="post" >
                <input type="hidden" name="accion" value="insertarMateria">
                <label>Nombre: </label><input class="input" type="text" name="nombre" placeholder="Nombre..."><br>
		<label>Clave: </label><input type="text" name="clave" placeholder=" (int) Clave..."><br>
		<label>Estatus: </label><input type="text" name="estatus" placeholder="(int)Estatus..."><br>
			
		<input type="submit" class="button2" onclick="alert('Enviado')" value="Enviar">
                <input class="button2" type="reset" value="Reset">
            </form>
        </div><br><br>
        
        <input type="button" class="button2" onclick="mostrar2()" value="Alta Grupo"><br>
        <div id="obj2">
            <h2>Ingresar datos de Grupo</h2>
            <form action="${pageContext.request.contextPath}/maestroControlador" method="post" >
                <input type="hidden" name="accion" value="insertarGrupo">
                <label>Materia ID: </label><input type="text" name="materiaid" placeholder=" (int) id materia..."><br>
                <label>Cantidad: </label><input type="text" name="cantidad" placeholder=" (int) Cantidad..."><br>
		<label>Estatus: </label><input type="text" name="estatus" placeholder="(int) Estatus..."><br>
                
                <input type="submit" class="button2" onclick="alert('Enviado')" value="Enviar">
                <input class="button2" type="reset" value="Reset">
            </form>
        </div><br>
        
        <form action="${pageContext.request.contextPath}/maestroControlador" method="post" >
            <input type="hidden" name="accion" value="obtenerMateria">
            <input type="submit" class="button2" value="Obtener Materias">
        </form>
    <div >
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Clave</th>
                <th>Estatus</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
        <%
                List materias = (List) session.getAttribute("materia");
                if(materias != null){
        %>
        <%
            for (Object o : materias){
                Materia materia = (Materia) o;
        %>
            <tr>
                <td><%= materia.getId() %></td>
                <td><%= materia.getNombre() %></td>
                <td><%= materia.getClave() %></td>
                <td><%= materia.getEstatus() %></td>
                
                <td><input type="submit" value="Editar"></td>
                <td><input type="submit" value="Eliminar"></td>
            </tr>
            <%}%>
            <%}else {%>
            
            <%}%>
        </table>
        </div>
        
        
        <form action="${pageContext.request.contextPath}/maestroControlador" method="post" >
            <input type="hidden" name="accion" value="obtenerGrupo">
            <input type="submit" class="button2" value="Obtener Grupos">
        </form>
    <div>
            <table>
            <tr>
                <th>ID</th>
                <th>Materia ID</th>
                <th>Cantidad</th>
                <th>Estatus</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
        <%
                List grupos = (List) session.getAttribute("grupo");
                if(grupos != null){
        %>
        <%
            for (Object o : grupos){
                Grupo grupo = (Grupo) o;
        %>
          
            <tr> 
                <td> <input type="text" name="id" value="<%= grupo.getId() %>"> </td>
                <td> <input type="text" name="nombre" value="<%= grupo.getMateriaid()%>"> </td>
                <td> <input type="text" name="usuario" value="<%= grupo.getCantidad()%>"> </td>
                <td> <input type="text" name="contraseña" value="<%= grupo.getEstatus()%>"> </td>
                
                <td> 
                    <form action="${pageContext.request.contextPath}/maestroControlador" method="post">
                        <input type="hidden" name="accion" value="Editar">
                        <input type="submit" value="Editar"> 
                    </form>
                </td>
                <td> 
                    <form action="${pageContext.request.contextPath}/maestroControlador" method="post">
                        <input type="hidden" name="accion" value="Eliminar">
                        <input type="submit" value="Eliminar"> 
                    </form>
                </td>
            </tr>
        
            <%}%>
            <%}else {%>
            
            <%}%>
        </table>
        </div>
        
    </body>
</html>

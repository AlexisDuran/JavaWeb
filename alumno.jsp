<%-- 
    Document   : alumno
    Created on : 09-jul-2019, 12:41:16
    Author     : Equipo16
--%>

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
        <title>Alumno</title>
    </head>
    <body>
        <div class="header">
            <h1>Sistema Escolar</h1>
        </div>
        <div class="topnav">
            <a href="buscaAlumnoMateria.jsp">Buscar Materia</a>
            <a href="*">Salir</a>
        </div>
        
        <input type="button" class="button2" onclick="mostrar()" value="Inscribir Materia"><br>
        
        <div id="obj1">
            <p>Ingresar datos de la Materia y Alumno</p>
            <form action="${pageContext.request.contextPath}/alumnoControlador" method="post" >
                <input type="hidden" name="accion" value="insertarMateria">
                <label>ID de Materia: </label><input class="input" type="text" name="materiaId" placeholder="int"><br>
		<label>ID de Alumno: </label><input type="text" name="alumnoId" placeholder="int"><br>
			
		<input type="submit" class="button2" onclick="alert('Enviado')" value="Enviar">
                <input class="button2" type="reset" value="Reset">
            </form>
        </div><br><br>
        
        <input type="button" class="button2" onclick="mostrar2()" value="Baja de Materia"><br>
        
        <div id="obj2">
            <p>Ingresar ID de Materia</p>
            <form id="miFormulario" action="${pageContext.request.contextPath}/alumnoControlador" method="post" >
                <input type="hidden" name="accion" value="bajaMateria">
                <label>ID de Registro: </label><input class="input" type="text" name="id" placeholder="int"><br>
			
		<input type="submit" class="button2" onclick="avisoEliminar()" value="ELIMINAR">
                <input class="button2" type="reset" value="Reset">
            </form>
        </div><br><br>
        
        <script type="text/javascript">
       function avisoEliminar() {
         var form = document.getElementById('miFormulario');
         form.addEventListener('submit', function(event) {
           // si es false entonces que no haga el submit
           if (!confirm('Realmente desea eliminar Materia?')) {
             event.preventDefault();
           }
         }, false);
       }
     </script>
        
        
    </body>
</html>

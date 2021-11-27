<%-- 
    Document   : crearClase
    Created on : 24/11/2021, 03:28:08 PM
    Author     : PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="./estilos/imagenes/favicon.png">
	<meta charset="utf-8">
        <link href="./estilos/estiloAdmin.css" rel="stylesheet" type="text/css"/>  
	<title>Clase</title>
    </head>
    <body>
        <header>
            <br><br><div align="center"><img src="./estilos/imagenes/crearClase.png" alt="logo"></div>    <br> 
        </header>     
	<form action= "crearClase" method="post">
            <br><br><br><br><br>
            <label for="correo">Semestre</label>
            <br><br>
            <select name="semestre" class="ini">
              <option value=1>1</option>
              <option value=3>3</option>
              <option value=5>5</option>
              <option value=7>7</option>
            </select>
            <br><br>
            <label for="correo">Grupo</label>
            <br><br>
            <select name="grupo" class="ini">
              <option value="A">A</option>
              <option value="B">B</option>
            </select>
            <br><br>
            <input type="submit" id="registar1" value="Ingresar" name="registrar1" class="boton1">
            <a href="admin.jsp" class="boton2">Cancelar</a>
        </form>
    </body>
</html>

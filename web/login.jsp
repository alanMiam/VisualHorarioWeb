<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="utf-8">
        <link href="./estilos/estiloLogin2.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="./estilos/imagenes/favicon.png">
	<title>Inicio de sesión</title>
    </head>
    <body>
        <header>
            <br><br><div align="center"><img src="./estilos/imagenes/inicioLogo.png" alt="logo"></div>    <br> 
        </header>     
	<form action= "login" method="post">
            <br>
            <label for="correo">Correo electrónico</label>
            <br><br>
            <input type="email" id="correo"  name ="correo" size="30" pattern="^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$" required class="in">
            <br><br>
            <input type="submit" id="registar1" value="Ingresar" name="registrar1" class="boton1">
            <a href="index.html" class="boton2">Cancelar</a>
        </form>
    </body>
</html>

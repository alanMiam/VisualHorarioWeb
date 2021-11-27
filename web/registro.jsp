<%-- 
    Document   : registro
    Created on : 22/11/2021, 02:25:59 PM
    Author     : PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="./estilos/estiloLogin2.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="./estilos/imagenes/favicon.png">
        <title>Registro</title>
    </head>
    <body>
        <header>
          <br><br>
          <div align="center"><img src="./estilos/imagenes/registroLogo.png" alt="logo"></div>    
          <br> 
        </header>     
            <form action= "registro" method="post">
              <br><label for="nombre">Cree un nombre de usuario</label>
              <br><br>
              <input type="text" id="nombre" name="nombre" class="in" pattern="^(?=.{4,30}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$" required>
              <br><br>
              <label for="correo">Ingrese una dirección de correo electrónico</label>
              <br><br>
              <input type="email" id="correo"  name ="correo" size="30" pattern="^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$" required class="in">
              <br><br>
              <input type="submit" id="registar1" value="Registrar" name="registrar1" class="boton1">
              <a href="index.html" class="boton2">Cancelar</a>
            </form>
    </body>
</html>

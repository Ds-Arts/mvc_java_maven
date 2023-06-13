<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/Cuenta.css"/>
    <link rel="stylesheet" href="assets/img"/>
    <title>Crear cuenta</title>
</head>
<body>
    <h1>crea tu cuenta aqui</h1>

    <div class="container">
    <form class="form" action="usuario" method="post">

        
    <div class=".container-inputs">  
        <label for="usu_nombre">Nombre</label>
        <input type="text" name="nombreCuenta" id="nombreCuenta" placeholder="ingresa tu usuario" required>

        <label for="usu_email">Contraseña</label>                
        <input type="text" name="contrasenaCuenta" id="contrasenaCuenta" placeholder="ingresa tu contraseña">
            
            
        <label for="usu_email">Saldo</label>                
        <input type="text" name="saldoNequi" id="saldoNequi"placeholder="ingresa tu saldo">
        
         <label for="usu_estado">Estado</label>                
            
            <input type="checkbox" name="chkestado" id="chkestado" checked class="form-check-input"placeholder="ingresa tu estado">
        </div>
        

        <div class="button">
            
            <button type="submit" name="accion" value="add">Resgistrar</button>

        
            <p>Al registrarte acepta todas nuestros <u>terminos y condiciones</u></p>
            <p>¿ya tienes una cuenta? <a class="link" href="bolsillo?accion=loginN">Inicia en Nequi</a> o <a class="link" href="bolsillo?accion=loginD">Inicia en daviplata</a></p> 
            <p>Volver al <a class="link" href="cuenta?accion=abrirForm">Inicio</a></p>
        </div>
    </form>
</body>
</html>
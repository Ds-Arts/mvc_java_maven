<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/Vista6.css"/>
    <title>onsultar</title>
</head>

<body style="background-image: url(assets/img/aaaaa.png)">
    <section class="form-login">
        <h5>consultar saldo</h5>
        <form action="nequi" method="post">
            <label for="consulta"><h5>su saldo es</h5></label>
        <p>  <%=request.getAttribute("saldoTotal")%> </p>
        
        </form>
        <a href="nequi?accion=dashboard"><input class="buttons" type="submit" name="" value="Volver a menu principal"></a>
        
    </section>
</body>
</html>
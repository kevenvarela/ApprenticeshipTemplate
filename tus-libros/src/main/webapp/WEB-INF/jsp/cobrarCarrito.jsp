<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>TusLibros.com</title>
    </head>

    <body>
        <center><h1>CHECKOUT CARRITO</h1></center>

        <form method="post" action="/checkoutCart">
            Nombre del duenio de la tarjeta:
            <input name="nombreDuenio">
            Numero de tarjeta:
            <input name="numeroTarjeta">
            Mes de expiracion:
            <input name="mesExpiracion">
            Anio de expiracion:
            <input name="anioExpiracion"><input type="submit">
        </form>

    </body>

</html>
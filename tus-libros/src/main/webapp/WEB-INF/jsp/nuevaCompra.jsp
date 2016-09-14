<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>TusLibros.com</title>
    </head>

    <body>
        <center><h1>TusLibros.com</h1></center>
        <br/>
        <h2>Nueva compra</h2>
        <br/>

        <form action="/carrito_nuevo" method="post" >
            Crear nuevo carrito
            <input type="submit">
        </form>

        <form action="/agregar_item" method="post" >
            Agregar un Item al carrito
            <input name="elemento">
            <input type="submit">
        </form>

        <br/>
        <h1 id="titulo">Carritos</h1>

        <ul>
                ${carrito}
                ---------------------------------------------------------
                <li class="crt">Carrito id:${carrito.getId()}</li>
                <br/>
                <li class="crt">Contenido:${carrito.contenido()}</li>
                <br/>
                ---------------------------------------------------------
        </ul>

    </body>

</html>
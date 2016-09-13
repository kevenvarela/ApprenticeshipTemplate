<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>TusLibros.com</title>
    </head>

    <body>
        <h1>TusLibros.com</h1>
        <br/>
        <h2>Nueva compra</h2>
        <br/>
        <p>La hora es: ${hora}</p>
        <br/>
        <p>Su nuevo carrito es: ${carrito}</p>
        <br/>
        Item nuevo:<input type="text" name="nombre">
        <br/>
        <a><input type="Button" value="Agregar item"/></a>

        <p>${carrito.contenido()}</p>

    </body>

</html>
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
        <form action="/carrito" method="post">
            <input name="carrito">
            <input type="submit">
        </form>
        <br/>
        <h1 id="titulo">Carritos</h1>
        <ul>
            <c:forEach items="${carritos}" var="carrito">
                <li class="crt">${carrito.getId()}</li>
            </c:forEach>
        </ul>

    </body>

</html>
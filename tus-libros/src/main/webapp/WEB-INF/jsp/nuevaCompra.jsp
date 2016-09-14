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
        <form action="/mensajes" method="post">
            <input name="mensaje">
            <input type="submit">
        </form>
        <br/>
        <h1 id="titulo">Carritos</h1>
        <ul>
            <c:forEach items="${mensajes}" var="mensaje">
                <li class="msj">${mensaje}</li>
            </c:forEach>
        </ul>

    </body>

</html>
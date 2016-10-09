<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>TusLibros.com</title>
    </head>

    <body>
        <center><h1>TusLibros.com</h1></center>
        <br/>
        <h2>Nueva compra</h2>
        <br/>

        <%--<form action="/carrito_nuevo" method="post" >--%>
            Crear nuevo carrito
            <input type="submit">
        </form>

        <form action="/addToCart" method="post" >
            Seleccione libro a agregar: <select name="libro">
            <option disabled selected value> -- Seleccione un libro -- </option>
            <c:forEach items="${libros}" var="libro">
                <option value=${libro.getId()}>${libro.getNombreLibro()}</option>
            </c:forEach>
        </select>
            <br><br>
            <input type="submit">
            Cantidad
            <input name="cantidad">
        </form>


        <%--<form action="/loguearCliente" method="get" >--%>
            Client Id
            <input name="nombre">
            Password
            <input name="password"><input type="submit">
        </form>

        <br/>
        <h1 id_catalogo="titulo">Carritos</h1>

        <ul>

                ---------------------------------------------------------
                <li class="clt">Cliente:${cliente.getId()}</li>
                <br/>
                <li class="crt">Carrito id:${carrito.getId()}</li>
                <br/>
                <li class="crt">ContenidoActual:<c:forEach items="${carrito.getItems()}" var="item">
                    <td>${item.getNombreLibro()}</td>
                </c:forEach></li>
                <br/>
                ---------------------------------------------------------


            <form method="get" action="/cobrarCarrito">
                <button type="submit">FINALIZAR COMPRA</button>
            </form>



        </ul>

    </body>

</html>
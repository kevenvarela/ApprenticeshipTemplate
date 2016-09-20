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

<form action="/carrito_nuevo" method="post" >
    Crear nuevo carrito
    <input type="submit">
</form>

<form action="/agregar_item" method="post" >
    Seleccione libro a agregar: <select name="libro">
    <option disabled selected value> -- Seleccione un libro -- </option>
    <c:forEach items="${libros}" var="libro">
        <option value="${libro}">${libro.getNombreLibro()}</option>
    </c:forEach>
</select>
    <br><br>
    <input type="submit">
</form>


<form action="/loguearCliente" method="post" >
    Client Id
    <input name="nombre">
    Password
    <input name="password"><input type="submit">
</form>

<br/>
<h1 id="titulo">Carritos</h1>

<ul>

    ---------------------------------------------------------
    <li class="clt">Cliente:${cliente.getId()}</li>
    <br/>
    <li class="crt">Carrito id:${carrito.getId()}</li>
    <br/>
    <li class="crt">Contenido:${carrito.contenido()}</li>
    <br/>
    ---------------------------------------------------------
</ul>

</body>

</html>
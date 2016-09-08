<%@ page contentType="text/html;charset=utf-8" language="java" %>

<html>
    <head>
        <title>Sumador</title>
    </head>

    <body>
        <h1>TusLibros.com</h1>

        <p>La hora es: ${hora}</p>

        <p>El numero es: ${numero}</p>



        <form action="resultadoPeticiones">
            Nombre:<input type="text" name="nombre">

            <input type="submit" />
        </form>

        <form action="resultadoPeticiones" method="post">
            Nombre:<input type="text" name="nombre">
            <br/>
            <br/>
            Lenguaje:<select name="lenguaje">
            <option>selecciona</option>
            <option>Java</option>
            <option>NET</option>
        </select>
            <br/>
            <br/>
            Nivel:<select name="nivel">
            <option>selecciona</option>
            <option>1</option>
            <option>2</option>
        </select>
            <br/>
            <br/>
            <input type="submit" />
        </form>


    </body>

</html>
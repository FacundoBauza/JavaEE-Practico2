<%--
  Created by IntelliJ IDEA.
  User: maria
  Date: 8/5/2022
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TAREA</title>
</head>
<body>
<h1>AGERGAR PELICULA</h1>
<form action="AddPeli" method="post">
    Nombre:
    <input type="text" name="nombre">
    <br/>
    Descripcion:
    <input type="text" name="descripcion">
    <br/>
    Fecha Lanzamiento:
    <input type="text" name="lanzamiento">
    <p><input type="submit" value="Enviar"></p>
</form>
    <br/>
</body>
</html>

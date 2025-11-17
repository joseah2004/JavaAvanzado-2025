<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Saludo</title>
</head>
<body>
    <h1>PANTALLA DE LOGIN </h1>
    <h2> <%= request.getAttribute("nombre") %></h2>
    <h2><%= request.getAttribute("mensaje") %></h2>
    <a href="index.jsp">Volver</a>
</body>
</html>


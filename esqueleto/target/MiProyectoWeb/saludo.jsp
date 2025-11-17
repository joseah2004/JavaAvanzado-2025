<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Saludo</title>
</head>
<body>
    <h1><%= request.getAttribute("mensaje") %></h1>
    <a href="index.html">Volver</a>
</body>
</html>


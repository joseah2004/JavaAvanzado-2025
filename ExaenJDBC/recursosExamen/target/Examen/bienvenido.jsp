<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
       <meta charset="UTF-8">
<head><title>Bienvenido</title></head>
<body>
    <h2>Bienvenido, <%= request.getAttribute("id") %></h2>
    <a href="index.jsp" name="accion" value="inicio">Cerrar sesión</a>
</body>
</html>

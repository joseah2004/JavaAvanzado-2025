<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Formulario de Login</title>
  <link rel="stylesheet" href="estilos.css">
</head>
<body>

  <div class="login-container">
    <h2>Iniciar Sesión</h2>
      <p style="color:red;">
        <%= request.getAttribute("nombre") != null ? request.getAttribute("nombre") : "" %>
    </p>
    <form action="LoginServlet" method="POST">
      <input type="text" placeholder="Usuario" name="user" required>
      <input type="password" placeholder="Contraseña"  name="pass" required>
      <button type="submit" name="accion" value="login" class="button">Ingresar</button>
      <button type="submit" name="accion" value="registro" class="button register-button" 
       >Registrase</a></button>
    </form>

     <p style="color:red;">
        
        <%= request.getAttribute("error") != null ?  request.getAttribute("error")  : "" %>
    </p>
    <div class="footer">
      <p>¿Olvidaste tu <a href="LoginServlet" name ="accion" value="olvidar">contraseña?</a></p>
    </div>
  </div>

</body>
</html>
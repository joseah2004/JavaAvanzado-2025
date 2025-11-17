package es.avellaneda.servlets;


import jakarta.servlet.http.*;

/**
 * HttpServlet es una clase abstracta de Jakarta EE (antes Java EE) que facilita la creación de aplicaciones web Java mediante el protocolo HTTP.

Pertenece al paquete: jakarta.servlet.http.HttpServlet

Detecta automáticamente el tipo de petición HTTP.

Llama al método correspondiente (doGet, doPost, etc.).

Te da objetos HttpServletRequest y HttpServletResponse, que contienen:

Información de la petición: parámetros, cabeceras, ruta, cookies...

Métodos para generar la respuesta: escribir HTML, cambiar código de estado, reenviar o redirigir.
 */


import jakarta.servlet.annotation.WebServlet;
/*
 * El @WebServlet("/...") define la ruta pública relativa al contexto de tu aplicación.
La anotación @WebServlet("/ruta") no tiene nada que ver con la ubicación del archivo Java en el proyecto.
 Lo que define es la URL pública que responderá el servlet.
La ubicación física del .java dentro de src/main/java no influye en la URL,
 pero sí es importante para que Maven/Tomcat compile y registre bien el servlet.
 */

import java.io.IOException;

@WebServlet("/hola")
public class loginsrvlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Hola desde el Servlet</h1>");
    }
}

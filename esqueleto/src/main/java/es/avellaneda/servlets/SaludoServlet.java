package es.avellaneda.servlets;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/saludo")
public class SaludoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String mensaje = "¡Hola, " + nombre + "! Bienvenido a JSP.";
        
        request.setAttribute("mensaje", mensaje);
        RequestDispatcher dispatcher = request.getRequestDispatcher("saludo.jsp");
        dispatcher.forward(request, response);
    }
}

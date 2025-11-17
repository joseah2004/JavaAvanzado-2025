package es.avellaneda.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import es.avellaneda.model.DAOUsuarios;
import es.avellaneda.model.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher;
        String accion = request.getParameter("accion");
        Usuario usuprincial = null;
         if ("olvidar".equals(accion)) { 
            request.setAttribute("mensaje", "PAGINA EN CONSTRUCCION");
            dispatcher = request.getRequestDispatcher("respuesta.jsp"); 
            dispatcher.forward(request, response);
        }else
        if ("inicio".equals(accion)) {
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
    
        } else if ("login".equals(accion)) {
            String usuario = request.getParameter("user");
            String password = request.getParameter("pass");
            
            usuprincial = new Usuario(usuario, password);
            Usuario usuariologin = DAOUsuarios.buscarUsuario(usuprincial);
            
            if (usuariologin != null) {
                dispatcher = request.getRequestDispatcher("bienvenido.jsp");
                request.setAttribute("id", usuariologin.getId());
                dispatcher.forward(request, response);  
            } else {
                request.setAttribute("error", "USUARIO NO REGISTRADO");
                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
    
        } else if ("registro".equals(accion)) {
            String usuario = request.getParameter("user");
            String password = request.getParameter("pass");
            usuprincial = new Usuario(usuario, password);
            DAOUsuarios.agregarUsuario(usuprincial);
            dispatcher = request.getRequestDispatcher("bienvenido.jsp");
            request.setAttribute("id", "0");
            dispatcher.forward(request, response);
    
        } 
    }
    
}

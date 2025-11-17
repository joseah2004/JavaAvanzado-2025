package es.avellaneda.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOUsuarios {
    
    public static Usuario buscarUsuario(Usuario usuario) {
        String sql = "SELECT * FROM usuarios WHERE nombre = ? AND password = ?";
        ResultSet resultset;
        Usuario usuarioEncontrado = null;
        
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, usuario.getUsuario());
            pstm.setString(2, usuario.getPassword());
            
            resultset = pstm.executeQuery();

            if (resultset.next()) {
                String nombreusu = resultset.getString("nombre");
                String contrasenia = resultset.getString("password");
                
                usuarioEncontrado = new Usuario(nombreusu, contrasenia);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarioEncontrado;
    }

    public static boolean agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, password) VALUES (?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, usuario.getUsuario());
            pstm.setString(2, usuario.getPassword());

        pstm.executeUpdate();

           

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}

package es.avellaneda.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:sqlite:";
    private static final String URL_PREFIX = "jdbc:sqlite:";
    public static Connection getConnection() throws SQLException{

        try {
            Class.forName("org.sqlite.JDBC");
            String ruta = DataBaseConnection.class.getClassLoader()
            .getResource("usuarios.db")  //<---- base de datos
            .toURI() 
            .getPath();
            String url = URL_PREFIX+ruta;
            System.out.println("Dirección de la base de datos "+ruta);
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.out.println("Error driver no encontrado");
            throw new SQLException("error no se encuentra: "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error general: " + e.getMessage());
            throw new SQLException("Error al conectar a la bbase de datos: "+e);
        }

    }
    
}

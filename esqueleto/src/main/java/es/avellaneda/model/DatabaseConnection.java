package es.avellaneda.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

   

    private static final String URL = "jdbc:sqlite:";

    private static final String URL_PREFIX = "jdbc:sqlite:";
    public static Connection getConnection() throws SQLException {
        System.out.println("Conexión a SQLite comenzada!");

        try {
            // Cargar el driver
            Class.forName("org.sqlite.JDBC");

            // Obtener la ruta de la base de datos
            String ruta = DatabaseConnection.class.getClassLoader()
                            .getResource("mydb.db")
                            .toURI()
                            .getPath();

            System.out.println("RUTA A LA BASE DE DATOS: " + ruta);

            // Construir la URL completa
            String url = URL_PREFIX + ruta;
            System.out.println("URL de conexión: " + url);

            // Establecer la conexión usando la URL correcta
            return DriverManager.getConnection(url);

        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver SQLite no encontrado");
            throw new SQLException("Error no se encuentra el conector", e);
        } catch (Exception e) { 
            System.out.println("Error general: " + e.getMessage());
            throw new SQLException("Error al conectar a la base de datos", e);
        }
    }
}

package es.avellaneda;

    import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
    import java.util.List;
    
    public class EscribeUsuario {
        private final String USUARIO = "USUARIO:";
        private final String EMAIL = "EMAIL:";
        private final String COLOR = "COLOR:";
        private final String nombreFichero = "usuarioNIO.txt";
    
        public void escribirUsuario() {
            Path rutaFichero = Path.of(nombreFichero);
            //File.rutaFichero2 = Path




            String usuario = "usuario1";
            String email = "usuario1@email.com";
            String color = "azul";
    
            List<String> lineas = Arrays.asList(
                USUARIO + usuario,
                EMAIL + email,
                COLOR + color
            );
    
            try {
                Files.write(rutaFichero, lineas, StandardOpenOption.APPEND);//PARA NO SOBREESCRIBIRLO EN EL FICHERO
                // DE NORMAL SERIA iles.write(rutaFichero, lineas);
                // si quisiéramos especificar la codificación
                // Files.write(rutaFichero, lineas, StandardCharsets.UTF_8);
                //   List<String> lineas = Files.readAllLines(rutaFichero, StandardCharsets.UTF_8);
                System.out.println("Usuario guardado correctamente en el archivo.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        public static void main(String[] args) {
            new EscribeUsuario().escribirUsuario();
        }
    }
    
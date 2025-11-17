package es.avellanda;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Cine {
    // Cine, en donde además de los atributos ya reseñados, debe tener los métodos necesarios para

    // ○ mostrar el cine en pantalla
    
    // ○ vender una entrada
    
    // ○ devolver una entrada
    
    // ○ leer las ventas desde el archivo y actualizar el array
    
    // ○ guardar las ventas en el archivo a través de objetos de la clase Butaca
    
    // ○ cualquier otro método que creas oportuno.

    private final String RUTA = "EntradasVendidas.txt";
    private final int FILAS =10;
    private final int ASIENTOS = 15;
    private Butaca[][] butacas;


    public Cine(){
        butacas =new Butaca[FILAS][ASIENTOS];
        crearPatio();
    }

   
    private void crearPatio(){
        Path ruta =Path.of(RUTA);

        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[0].length; j++) {
                butacas [i] [j] = new Butaca(i,j);
            }
        }
        try {
            List <String> ocupados = Files.readAllLines(ruta);


            for (String linea : ocupados) {
                String[] valores =linea.split("*");
                int fila = Integer.parseInt(valores[0]);
                int asiento = Integer.parseInt(valores[1]);

                //fila --> 0
                //asiento --->1
                butacas[fila][asiento].isOcupado();

            }
        } catch (IOException e) {
           //si no es posible no sdejara las butacas libres
        }
        
    }

    public boolean venderEntrada(int fila , int asiento){
        return true;
    }

    public String mostrarButacas(){
        StringBuilder sb = new StringBuilder();
        //recorrer el array y añadir la info dal sb , es bidimensional

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < ASIENTOS; j++) {
                Butaca b = butacas[i][j];
                if (b.isOcupado()) {
                    sb.append("xx ");
                }else {
                    sb.append("__ ");
                }
                sb.append("\n");
            }
            

        }
        return sb.toString();
    }
}


public boolean ComprarEntrada(int fila, int asiento) {
    if (butacas[fila][asiento].isOcupado()) {
        return false;
    }
    butacas[fila][asiento]).setOcupado(false);
}

package es2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class LeerFichData {
  public static void main(String[] args) throws IOException {    
	File fichero = new File("FichData.dat");
	DataInputStream dataIS = new
	                  DataInputStream(new FileInputStream(fichero));

   String n;
   String a;
   int e;
 

   try {
    while (true) {
        n = dataIS.readUTF(); //recupera el nombre
        a = dataIS.readUTF();//recupera el apellido
        e = dataIS.readInt(); //recupera la edad
        
        System.out.println("Nombre: " + n + " apellido " + a + 
        		" edad: " + e );        
    }
    }catch (EOFException eo) {}
	
   dataIS.close();  //cerrar stream   
  }


}

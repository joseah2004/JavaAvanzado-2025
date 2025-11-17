package es.avellaneda;



public class TestMain {

    public static void main(String[] args) {
        EscribeUsuario es = new EscribeUsuario();
        es.escribirUsuario();
        Usuario usuario;
        LeerUsuario le = new LeerUsuario();
        try {
        usuario = le.devolver();
        System.out.println(usuario);
        } catch (RuntimeException ex) {
           System.out.println("aaaaaaaaaa");
        }
        
    }

}
package es.avellaneda;

public class TestMain {

    public static void main(String[] args) {
        EscribeUsuarioBuffered es = new EscribeUsuarioBuffered();
        es.escribirUsuario();
        Usuario usuario;
        LeerUsuarioBuffered le = new LeerUsuarioBuffered();


        //para mostrar por pantalla lo mismo que nos saldria en el archivo
        System.out.println(le.leer());
        usuario = le.devolver();
        System.out.println(usuario);
    }
}

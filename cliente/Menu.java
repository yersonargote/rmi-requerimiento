package cliente;

import sop_rmi.Credencial;
import sop_rmi.IGestionUsuarios;
import cliente.utilidades.Consola;
import java.rmi.RemoteException;
import java.io.IOException;

public class Menu {

    private IGestionUsuarios gestionUsuarios;

    public Menu(IGestionUsuarios gestionUsuarios) {
        this.gestionUsuarios = gestionUsuarios;
    }

    public void iniciar() throws IOException, RemoteException {
        String inicialOpcion = "";
        int tipoUsuario = -1;
        do {
            System.out.println("===== Menu Inicio =====");
            System.out.println("1. Abrir sesion.");
            System.out.println("2. Salir.");

            inicialOpcion = Consola.readLine();

            switch (inicialOpcion) {
                case "1":
                    tipoUsuario = iniciarSesion();
                    System.out.printf("Bienvenido %d%n", tipoUsuario);
                    break;
                case "2":
                    System.out.println("Saliendo...");
                    break;
            }
        } while (!inicialOpcion.equals("2"));
    }

    private int iniciarSesion() throws IOException, RemoteException {
        String usuario = "", clave = "";
        int tipoUsuario = -1;
        Credencial credencial;
        do {
            System.out.println("===== Inicio de sesion =====");
            System.out.println("Ingrese usuario.");
            usuario = Consola.readLine();
            System.out.println("Ingrese clave.");
            clave = Consola.readLine();
        } while (usuario.length() < 2 || clave.length() < 8);

        credencial = new Credencial(usuario, clave);
        tipoUsuario = this.gestionUsuarios.abrirSesion(credencial);
        return tipoUsuario;
    }
}
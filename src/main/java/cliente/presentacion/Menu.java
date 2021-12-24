package cliente.presentacion;

/**
 *
 * @author yerso
 */

import gestion_usuarios.dto.CredencialDTO;
import gestion_usuarios.sop_rmi.IGestionUsuarios;
import gestion_usuarios.utilidades.Consola;
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

                    switch (tipoUsuario) {
                        case 0:
                            MenuAdmin menuAdmin = new MenuAdmin(this.gestionUsuarios);
                            menuAdmin.mostrar();
                            break;
                        case 1:
                            MenuSecretaria menuSecretaria = new MenuSecretaria();
                            break;
                        case 2:
                            MenuPaf menuPaf = new MenuPaf();
                            break;
                        case 3:
                            MenuPaciente menuPaciente = new MenuPaciente();
                            break;
                        default:
                            System.out.println("Usuario NO valido.");
                            break;
                    }
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
        CredencialDTO credencial;
        do {
            System.out.println("===== Inicio de sesion =====");
            System.out.println("Ingrese usuario.");
            usuario = Consola.readLine();
            System.out.println("Ingrese clave.");
            clave = Consola.readLine();
        } while (usuario.length() < 2 || clave.length() < 8);

        credencial = new CredencialDTO(usuario, clave);
        tipoUsuario = this.gestionUsuarios.abrirSesion(credencial);
        return tipoUsuario;
    }
}
package cliente.presentacion;

import gestion_usuarios.dto.PersonalDTO;
import gestion_usuarios.sop_rmi.IGestionUsuarios;
import gestion_usuarios.utilidades.Consola;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author yerso
 */
public class MenuAdmin {
    private IGestionUsuarios gestionUsuarios;

    public MenuAdmin(IGestionUsuarios gestionUsuarios) {
        this.gestionUsuarios = gestionUsuarios;
    }
    
    public void mostrar() {
        String opcion = "";
        do {
            System.out.println("===== Menu Administrador =====");
            System.out.println("1. Registar personal.");
            System.out.println("2. Modifiicar personal.");
            System.out.println("3. Eliminar personal.");
            System.out.println("4. Consultar personal.");
            System.out.println("5. Listar personal.");
            System.out.println("6. Salir.");

            opcion = Consola.readLine();

            switch (opcion) {
                case "1":
                    registrarPersonal();
                    break;
                case "2":
                    modificarPersonal();
                    break;
                case "3":
                    eliminarPersonal();
                    break;
                case "4":
                    consultarPersonal();
                    break;
                case "5":
                    listarPersonal();
                    break;
                case "6":
                    System.out.println("Saliendo...");
                    break;
            }
        } while (!opcion.equals("6"));
    }
    
    private void registrarPersonal() {
        String usuario = "", clave = "", nombre = "", ocupacion = "";
        int id = -1;
        boolean registrado = false;
        try {
            do {
                System.out.println("===== Registrar personal =====");
                System.out.println("Ingrese id.");
                // TODO: cambiar por utilidad
                id = Integer.parseInt(Consola.readLine());
                System.out.println("Ingrese nombre completo.");
                nombre = Consola.readLine();
                System.out.println("Ingrese ocupacion.");
                ocupacion = Consola.readLine();
                System.out.println("Ingrese usuario.");
                usuario = Consola.readLine();
                System.out.println("Ingrese clave.");
                clave = Consola.readLine();
            } while (usuario.length() < 2 || clave.length() < 4 || id <= 0 || nombre.length() < 2
                    || ocupacion.length() < 2);

        } catch (NumberFormatException e) {
            System.out.println("Error al leer datos.");
        }
        PersonalDTO personal = new PersonalDTO(usuario, clave, id, nombre, ocupacion);
        try {
            registrado = this.gestionUsuarios.registrarPersonal(personal);
        } catch (RemoteException ex) {
            System.out.println("Error al crear usuario.");
        }
        if (registrado) {
            System.out.println("Personal registrado.");
        } else {
            System.out.println("Error al registrar personal.");
        }
    }

    private void modificarPersonal() {

    }

    private void eliminarPersonal() {
    }

    private void consultarPersonal() {
        PersonalDTO personal = null;
        int id = -1;
        System.out.println("===== Consultar personal =====");
        System.out.println("Ingrese id.");
        id = Integer.parseInt(Consola.readLine());
        try {
            personal = this.gestionUsuarios.consultarPersonal(id);
        } catch (RemoteException ex) {
            System.out.println("Error al consultar personal.");
        }

        if (personal != null) {
            System.out.println("Personal encontrado.");
            System.out.println("Id: " + personal.getId());
            System.out.println("Nombre: " + personal.getNombreCompleto());
            System.out.println("Ocupacion: " + personal.getOcupacion());
            System.out.println("Usuario: " + personal.getUsuario());
        } else {
            System.out.println("Personal no encontrado.");
        }

    }

    private void listarPersonal() {
        System.out.println("===== Listar personal =====");
        List<PersonalDTO> personal = null;
        try {
            personal = this.gestionUsuarios.listarPersonal();
        } catch (RemoteException ex) {
            System.out.println("Error al listar personal.");
        }

        if (personal != null) {
            for (PersonalDTO per : personal) {
                System.out.println("Id: " + per.getId());
                System.out.println("Nombre: " + per.getNombreCompleto());
                System.out.println("Ocupacion: " + per.getOcupacion());
                System.out.println("Usuario: " + per.getUsuario());
            }
        } else {
            System.out.println("Personal no encontrado.");
            return;
        }
    }
}

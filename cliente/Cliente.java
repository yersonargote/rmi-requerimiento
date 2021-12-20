package cliente;

import cliente.utilidades.Consola;
import cliente.utilidades.Registro;
import sop_rmi.IGestionUsuarios;

public class Cliente {

    private static IGestionUsuarios gestionUsuarios;

    public static void main(String[] args) {
        String ip;
        String puerto;
        if (args.length != 2) {
            do {
                System.out.println("Ingrese la direccion IP del rmiregistry.");
                ip = Consola.readLine();
                System.out.println("Ingrese el puerto del rmiregistry.");
                puerto = Consola.readLine();
            } while (ip.isEmpty() || !puerto.matches("[0-9]+"));
        } else {
            ip = args[0];
            puerto = args[1];
        }
        gestionUsuarios = (IGestionUsuarios) Registro.getRemoteObj(ip, Integer.parseInt(puerto), "gestionUsuarios");

        Menu menu = new Menu(gestionUsuarios);
        try {
            menu.iniciar();
        } catch (Exception e) {
            System.out.println("Error al iniciar el menu.");
            System.out.println(e.getMessage());
        }
    }
}

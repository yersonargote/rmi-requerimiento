package gestion_usuarios;

import gestion_usuarios.sop_rmi.GestionUsuarios;
import gestion_usuarios.sop_rmi.IGestionUsuarios;
import gestion_usuarios.utilidades.Consola;
import gestion_usuarios.utilidades.RegistroS;

/**
 *
 * @author yerso
 */
public class Servidor {
    public static void main(String[] args) {

        int puerto;
        String ip, puerto_str;

        if (args.length == 2) {
            puerto = Integer.parseInt(args[0]);
            ip = args[1];
        } else {
            do {
                System.out.println("Ingrese la direccion IP del rmiregistry.");
                ip = Consola.readLine();
                System.out.println("Ingrese el puerto del rmiregistry.");
                puerto_str = Consola.readLine();
            } while (ip.isEmpty() || !puerto_str.matches("[0-9]+"));
            puerto = Integer.parseInt(puerto_str);
        }

        try {
            IGestionUsuarios gestionUsuarios = new GestionUsuarios();
            RegistroS.arrancarNS(puerto);
            RegistroS.RegistrarObjetoRemoto(gestionUsuarios, ip, puerto, "gestionUsuarios");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}

package gestion_usuarios;

import gestion_usuarios.sop_rmi.GestionUsuarios;
import gestion_usuarios.sop_rmi.IGestionUsuarios;
import gestion_usuarios.utilidades.Consola;
import gestion_usuarios.utilidades.RegistroC;
import gestion_usuarios.utilidades.RegistroS;
import seguimiento_usuarios.sop_rmi.ISeguimientoUsuarios;

/**
 *
 * @author yerso
 */
public class Servidor {
    public static void main(String[] args) {

        int puerto, puerto_seguimiento;
        String ip, puerto_str, ip_seguimiento, puerto_str_seguimiento;

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

        do {
            System.out.println("Ingrese la direccion IP del rmiregistry.");
            ip_seguimiento = Consola.readLine();
            System.out.println("Ingrese el puerto del rmiregistry.");
            puerto_str_seguimiento = Consola.readLine();
        } while (ip_seguimiento.isEmpty() || !puerto_str_seguimiento.matches("[0-9]+"));
        puerto_seguimiento = Integer.parseInt(puerto_str_seguimiento);

        try {
            IGestionUsuarios gestionUsuarios = new GestionUsuarios();
            ((GestionUsuarios) gestionUsuarios).setSeguimientoUsuarios((ISeguimientoUsuarios) RegistroC.getRemoteObj(ip_seguimiento, puerto_seguimiento, "seguimientoUsuarios"));
            RegistroS.arrancarNS(puerto);
            RegistroS.RegistrarObjetoRemoto(gestionUsuarios, ip, puerto, "gestionUsuarios");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}

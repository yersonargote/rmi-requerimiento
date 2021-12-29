package gestion_usuarios.utilidades;

/**
 *
 * @author yerso
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class RegistroC {

    public static Remote getRemoteObj(String dirIPNS, int puertoNS, String identificadorObjetoRemoto) {
        Remote objetoObtenido = null;
        String URLRegistro = "rmi://" + dirIPNS + ":" + puertoNS + "/" + identificadorObjetoRemoto;
        try {
            objetoObtenido = Naming.lookup(URLRegistro);
        } catch (NotBoundException e) {
            System.out.println("Error, objeto remoto no localizado");

        } catch (MalformedURLException e) {
            System.out.println("Error, url inválida");
        } catch (RemoteException e) {
            System.out.println("Excepcion en obtencion del objeto remoto" + e);

        }
        return objetoObtenido;
    }
}

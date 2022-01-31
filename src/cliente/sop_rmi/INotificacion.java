package cliente.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author yerso
 */
public interface INotificacion extends Remote {
    public boolean notificar(String info) throws RemoteException;
}

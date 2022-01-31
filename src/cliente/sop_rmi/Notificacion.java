package cliente.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author yerso
 */
public class Notificacion extends UnicastRemoteObject implements INotificacion {
    
    public Notificacion() throws RemoteException {
        super();
    }

    @Override
    public boolean notificar(String info) throws RemoteException {
        System.out.printf("Se acaba de registrar un paciente con la siguiente información: %s%n", info);
        return true;
    }
    
}

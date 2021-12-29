package seguimiento_usuarios.sop_rmi;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class SeguimientoUsuarios extends UnicastRemoteObject implements ISeguimientoUsuarios {

    public SeguimientoUsuarios() throws RemoteException {
        super();
    }

    @Override
    public boolean notificacion(String mensaje) {
        System.out.println(mensaje);
        return true;
    }
}

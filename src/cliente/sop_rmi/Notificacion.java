package cliente.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

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
        String msg = String.format("Se acaba de registrar un paciente con la siguiente información.%n%s%n", info);
        System.out.printf(msg);
        JOptionPane.showMessageDialog(null, msg, "Notificar Registro Paciente", JOptionPane.DEFAULT_OPTION);
        return true;
    }
    
}

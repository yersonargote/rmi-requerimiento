package seguimiento_usuarios.sop_rmi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeguimientoUsuarios extends UnicastRemoteObject implements ISeguimientoUsuarios {

    public SeguimientoUsuarios() throws RemoteException {
        super();
    }

    @Override
    public boolean notificacion(String mensaje) {
        System.out.println(mensaje);
        return true;
    }

    @Override
    public boolean addHistorial(int id, String historial) throws RemoteException {
        boolean ok = false;
        String path = String.format("../historial/usuario%d", id);

        try ( //Set true for append mode
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(path, true))) {
            writer.write(historial);
            ok = true;
        } catch (IOException ex) {
            Logger.getLogger(SeguimientoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return ok;
    }
}

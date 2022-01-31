package seguimiento_usuarios.sop_rmi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    @Override
    public boolean addHistorial(int id, String historial) throws RemoteException {
        String path = String.format("%s\\src\\seguimiento_usuarios\\historial\\usuario%d.txt", System.getProperty("user.dir"), id);
        System.out.println(path);
        try {
            Files.write(Paths.get(path), historial.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Error: Al crear o agregar información al historial.");
        }
        return true;
    }
}

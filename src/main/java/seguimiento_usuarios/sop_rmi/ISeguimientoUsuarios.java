package seguimiento_usuarios.sop_rmi;

public interface ISeguimientoUsuarios extends java.rmi.Remote {
    public boolean notificacion(String mensaje) throws java.rmi.RemoteException;
}

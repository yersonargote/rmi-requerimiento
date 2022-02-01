package seguimiento_usuarios.sop_rmi;

public interface ISeguimientoUsuarios extends java.rmi.Remote {
    public boolean notificacion(String mensaje) throws java.rmi.RemoteException;
    
    public boolean addHistorial(int id, String historial) throws java.rmi.RemoteException;
    
    public boolean addAsistencia(String asistencia) throws java.rmi.RemoteException;
}

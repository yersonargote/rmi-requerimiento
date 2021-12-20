package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ArrayList;

public class GestionUsuarios extends UnicastRemoteObject implements IGestionUsuarios {

    private final List<Personal> personal;
    private final List<Paciente> pacientes;

    public GestionUsuarios() throws RemoteException {
        super();
        personal = new ArrayList<>();
        pacientes = new ArrayList<>();
        personal.add(new Personal("admin", "12345678", "admin", 12345678, "admin", "admin"));
    }

    @Override
    public boolean registrarPersonal(Personal personal) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarPersonal(Personal personal) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarPersonal(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Personal consultarPersonal(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Personal> listarPersonal() throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int abrirSesion(Credencial credencial) throws RemoteException {
        int tipoUsuario = -1;
        for (Personal p : personal) {
            if (p.getUsuario().equals(credencial.getUsuario()) && p.getClave().equals(credencial.getClave())) {
                tipoUsuario = p.getRol();
                break;
            }
        }
        return tipoUsuario;
    }

    @Override
    public boolean registrarPaciente(Paciente paciente) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarPaciente(Paciente paciente) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarPaciente(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Paciente consultarPaciente(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Paciente> listarPaciente() throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean registrarValoracionFisica(ValoracionFisica valoracionFisica) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarValoracionFisica(ValoracionFisica valoracionFisica) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarValoracionFisica(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ValoracionFisica consultarValoracionFisica(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ValoracionFisica> listarValoracionFisica(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean registrarProgramaFisico(ProgramaFisico programaFisico) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarProgramaFisico(ProgramaFisico programaFisico) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarProgramaFisico(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ProgramaFisico consultarProgramaFisico(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProgramaFisico> listarProgramaFisico(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean registrarEjercicio(Ejercicio ejercicio) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarEjercicio(Ejercicio ejercicio) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarEjercicio(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Ejercicio consultarEjercicio(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Ejercicio> listarEjercicio(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean registrarAsistencia(Asistencia asistencia) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarAsistencia(Asistencia asistencia) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarAsistencia(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Asistencia consultarAsistencia(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Asistencia> listarAsistencia(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

}

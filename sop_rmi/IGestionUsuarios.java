package sop_rmi;

import java.util.List;

public interface IGestionUsuarios extends java.rmi.Remote {
    public boolean registrarPersonal(Personal personal) throws java.rmi.RemoteException;

    public boolean modificarPersonal(Personal personal) throws java.rmi.RemoteException;

    public boolean eliminarPersonal(int id) throws java.rmi.RemoteException;

    public Personal consultarPersonal(int id) throws java.rmi.RemoteException;

    public List<Personal> listarPersonal() throws java.rmi.RemoteException;

    public int abrirSesion(Credencial credencial) throws java.rmi.RemoteException;

    public boolean registrarPaciente(Paciente paciente) throws java.rmi.RemoteException;

    public boolean modificarPaciente(Paciente paciente) throws java.rmi.RemoteException;

    public boolean eliminarPaciente(int id) throws java.rmi.RemoteException;

    public Paciente consultarPaciente(int id) throws java.rmi.RemoteException;

    public List<Paciente> listarPaciente() throws java.rmi.RemoteException;

    public boolean registrarValoracionFisica(ValoracionFisica valoracionFisica) throws java.rmi.RemoteException;

    public boolean modificarValoracionFisica(ValoracionFisica valoracionFisica) throws java.rmi.RemoteException;

    public boolean eliminarValoracionFisica(int id) throws java.rmi.RemoteException;

    public ValoracionFisica consultarValoracionFisica(int id) throws java.rmi.RemoteException;

    public List<ValoracionFisica> listarValoracionFisica(int id) throws java.rmi.RemoteException;

    public boolean registrarProgramaFisico(ProgramaFisico programaFisico) throws java.rmi.RemoteException;

    public boolean modificarProgramaFisico(ProgramaFisico programaFisico) throws java.rmi.RemoteException;

    public boolean eliminarProgramaFisico(int id) throws java.rmi.RemoteException;

    public ProgramaFisico consultarProgramaFisico(int id) throws java.rmi.RemoteException;

    public List<ProgramaFisico> listarProgramaFisico(int id) throws java.rmi.RemoteException;

    public boolean registrarEjercicio(Ejercicio ejercicio) throws java.rmi.RemoteException;

    public boolean modificarEjercicio(Ejercicio ejercicio) throws java.rmi.RemoteException;

    public boolean eliminarEjercicio(int id) throws java.rmi.RemoteException;

    public Ejercicio consultarEjercicio(int id) throws java.rmi.RemoteException;

    public List<Ejercicio> listarEjercicio(int id) throws java.rmi.RemoteException;

    public boolean registrarAsistencia(Asistencia asistencia) throws java.rmi.RemoteException;

    public boolean modificarAsistencia(Asistencia asistencia) throws java.rmi.RemoteException;

    public boolean eliminarAsistencia(int id) throws java.rmi.RemoteException;

    public Asistencia consultarAsistencia(int id) throws java.rmi.RemoteException;

    public List<Asistencia> listarAsistencia(int id) throws java.rmi.RemoteException;
}

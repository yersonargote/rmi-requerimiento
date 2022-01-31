package gestion_usuarios.sop_rmi;

/**
 *
 * @author yerso
 */

import gestion_usuarios.dto.*;
import cliente.sop_rmi.INotificacion;
import java.util.List;

public interface IGestionUsuarios extends java.rmi.Remote {
    public boolean registrarCallback(INotificacion notificacion) throws java.rmi.RemoteException;
    
    public boolean registrarPersonal(PersonalDTO personal) throws java.rmi.RemoteException;

    public boolean modificarPersonal(PersonalDTO personal) throws java.rmi.RemoteException;

    public boolean eliminarPersonal(int id) throws java.rmi.RemoteException;

    public PersonalDTO consultarPersonal(int id) throws java.rmi.RemoteException;

    public List<PersonalDTO> listarPersonal() throws java.rmi.RemoteException;

    public int abrirSesion(CredencialDTO credencial) throws java.rmi.RemoteException;

    public boolean registrarPaciente(PacienteDTO paciente) throws java.rmi.RemoteException;

    public boolean modificarPaciente(PacienteDTO paciente) throws java.rmi.RemoteException;

    public boolean eliminarPaciente(int id) throws java.rmi.RemoteException;

    public PacienteDTO consultarPaciente(int id) throws java.rmi.RemoteException;

    public List<PacienteDTO> listarPaciente() throws java.rmi.RemoteException;

    public boolean registrarValoracionFisica(ValoracionFisicaDTO valoracionFisica) throws java.rmi.RemoteException;

    public boolean modificarValoracionFisica(ValoracionFisicaDTO valoracionFisica) throws java.rmi.RemoteException;

    public boolean eliminarValoracionFisica(int id) throws java.rmi.RemoteException;

    public ValoracionFisicaDTO consultarValoracionFisica(int id) throws java.rmi.RemoteException;

    public List<ValoracionFisicaDTO> listarValoracionFisica(int id) throws java.rmi.RemoteException;

    public boolean registrarProgramaFisico(ProgramaFisicoDTO programaFisico) throws java.rmi.RemoteException;

    public boolean modificarProgramaFisico(ProgramaFisicoDTO programaFisico) throws java.rmi.RemoteException;

    public boolean eliminarProgramaFisico(int id) throws java.rmi.RemoteException;

    public ProgramaFisicoDTO consultarProgramaFisico(int id) throws java.rmi.RemoteException;

    public List<ProgramaFisicoDTO> listarProgramaFisico(int id) throws java.rmi.RemoteException;

    public boolean registrarEjercicio(EjercicioDTO ejercicio) throws java.rmi.RemoteException;

    public boolean modificarEjercicio(EjercicioDTO ejercicio) throws java.rmi.RemoteException;

    public boolean eliminarEjercicio(int id) throws java.rmi.RemoteException;

    public EjercicioDTO consultarEjercicio(int id) throws java.rmi.RemoteException;

    public List<EjercicioDTO> listarEjercicio(int id) throws java.rmi.RemoteException;

    public boolean registrarAsistencia(AsistenciaDTO asistencia) throws java.rmi.RemoteException;

    public boolean modificarAsistencia(AsistenciaDTO asistencia) throws java.rmi.RemoteException;

    public boolean eliminarAsistencia(int id) throws java.rmi.RemoteException;

    public AsistenciaDTO consultarAsistencia(int id) throws java.rmi.RemoteException;

    public List<AsistenciaDTO> listarAsistencia(int id) throws java.rmi.RemoteException;
}

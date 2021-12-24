package gestion_usuarios.sop_rmi;

import gestion_usuarios.dto.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yerso
 */

public class GestionUsuarios extends UnicastRemoteObject implements IGestionUsuarios {

    private final List<PersonalDTO> personal;
    private final List<PacienteDTO> pacientes;
    private final List<CredencialDTO> usuarios;

    public GestionUsuarios() throws RemoteException {
        super();
        personal = new ArrayList<>();
        pacientes = new ArrayList<>();
        usuarios = new ArrayList<>();
        PersonalDTO admin = new PersonalDTO("cc", 12345678, "admin", "admin", "admin", "12345678");
        personal.add(admin);
        usuarios.add(admin);
    }

    @Override
    public boolean registrarPersonal(PersonalDTO personal) throws RemoteException {
        boolean registrado = false;
        int indice_per = this.getIndicePersonal(personal.getId());
        int indice_usu = this.getIndiceUsuario(personal.getUsuario(), personal.getClave());
        if (indice_per == -1 && indice_usu == -1) {
            this.personal.add(personal);
            this.usuarios.add(personal);
            registrado = true;
        }
        return registrado;
    }

    @Override
    public boolean modificarPersonal(PersonalDTO personal) throws RemoteException {
        boolean modificado = false;
        int indice_per = this.getIndicePersonal(personal.getId());
        int indice_usu = this.getIndiceUsuario(personal.getUsuario(), personal.getClave());
        if(indice_per != -1 && indice_usu != -1) {
            this.personal.set(indice_per, personal);
            this.usuarios.set(indice_usu, personal);
            modificado = true;
        }
        return modificado;
    }

    private int getIndiceUsuario(String usuario, String clave) throws RemoteException {
        int indice = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsuario().equals(usuario) && usuarios.get(i).getClave().equals(clave)) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    private int getIndicePersonal(int id) throws RemoteException {
        int indice = -1;
        for (int i = 0; i < this.personal.size(); i++) {
            if (this.personal.get(i).getId() == id) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    @Override
    public boolean eliminarPersonal(int id) throws RemoteException {
        boolean eliminado = false;
        int indice = this.getIndicePersonal(id);
        if (indice > 0) {
            this.personal.remove(indice);
            eliminado = true;
        }
        return eliminado;
    }

    @Override
    public PersonalDTO consultarPersonal(int id) throws RemoteException {
        int indice = this.getIndicePersonal(id);
        PersonalDTO personalDTO = null;
        if (indice > 0) {
            personalDTO = this.personal.get(indice);
        }
        return personalDTO;
    }

    @Override
    public List<PersonalDTO> listarPersonal() throws RemoteException {
        return this.personal;
    }

    @Override
    public int abrirSesion(CredencialDTO credencial) throws RemoteException {
        int tipoUsuario = -1;
        for (CredencialDTO usuario : this.usuarios) {
            if(usuario.getUsuario().equals(credencial.getUsuario()) && usuario.getClave().equals(credencial.getClave())){
                tipoUsuario = usuario.getRol();
                break;
            }
        }
        return tipoUsuario;
    }

    private int getIndicePaciente(int id) {
        int indice = -1;
        for (int i = 0; i < this.pacientes.size(); i++) {
            if (this.pacientes.get(i).getId() == id) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    @Override
    public boolean registrarPaciente(PacienteDTO paciente) throws RemoteException {
        boolean registrado = false;
        int indice = this.getIndicePaciente(paciente.getId());
        if (indice == -1) {
            this.pacientes.add(paciente);
            registrado = true;
        }
        return registrado;
    }

    @Override
    public boolean modificarPaciente(PacienteDTO paciente) throws RemoteException {
        boolean modificado = false;
        int indice = this.getIndicePaciente(paciente.getId());
        if (indice > 0) {
            this.pacientes.set(indice, paciente);
            modificado = true;
        }
        return modificado;
    }

    @Override
    public boolean eliminarPaciente(int id) throws RemoteException {
        boolean eliminado = false;
        int indice = this.getIndicePaciente(id);
        if (indice > 0) {
            this.pacientes.remove(indice);
            eliminado = true;
        }
        return eliminado;
    }

    @Override
    public PacienteDTO consultarPaciente(int id) throws RemoteException {
        PacienteDTO paciente = null;
        int indice = this.getIndicePaciente(id);
        if (indice > 0) {
            paciente = this.pacientes.get(indice);
        }
        return paciente;
    }

    @Override
    public List<PacienteDTO> listarPaciente() throws RemoteException {
        return this.pacientes;
    }

    @Override
    public boolean registrarValoracionFisica(ValoracionFisicaDTO valoracionFisica) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarValoracionFisica(ValoracionFisicaDTO valoracionFisica) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarValoracionFisica(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ValoracionFisicaDTO consultarValoracionFisica(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ValoracionFisicaDTO> listarValoracionFisica(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean registrarProgramaFisico(ProgramaFisicoDTO programaFisico) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarProgramaFisico(ProgramaFisicoDTO programaFisico) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarProgramaFisico(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ProgramaFisicoDTO consultarProgramaFisico(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProgramaFisicoDTO> listarProgramaFisico(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean registrarEjercicio(EjercicioDTO ejercicio) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarEjercicio(EjercicioDTO ejercicio) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarEjercicio(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public EjercicioDTO consultarEjercicio(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EjercicioDTO> listarEjercicio(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean registrarAsistencia(AsistenciaDTO asistencia) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarAsistencia(AsistenciaDTO asistencia) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eliminarAsistencia(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public AsistenciaDTO consultarAsistencia(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AsistenciaDTO> listarAsistencia(int id) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
}
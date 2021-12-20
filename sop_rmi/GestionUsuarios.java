package sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ArrayList;

public class GestionUsuarios extends UnicastRemoteObject implements IGestionUsuarios {

    private final List<Personal> personal;
    private final List<Paciente> pacientes;
    private final List<Credencial> usuarios;

    public GestionUsuarios() throws RemoteException {
        super();
        personal = new ArrayList<>();
        pacientes = new ArrayList<>();
        usuarios = new ArrayList<>();
        Personal admin = new Personal("admin", "12345678", 12345678, "admin", "admin"); 
        personal.add(admin);
        usuarios.add(admin);
    }

    @Override
    public boolean registrarPersonal(Personal personal) throws RemoteException {
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
    public boolean modificarPersonal(Personal personal) throws RemoteException {
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
    public Personal consultarPersonal(int id) throws RemoteException {
        int indice = this.getIndicePersonal(id);
        Personal personal = null;
        if (indice > 0) {
            personal = this.personal.get(indice);
        }
        return personal;
    }

    @Override
    public List<Personal> listarPersonal() throws RemoteException {
        return this.personal;
    }

    @Override
    public int abrirSesion(Credencial credencial) throws RemoteException {
        int tipoUsuario = -1;
        for (Credencial usuario : this.usuarios) {
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
    public boolean registrarPaciente(Paciente paciente) throws RemoteException {
        boolean registrado = false;
        int indice = this.getIndicePaciente(paciente.getId());
        if (indice == -1) {
            this.pacientes.add(paciente);
            registrado = true;
        }
        return registrado;
    }

    @Override
    public boolean modificarPaciente(Paciente paciente) throws RemoteException {
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
    public Paciente consultarPaciente(int id) throws RemoteException {
        Paciente paciente = null;
        int indice = this.getIndicePaciente(id);
        if (indice > 0) {
            paciente = this.pacientes.get(indice);
        }
        return paciente;
    }

    @Override
    public List<Paciente> listarPaciente() throws RemoteException {
        return this.pacientes;
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

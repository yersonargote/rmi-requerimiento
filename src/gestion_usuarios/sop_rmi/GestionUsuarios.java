package gestion_usuarios.sop_rmi;

import cliente.sop_rmi.INotificacion;
import gestion_usuarios.dto.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import seguimiento_usuarios.sop_rmi.ISeguimientoUsuarios;

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
    private ISeguimientoUsuarios seguimientoUsuarios;

    private List<INotificacion> callbacks;

    public GestionUsuarios() throws RemoteException {
        super();
        personal = new ArrayList<>();
        pacientes = new ArrayList<>();
        usuarios = new ArrayList<>();
        PersonalDTO admin = new PersonalDTO("cc", 12345678, "admin", "admin", "admin", "12345678");
        personal.add(admin);
        usuarios.add(admin);

        callbacks = new ArrayList<>();
    }

    public void setSeguimientoUsuarios(ISeguimientoUsuarios seguimientoUsuarios) {
        this.seguimientoUsuarios = seguimientoUsuarios;
    }

    @Override
    public boolean registrarPersonal(PersonalDTO personal) throws RemoteException {
        System.out.println("Registrando personal.");
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
        System.out.println("Modificando personal.");
        boolean modificado = false;
        int indice_per = this.getIndicePersonal(personal.getId());
        int indice_usu = this.getIndiceUsuario(personal.getUsuario(), personal.getClave());
        if (indice_per != -1 && indice_usu != -1) {
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
        System.out.println("Eliminando personal.");
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
        System.out.println("Consultando personal.");
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
        System.out.println("Abriendo sesion.");
        int tipoUsuario = -1;
        for (CredencialDTO usuario : this.usuarios) {
            if (usuario.getUsuario().equals(credencial.getUsuario()) && usuario.getClave().equals(credencial.getClave())) {
                tipoUsuario = usuario.getRol();
                String mensaje = String.format("Usuario %s con rol %d a ingresado al sistema.", credencial.getUsuario(), tipoUsuario);
                this.seguimientoUsuarios.notificacion(mensaje);
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
        System.out.println("Registrando paciente.");
        boolean registrado = false;
        int indice = this.getIndicePaciente(paciente.getId());
        if (indice == -1) {
            this.pacientes.add(paciente);
            this.usuarios.add(paciente);
            registrado = true;
            for (int jdx = 0; jdx < callbacks.size(); jdx++) {
                INotificacion notificacion = callbacks.get(jdx);
                try {
                    notificacion.notificar(
                            String.format("Id: %d y nombre %s. Esta disponible para ser valorado.%n",
                                    paciente.getId(), paciente.getNombre())
                    );
                } catch (RemoteException e) {
                    System.out.println("Error: En el callback al registrar paciente.");
                }
            }
        }
        return registrado;
    }

    @Override
    public boolean modificarPaciente(PacienteDTO paciente) throws RemoteException {
        System.out.println("Modificando paciente.");
        boolean modificado = false;
        int indice = this.getIndicePaciente(paciente.getId());
        if (indice >= 0) {
            this.pacientes.set(indice, paciente);
            modificado = true;
        }
        return modificado;
    }

    @Override
    public boolean eliminarPaciente(int id) throws RemoteException {
        System.out.println("Eliminando paciente.");
        boolean eliminado = false;
        int indice = this.getIndicePaciente(id);
        if (indice >= 0) {
            this.pacientes.remove(indice);
            eliminado = true;
        }
        return eliminado;
    }

    @Override
    public PacienteDTO consultarPaciente(int id) throws RemoteException {
        System.out.println("Consultando Paciente.");
        PacienteDTO paciente = null;
        int indice = this.getIndicePaciente(id);
        if (indice >= 0) {
            paciente = this.pacientes.get(indice);
        }
        return paciente;
    }

    @Override
    public List<PacienteDTO> listarPaciente() throws RemoteException {
        System.out.println("Listando pacientes.");
        return this.pacientes;
    }

    @Override
    public boolean registrarValoracionFisica(ValoracionFisicaDTO valoracionFisica) throws RemoteException {
        String info = valoracionFisica.toString();
        return this.seguimientoUsuarios.addHistorial(valoracionFisica.getIdPaciente(), info);
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
        System.out.println("Ejecutando valoracion fisica.");
        String path = String.format("%s\\src\\seguimiento_usuarios\\historial\\usuario%d.txt", System.getProperty("user.dir"), id);
        ValoracionFisicaDTO valoracionFisica = null;
        File file = new File(path);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes.length == 10) {
                    valoracionFisica = new ValoracionFisicaDTO(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]),
                            partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]), Integer.parseInt(partes[5]),
                            Integer.parseInt(partes[6]), Integer.parseInt(partes[7]), Integer.parseInt(partes[8]), partes[9]);
                }
            }
        } catch (IOException ex) {
        }
        if (valoracionFisica != null) {
            System.out.println("valoracion fisica " + valoracionFisica.getIdPaciente());
        }
        return valoracionFisica;
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

    @Override
    public boolean registrarCallback(INotificacion notificacion) throws RemoteException {
        System.out.println("Registrando callback");
        for (int i = 0; i < callbacks.size(); i++) {
            if (callbacks.get(i).equals(notificacion)) {
                return false;
            }
        }
        callbacks.add(notificacion);
        return true;
    }
}

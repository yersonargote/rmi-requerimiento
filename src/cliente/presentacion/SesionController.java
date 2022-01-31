package cliente.presentacion;

import cliente.negocio.GestorUsuarios;
import cliente.sop_rmi.INotificacion;
import cliente.sop_rmi.Notificacion;
import cliente.utilidades.RegistroS;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import gestion_usuarios.dto.CredencialDTO;
import mvcf.AActionController;
import mvcf.AModel;
import mvcf.AView;

/**
 *
 * @author yerso
 */
public class SesionController extends AActionController {
    private final GestorUsuarios gestorUsuarios;
    private final GUIAbrirSesion vista;

    public SesionController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestorUsuarios = (GestorUsuarios) myModel;
        this.vista = (GUIAbrirSesion) myView;
    }

    private void menuAdmin() {
        GUIMenuAdmin menuAdmin = new GUIMenuAdmin();
        AdminController adminController = new AdminController(this.gestorUsuarios, menuAdmin);

        this.vista.setVisible(false);
        menuAdmin.setVisible(true);

        menuAdmin.getBtnRegistrar().addActionListener(adminController);
        menuAdmin.getBtnRegistrar().setActionCommand("registrar");
        menuAdmin.getBtnConsultar().addActionListener(adminController);
        menuAdmin.getBtnConsultar().setActionCommand("consultar");
        menuAdmin.getBtnListar().addActionListener(adminController);
        menuAdmin.getBtnListar().setActionCommand("listar");
    }
    
    private void menuSecretaria() {
        GUIMenuSecretaria menuSecretaria = new GUIMenuSecretaria();
        SecretariaController secretariaController = new SecretariaController(this.gestorUsuarios, menuSecretaria);
        
        this.vista.setVisible(false);
        menuSecretaria.setVisible(true);
        
        menuSecretaria.getBtnRegistrar().addActionListener(secretariaController);
        menuSecretaria.getBtnRegistrar().setActionCommand("registrar");
        menuSecretaria.getBtnConsultar().addActionListener(secretariaController);
        menuSecretaria.getBtnConsultar().setActionCommand("consultar");
        menuSecretaria.getBtnListar().addActionListener(secretariaController);
        menuSecretaria.getBtnListar().setActionCommand("listar");
    }
    
    private void registrarCallback() {
        try {
            INotificacion callback = new Notificacion();
            RegistroS.RegistrarObjetoRemoto(callback, "localhost", 12345, "callback");
            this.gestorUsuarios.getGestionUsuarios().registrarCallback(callback);
        } catch (RemoteException ex) {
            System.out.println("Error al registrar callback.");
        }
    }
    
    private void menuPaf() {
        GUIMenuPaf menuPaf = new GUIMenuPaf();
        PafController pafController = new PafController(this.gestorUsuarios, menuPaf);
        
        this.vista.setVisible(false);
        menuPaf.setVisible(true);
        
        // botones
        menuPaf.getBtnRegistrarSemana().addActionListener(pafController);
        menuPaf.getBtnRegistrarSemana().setActionCommand("semana");
        menuPaf.getBtnElaborar().addActionListener(pafController);
        menuPaf.getBtnElaborar().setActionCommand("programa");
        menuPaf.getBtnRealizar().addActionListener(pafController);
        menuPaf.getBtnRealizar().setActionCommand("valoracion");
        menuPaf.getBtnAsistencia().addActionListener(pafController);
        menuPaf.getBtnAsistencia().setActionCommand("asistencia");
    }
    
    private void menuPaciente() {
        GUIPaciente menuPaciente = new GUIPaciente();
        PacienteController pacienteController = new PacienteController(this.gestorUsuarios, menuPaciente);
        
        this.vista.setVisible(false);
        menuPaciente.setVisible(true);
        
        // botones
        menuPaciente.getBtnConsultarValoracion().addActionListener(pacienteController);
        menuPaciente.getBtnConsultarValoracion().setActionCommand("valoracion");
//        menuPaciente.getBtnElaborar().addActionListener(pafController);
//        menuPaciente.getBtnElaborar().setActionCommand("programa");
//        menuPaciente.getBtnRealizar().addActionListener(pafController);
//        menuPaciente.getBtnRealizar().setActionCommand("valoracion");
    }

    @Override
    public void actualizar(ActionEvent arg0) {
        switch (arg0.getActionCommand()) {
            case "login":
                String usuario = this.vista.getTxtUsuarioLogin().getText();
                String clave = String.valueOf(this.vista.getPssClaveLogin().getPassword());
                int tipoUsuario = -1;
                CredencialDTO credencial = new CredencialDTO(usuario, clave);
                try{
                    tipoUsuario = this.gestorUsuarios.getGestionUsuarios().abrirSesion(credencial);
                }catch(RemoteException ex){}

                switch (tipoUsuario) {
                    case 0:
                        menuAdmin();
                        break;
                    case 1:
                        menuSecretaria();
                        break;
                    case 2:
                        registrarCallback();
                        menuPaf();
                        break;
                    case 3:
                        menuPaciente();
                        break;
                    default:
                        this.vista.getLblMensajeErrorLogin().setText("Credenciales NO VALIDAS");
                        break;
                }
                break;
        }
    }

}

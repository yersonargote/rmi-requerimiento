package cliente.presentacion;

import cliente.negocio.GestorUsuarios;
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
    private final GestorUsuarios gestor;
    private final GUIAbrirSesion vista;

    public SesionController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestor = (GestorUsuarios) myModel;
        this.vista = (GUIAbrirSesion) myView;
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
                tipoUsuario = this.gestor.getGestor().abrirSesion(credencial);
            }catch(RemoteException ex){}

            switch (tipoUsuario) {
                case 0:
                    this.vista.getLblMensajeErrorLogin().setText("Admin NO Implementado");
                    break;
                case 1:
                    this.vista.getLblMensajeErrorLogin().setText("Secretaria NO Implementado");
                    break;
                case 2:
                    this.vista.getLblMensajeErrorLogin().setText("Paf NO Implementado");
                    break;
                case 3:
                    this.vista.getLblMensajeErrorLogin().setText("Paciente NO Implementado");
                    break;
                default:
                    this.vista.getLblMensajeErrorLogin().setText("Credenciales NO VALIDAS");
                    break;
            }
                break;
        }
    }
}

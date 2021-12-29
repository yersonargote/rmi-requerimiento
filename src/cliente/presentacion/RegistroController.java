package cliente.presentacion;

import cliente.negocio.GestorUsuarios;
import cliente.utilidades.Parse;
import cliente.utilidades.RegistroC;
import java.awt.event.ActionEvent;

import gestion_usuarios.sop_rmi.IGestionUsuarios;
import mvcf.AActionController;
import mvcf.AModel;
import mvcf.AView;

/**
 *
 * @author yerso
 */
public class RegistroController extends AActionController {

    private GestorUsuarios gestor;
    private final GUIPrincipal vista;

    public RegistroController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestor = (GestorUsuarios) myModel;
        this.vista = (GUIPrincipal) myView;
    }

    @Override
    public void actualizar(ActionEvent arg0) {
        switch (arg0.getActionCommand()) {
            case "registro":
                String ip = this.vista.getTxtIp().getText();
                int puerto = Parse.StringToInt(this.vista.getTxtPuerto().getText());
                this.gestor.setGestionUsuarios((IGestionUsuarios) RegistroC.getRemoteObj(ip, puerto, "gestionUsuarios"));
                boolean registrado = ( this.gestor.getGestionUsuarios() != null);
                if (registrado) {
                    GUIAbrirSesion guiAbrirSesion = new GUIAbrirSesion();
                    SesionController sesionController = new SesionController(this.gestor, guiAbrirSesion);

                    this.vista.setVisible(false);
                    guiAbrirSesion.setVisible(true);

                    guiAbrirSesion.getBtnLogin().addActionListener(sesionController);
                    guiAbrirSesion.getBtnLogin().setActionCommand("login");
                } else {
                    this.vista.getLblMensajeErrorLogin().setText("Problema al registrar el objeto remoto del cliente.");
                }
                break;
        }
    }
}

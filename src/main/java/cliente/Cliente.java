package cliente;

import cliente.negocio.GestorUsuarios;
import cliente.presentacion.GUIPrincipal;
import cliente.presentacion.RegistroController;
import gestion_usuarios.sop_rmi.GestionUsuarios;
import gestion_usuarios.sop_rmi.IGestionUsuarios;

import java.rmi.RemoteException;

/**
 *
 * @author yerso
 */


public class Cliente {

    public static void main(String[] args) {
        IGestionUsuarios gestion;
        GestorUsuarios gestor;

        try {
            gestion = new GestionUsuarios();
        } catch(RemoteException ex) {
            gestion = null;
        }

        gestor = new GestorUsuarios(gestion);
        
        // GUI principal
        GUIPrincipal guiPrincipal = new GUIPrincipal();
        gestor.addView(guiPrincipal);
        RegistroController registroControl = new RegistroController(gestor, guiPrincipal);
        guiPrincipal.setVisible(true);

        // Enlaza el action controller de los botones al controlador y fija el comando de acción
        guiPrincipal.getBtnRegistro().addActionListener(registroControl);
        guiPrincipal.getBtnRegistro().setActionCommand("registro");
    }
}

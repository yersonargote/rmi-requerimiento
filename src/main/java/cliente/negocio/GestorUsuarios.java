package cliente.negocio;

import gestion_usuarios.sop_rmi.IGestionUsuarios;
import mvcf.AModel;

/**
 *
 * @author yerso
 */
public class GestorUsuarios extends AModel {
    private IGestionUsuarios gestor;
    
    public GestorUsuarios(IGestionUsuarios gestor) {
        this.gestor = gestor;
    }
    
    public IGestionUsuarios getGestionUsuarios() {
        return this.gestor;
    }

    public void setGestionUsuarios(IGestionUsuarios gestionUsuarios) {
        this.gestor = gestionUsuarios;
    }
}

package cliente.negocio;

import gestion_usuarios.sop_rmi.IGestionUsuarios;
import mvcf.AModel;

/**
 *
 * @author yerso
 */
public class GestorUsuarios extends AModel {
    private final IGestionUsuarios gestor;
    
    public GestorUsuarios(IGestionUsuarios gestor) {
        this.gestor = gestor;
    }
    
    public IGestionUsuarios getGestor() {
        return this.gestor;
    }
}

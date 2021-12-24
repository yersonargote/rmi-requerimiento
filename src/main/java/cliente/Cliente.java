package cliente;

/**
 *
 * @author yerso
 */

import cliente.utilidades.RegistroC;
import gestion_usuarios.sop_rmi.IGestionUsuarios;

public class Cliente {

  private IGestionUsuarios gestionUsuarios = null;
  
  public boolean registarCliente(String ip, int puerto) {
      gestionUsuarios = (IGestionUsuarios) RegistroC.getRemoteObj(ip, puerto, "gestionUsuarios");
      return (gestionUsuarios != null);
  }
  
  public IGestionUsuarios getGestor() {
      return this.gestionUsuarios;
  }
}

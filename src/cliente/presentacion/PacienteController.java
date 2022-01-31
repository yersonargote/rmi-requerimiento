package cliente.presentacion;

import cliente.negocio.GestorUsuarios;
import gestion_usuarios.dto.ValoracionFisicaDTO;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import mvcf.AActionController;
import mvcf.AModel;
import mvcf.AView;

/**
 *
 * @author yerso
 */
public class PacienteController extends AActionController {
    private GestorUsuarios gestor;
    private GUIPaciente vista;

    public PacienteController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestor = (GestorUsuarios) myModel;
        this.vista = (GUIPaciente) myView;
    }

    @Override
    public void actualizar(ActionEvent arg0) {
        switch (arg0.getActionCommand()) {
            case "plan":
                consultarPlanFisico();
                break;
            case "asistencia":
                consultarAsistencia();
                break;
            case "valoracion":
                consultarValoracion();
                break;
        }

    }

    private void consultarPlanFisico() {
       
    }

    private void consultarAsistencia() {
    }

    private void consultarValoracion() {
        int id = Integer.parseInt(this.vista.getTxtIdValoracion().getText());
        
        ValoracionFisicaDTO valoracionFisicaDTO  = null;
        
        try {
            valoracionFisicaDTO = this.gestor.getGestionUsuarios().consultarValoracionFisica(id);
        } catch (RemoteException ex) {
            this.vista.getLblValoracionRes().setText("Error: No se pudo consultar la valoracion fisica del paciente\n" + ex.getMessage());
        }

        if (valoracionFisicaDTO != null) {
            this.vista.getLblValoracionRes().setText("Información: Valoracion fisica encontrada.");
        } else {
            this.vista.getLblValoracionRes().setText("Error: Valoracion fisica NO encontrada.");
        }
    }

}

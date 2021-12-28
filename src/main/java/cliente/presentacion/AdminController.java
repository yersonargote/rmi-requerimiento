package cliente.presentacion;

import cliente.negocio.GestorUsuarios;
import cliente.utilidades.Parse;
import gestion_usuarios.dto.PersonalDTO;
import mvcf.AActionController;
import mvcf.AModel;
import mvcf.AView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.List;

public class AdminController extends AActionController {

    private GestorUsuarios gestor;
    private final GUIMenuAdmin vista;

    public AdminController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestor = (GestorUsuarios) myModel;
        this.vista = (GUIMenuAdmin) myView;
    }

    @Override
    public void actualizar(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "registrar":
                registrarPersonal();
                break;
            case "consultar":
                consultarPersonal();
                break;
            case "listar":
                listarPersonal();
                break;
        }
    }

    private void registrarPersonal() {
        String tipoId = "", nombreCompleto, ocupacion = "", usuario, clave;
        int id;
        boolean registrado = false;

        if (this.vista.getRbtnCCReg().isSelected()) {
            tipoId = "cc";
        } else if (this.vista.getRbtnPasaporteReg().isSelected()) {
            tipoId = "pasaporte";
        } else if (this.vista.getRbtnTIReg().isSelected()) {
            tipoId = "ti";
        }

        nombreCompleto = this.vista.getTxtNombreReg().getText();
        id = Parse.StringToInt(this.vista.getTxtIdReg().getText());

        if (this.vista.getRbtnSecretariaReg().isSelected()) {
            ocupacion = "secretaria";
        } else if (this.vista.getRbtnPaf().isSelected()) {
            ocupacion = "paf";
        }

        usuario = this.vista.getTxtUsuarioReg().getText();
        clave = String.valueOf(this.vista.getPssClaveReg().getPassword());
        PersonalDTO personal = new PersonalDTO(tipoId, id, nombreCompleto, ocupacion, usuario, clave);
        try {
            registrado = this.gestor.getGestionUsuarios().registrarPersonal(personal);
        } catch (RemoteException ex) {
            this.vista.getLblMensajeErrorReg().setText("Error: No se pudo registrar el personal\n" + ex.getMessage());
        }

        if (registrado) {
            this.vista.getLblMensajeErrorReg().setText("Información: Personal registrado");
        } else {
            this.vista.getLblMensajeErrorReg().setText("Error: Personal NO registrado");
        }
    }

    private void consultarPersonal() {
        PersonalDTO personal = null;
        int id = Parse.StringToInt(this.vista.getTxtConsultaConsultar().getText());
        try {
            personal = this.gestor.getGestionUsuarios().consultarPersonal(id);
        } catch (RemoteException ex) {
            this.vista.getLblMensajeErrorConsultar().setText("Error al consultar personal.");
        }

        if (personal != null) {
            this.vista.getLblMensajeErrorConsultar().setText("Personal encontrado.");
            this.vista.getLblNombreConsultaRes().setText(personal.getNombreCompleto());
            this.vista.getLblOcupacionConsultaRes().setText(personal.getOcupacion());
            this.vista.getLblUsuarioConsultaRes().setText(personal.getUsuario());
        } else {
            this.vista.getLblMensajeErrorConsultar().setText("Personal no encontrado.");
            this.vista.getLblNombreConsultaRes().setText("-");
            this.vista.getLblOcupacionConsultaRes().setText("-");
            this.vista.getLblUsuarioConsultaRes().setText("-");
        }
    }

    private void listarPersonal() {
        List<PersonalDTO> personal = null;
        DefaultTableModel modelo = (DefaultTableModel) this.vista.getTblListaPersonal().getModel();
        Object fila[] = new Object[4];
        modelo.setRowCount(0);

        try {
            personal = this.gestor.getGestionUsuarios().listarPersonal();
        } catch (RemoteException ex) {
            this.vista.getLblMensajeErrorListar().setText("Error al listar personal.");
        }

        if (personal != null) {
            for (PersonalDTO per : personal) {
                fila[0] = per.getId();
                fila[1] = per.getNombreCompleto();
                fila[2] = per.getOcupacion();
                fila[3] = per.getUsuario();
                modelo.addRow(fila);
            }
        }
    }
}

package gestion_usuarios.dto;

/**
 *
 * @author yerso
 */

public class PersonalDTO extends CredencialDTO {
    private String tipoId;
    private int id;
    private String nombreCompleto;
    private String ocupacion;

    public PersonalDTO(String tipoId, int id, String nombreCompleto, String ocupacion, String usuario, String clave) {
        super(usuario, clave);
        this.tipoId = tipoId;
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.ocupacion = ocupacion;
        this.setRol();
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    private void setRol() {
        int rol;
        switch (this.ocupacion) {
            case "admin":
                rol = 0;
                break;
            case "secretaria":
                rol = 1;
                break;
            case "paf":
                rol = 2;
                break;
            default:
                rol = -1;
                break;
        }
        super.rol = rol;
    }
}

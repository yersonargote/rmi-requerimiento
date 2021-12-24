package gestion_usuarios.dto;

/**
 *
 * @author yerso
 */

public class PersonalDTO extends CredencialDTO {
    private int id;
    private String nombreCompleto;
    private String ocupacion;

    public PersonalDTO(String usuario, String clave, int id, String nombreCompleto, String ocupacion) {
        super(usuario, clave);
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.ocupacion = ocupacion;
        this.setRol();
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

package sop_rmi;

public class Personal extends Credencial {
    String tipoId;
    int id;
    String nombreCompleto;
    String ocupacion;

    public Personal(String usuario, String clave, String tipoId, int id, String nombreCompleto, String ocupacion) {
        super(usuario, clave);
        this.tipoId = tipoId;
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.ocupacion = ocupacion;
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

    public int getRol() {
        int rol = -1;
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
            case "docente":
                rol = 3;
                break;
            case "administrativo":
                rol = 3;
                break;
            default:
                rol = -1;
                break;
        }
        return rol;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

}

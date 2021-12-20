package sop_rmi;

public class Paciente extends Credencial {
    private int id;
    private String nombre;
    private String facultad;
    private String tipoUsuario;
    private String fechaIngreso;
    private String patologia;

    public Paciente(String usuario, String clave, int id, String nombre, String facultad, String tipoUsuario,
            String fechaIngreso, String patologia) {
        super(usuario, clave);
        this.id = id;
        this.nombre = nombre;
        this.facultad = facultad;
        this.tipoUsuario = tipoUsuario;
        this.fechaIngreso = fechaIngreso;
        this.patologia = patologia;
        super.rol = 3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }
}

package sop_rmi;

public class Asistencia implements java.io.Serializable {
    int id;
    int idPaciente;
    String fecha;
    String observacion;

    public Asistencia(int id, int idPaciente, String fecha, String observacion) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}

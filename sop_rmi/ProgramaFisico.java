package sop_rmi;

import java.util.List;

public class ProgramaFisico implements java.io.Serializable {
    int id;
    int idPaciente;
    String fechaInicio;
    List<ProgramaSemana> semanas;

    public ProgramaFisico(int id, int idPaciente, String fechaInicio, List<ProgramaSemana> semanas) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.fechaInicio = fechaInicio;
        this.semanas = semanas;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<ProgramaSemana> getSemanas() {
        return semanas;
    }

    public void setSemanas(List<ProgramaSemana> semanas) {
        this.semanas = semanas;
    }

}

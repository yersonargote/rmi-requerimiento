
package gestion_usuarios.dto;

/**
 *
 * @author yerso
 */

import java.util.List;

public class ProgramaFisicoDTO implements java.io.Serializable {
    int id;
    int idPaciente;
    String fechaInicio;
    List<ProgramaSemanaDTO> semanas;

    public ProgramaFisicoDTO(int id, int idPaciente, String fechaInicio, List<ProgramaSemanaDTO> semanas) {
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

    public List<ProgramaSemanaDTO> getSemanas() {
        return semanas;
    }

    public void setSemanas(List<ProgramaSemanaDTO> semanas) {
        this.semanas = semanas;
    }

}

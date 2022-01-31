package gestion_usuarios.dto;

/**
 *
 * @author yerso
 */

import java.util.List;

public class ProgramaSemanaDTO implements java.io.Serializable {
   String semana;
   List<EjercicioDTO> ejercicios;

   public ProgramaSemanaDTO(String semana, List<EjercicioDTO> ejercicios) {
      this.semana = semana;
      this.ejercicios = ejercicios;
   }

   public String getSemana() {
      return semana;
   }

   public void setSemana(String dia) {
      this.semana = semana;
   }

   public List<EjercicioDTO> getEjercicios() {
      return ejercicios;
   }

   public void setEjercicios(List<EjercicioDTO> ejercicios) {
      this.ejercicios = ejercicios;
   }

}
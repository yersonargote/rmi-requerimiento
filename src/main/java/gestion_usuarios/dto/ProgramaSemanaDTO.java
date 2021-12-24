package gestion_usuarios.dto;

/**
 *
 * @author yerso
 */

import java.util.List;

public class ProgramaSemanaDTO implements java.io.Serializable {
   int dia;
   List<EjercicioDTO> ejercicios;

   public ProgramaSemanaDTO(int dia, List<EjercicioDTO> ejercicios) {
      this.dia = dia;
      this.ejercicios = ejercicios;
   }

   public int getDia() {
      return dia;
   }

   public void setDia(int dia) {
      this.dia = dia;
   }

   public List<EjercicioDTO> getEjercicios() {
      return ejercicios;
   }

   public void setEjercicios(List<EjercicioDTO> ejercicios) {
      this.ejercicios = ejercicios;
   }

}
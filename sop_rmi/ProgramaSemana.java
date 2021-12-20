package sop_rmi;

import java.util.List;

public class ProgramaSemana implements java.io.Serializable {
   int dia;
   List<Ejercicio> ejercicios;

   public ProgramaSemana(int dia, List<Ejercicio> ejercicios) {
      this.dia = dia;
      this.ejercicios = ejercicios;
   }

   public int getDia() {
      return dia;
   }

   public void setDia(int dia) {
      this.dia = dia;
   }

   public List<Ejercicio> getEjercicios() {
      return ejercicios;
   }

   public void setEjercicios(List<Ejercicio> ejercicios) {
      this.ejercicios = ejercicios;
   }

}
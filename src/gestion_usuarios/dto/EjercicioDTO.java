package gestion_usuarios.dto;

/**
 *
 * @author yerso
 */

public class EjercicioDTO implements java.io.Serializable {
    private int id;
    private String nombre;
    private int repeticiones;
    private float peso;

    public EjercicioDTO(int id, String nombre, int repeticiones, float peso) {
        this.id = id;
        this.nombre = nombre;
        this.repeticiones = repeticiones;
        this.peso = peso;
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

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    } 
}

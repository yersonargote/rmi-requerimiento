package sop_rmi;

public class ValoracionFisica implements java.io.Serializable {
    int id;
    int idPaciente;
    String fecha;
    int frecuenciaCardiacaReposo;
    int frecuenciaCardiacaActiva;
    int estatura;
    int brazo;
    int pecho;
    int cintura;
    String estado;

    public ValoracionFisica(int id, int idPaciente, String fecha, int frecuenciaCardiacaReposo,
            int frecuenciaCardiacaActiva, int estatura, int brazo, int pecho, int cintura, String estado) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.frecuenciaCardiacaReposo = frecuenciaCardiacaReposo;
        this.frecuenciaCardiacaActiva = frecuenciaCardiacaActiva;
        this.estatura = estatura;
        this.brazo = brazo;
        this.pecho = pecho;
        this.cintura = cintura;
        this.estado = estado;
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

    public int getFrecuenciaCardiacaReposo() {
        return frecuenciaCardiacaReposo;
    }

    public void setFrecuenciaCardiacaReposo(int frecuenciaCardiacaReposo) {
        this.frecuenciaCardiacaReposo = frecuenciaCardiacaReposo;
    }

    public int getFrecuenciaCardiacaActiva() {
        return frecuenciaCardiacaActiva;
    }

    public void setFrecuenciaCardiacaActiva(int frecuenciaCardiacaActiva) {
        this.frecuenciaCardiacaActiva = frecuenciaCardiacaActiva;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public int getBrazo() {
        return brazo;
    }

    public void setBrazo(int brazo) {
        this.brazo = brazo;
    }

    public int getPecho() {
        return pecho;
    }

    public void setPecho(int pecho) {
        this.pecho = pecho;
    }

    public int getCintura() {
        return cintura;
    }

    public void setCintura(int cintura) {
        this.cintura = cintura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
package co.edu.uniquindio.poo.model;

public class Tecnico {
    private String codigoTecnico;
    private String nombreTecnico;
    private String documentoTecnico;
    private Especialidad especialidad;
    private EstadoLaboral estadoLaboral;

    public Tecnico(String codigoTecnico, String nombreTecnico, String documentoTecnico, Especialidad especialidad, EstadoLaboral estadoLaboral) {
        this.codigoTecnico = codigoTecnico;
        this.nombreTecnico = nombreTecnico;
        this.documentoTecnico = documentoTecnico;
        this.especialidad = especialidad;
        this.estadoLaboral = estadoLaboral;
    }

    public String getCodigoTecnico() {
        return codigoTecnico;
    }

    public void setCodigoTecnico(String codigoTecnico) {
        this.codigoTecnico = codigoTecnico;
    }

    public String getNombreTecnico() {
        return nombreTecnico;
    }

    public void setNombreTecnico(String nombreTecnico) {
        this.nombreTecnico = nombreTecnico;
    }

    public String getDocumentoTecnico() {
        return documentoTecnico;
    }

    public void setDocumentoTecnico(String documentoTecnico) {
        this.documentoTecnico = documentoTecnico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public EstadoLaboral getEstadoLaboral() {
        return estadoLaboral;
    }

    public void setEstadoLaboral(EstadoLaboral estadoLaboral) {
        this.estadoLaboral = estadoLaboral;
    }
}

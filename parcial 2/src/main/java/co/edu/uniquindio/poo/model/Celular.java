package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Celular extends Equipo{
    private String sistemaOperativo;
    private int capacidadBateria;
    private boolean tieneCompatibilidad5G;

    public Celular(String codigoEquipo, String numeroSerie, String marca, String modelo, LocalDate anoFabricacion, String descripcionEstadoFisico, String capacidadAlmacenamiento, String sistemaOperativo, int capacidadBateria, boolean tieneCompatibilidad5G) {
        super(codigoEquipo, numeroSerie, marca, modelo, anoFabricacion, descripcionEstadoFisico, capacidadAlmacenamiento);
        this.sistemaOperativo = sistemaOperativo;
        this.capacidadBateria = capacidadBateria;
        this.tieneCompatibilidad5G = tieneCompatibilidad5G;
    }
}

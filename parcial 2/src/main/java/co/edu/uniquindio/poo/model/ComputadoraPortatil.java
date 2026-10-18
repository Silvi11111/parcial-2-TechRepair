package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class ComputadoraPortatil extends Equipo {
    private double tamanoPantalla;
    private String memoriaRam;
    private boolean tieneBateriaExtraible;

    public ComputadoraPortatil(String codigoEquipo, String numeroSerie, String marca, String modelo, LocalDate anoFabricacion, String descripcionEstadoFisico, String capacidadAlmacenamiento, double tamanoPantalla, String memoriaRam, boolean tieneBateriaExtraible) {
        super(codigoEquipo, numeroSerie, marca, modelo, anoFabricacion, descripcionEstadoFisico, capacidadAlmacenamiento);
        this.tamanoPantalla = tamanoPantalla;
        this.memoriaRam = memoriaRam;
        this.tieneBateriaExtraible = tieneBateriaExtraible;
    }
}

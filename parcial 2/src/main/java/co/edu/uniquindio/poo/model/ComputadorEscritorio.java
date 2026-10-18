package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class ComputadorEscritorio extends Equipo{
    private String procesador;
    private String memoria;
    private boolean tieneTarjetaGraficaDedicada;

    public ComputadorEscritorio(String codigoEquipo, String numeroSerie, String marca, String modelo, LocalDate anoFabricacion, String descripcionEstadoFisico, String capacidadAlmacenamiento, String procesador, String memoria, boolean tieneTarjetaGraficaDedicada) {
        super(codigoEquipo, numeroSerie, marca, modelo, anoFabricacion, descripcionEstadoFisico, capacidadAlmacenamiento);
        this.procesador = procesador;
        this.memoria = memoria;
        this.tieneTarjetaGraficaDedicada = tieneTarjetaGraficaDedicada;
    }
}

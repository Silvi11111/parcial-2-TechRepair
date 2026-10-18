package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public abstract class Equipo {
    private String codigoEquipo;
    private String numeroSerie;
    private String marca;
    private String modelo;
    private LocalDate anoFabricacion;
    private String descripcionEstadoFisico;
    private String capacidadAlmacenamiento;

    public Equipo(String codigoEquipo, String numeroSerie, String marca, String modelo, LocalDate anoFabricacion, String descripcionEstadoFisico, String capacidadAlmacenamiento) {
        this.codigoEquipo = codigoEquipo;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
        this.descripcionEstadoFisico = descripcionEstadoFisico;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getAnoFabricacion() {
        return anoFabricacion;
    }

    public String getDescripcionEstadoFisico() {
        return descripcionEstadoFisico;
    }

    public String getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }
}

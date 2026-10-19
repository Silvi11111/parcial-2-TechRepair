package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Equipo {
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

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(LocalDate anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public String getDescripcionEstadoFisico() {
        return descripcionEstadoFisico;
    }

    public void setDescripcionEstadoFisico(String descripcionEstadoFisico) {
        this.descripcionEstadoFisico = descripcionEstadoFisico;
    }

    public String getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(String capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }


}

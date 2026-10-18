package co.edu.uniquindio.poo.model;

public abstract class Servicio {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double tarifaBase;

    public Servicio(String codigo, String nombre, String descripcion, double tarifaBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifaBase = tarifaBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }
}
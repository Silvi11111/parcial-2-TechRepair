package co.edu.uniquindio.poo.model;

public class Repuesto {
    private  String codigoRepuesto;
    private String nombreRepuesto;
    private int cantidadDisponible;
    private String descripcion;
    private String categoriaCompatible;
    private double precioUnitario;

    public Repuesto(String codigoRepuesto, String nombreRepuesto, int cantidadDisponible, String descripcion, String categoriaCompatible, double precioUnitario) {
        this.codigoRepuesto = codigoRepuesto;
        this.nombreRepuesto = nombreRepuesto;
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion = descripcion;
        this.categoriaCompatible = categoriaCompatible;
        this.precioUnitario = precioUnitario;
    }

    public String getCodigoRepuesto() {
        return codigoRepuesto;
    }

    public void setCodigoRepuesto(String codigoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoriaCompatible() {
        return categoriaCompatible;
    }

    public void setCategoriaCompatible(String categoriaCompatible) {
        this.categoriaCompatible = categoriaCompatible;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}

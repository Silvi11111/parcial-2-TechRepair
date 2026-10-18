package co.edu.uniquindio.poo.model;

public class DetalleRepuesto {
    private int cantidadUsada;
    private  Repuesto repuesto;
    private double precioUnitarioAplicado;

    public DetalleRepuesto(int cantidadUsada, Repuesto repuesto, double precioUnitarioAplicado) {
        this.cantidadUsada = cantidadUsada;
        this.repuesto = repuesto;
        this.precioUnitarioAplicado = precioUnitarioAplicado;
    }

    public int getCantidadUsada() {
        return cantidadUsada;
    }

    public void setCantidadUsada(int cantidadUsada) {
        this.cantidadUsada = cantidadUsada;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    public double getPrecioUnitarioAplicado() {
        return precioUnitarioAplicado;
    }

    public void setPrecioUnitarioAplicado(double precioUnitarioAplicado) {
        this.precioUnitarioAplicado = precioUnitarioAplicado;
    }
}

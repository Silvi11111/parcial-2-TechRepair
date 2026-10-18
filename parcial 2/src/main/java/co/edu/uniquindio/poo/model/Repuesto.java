package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class Repuesto {
    private  String codigoRepuesto;
    private String nombreRepuesto;
    private int cantidadDisponible;
    private String descripcion;
    private String categoriaCompatible;
    private double precioUnitario;
    private ArrayList<DetalleRepuesto> listaDetalleRepuestos;

    public Repuesto(String codigoRepuesto, String nombreRepuesto, int cantidadDisponible, String descripcion, String categoriaCompatible, double precioUnitario, ArrayList<DetalleRepuesto> listaDetalleRepuestos) {
        this.codigoRepuesto = codigoRepuesto;
        this.nombreRepuesto = nombreRepuesto;
        this.cantidadDisponible = cantidadDisponible;
        this.descripcion = descripcion;
        this.categoriaCompatible = categoriaCompatible;
        this.precioUnitario = precioUnitario;
        this.listaDetalleRepuestos = listaDetalleRepuestos;
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

    public ArrayList<DetalleRepuesto> getListaDetalleRepuestos() {
        return listaDetalleRepuestos;
    }

    public void setListaDetalleRepuestos(ArrayList<DetalleRepuesto> listaDetalleRepuestos) {
        this.listaDetalleRepuestos = listaDetalleRepuestos;
    }

    //buscar el repuesto que se usó
    public Optional<DetalleRepuesto> buscarDetalleRepuestoUsado(Repuesto repuesto) {
        return listaDetalleRepuestos.stream().filter(detalleRepuesto ->
                repuesto.equals(repuesto.getCodigoRepuesto())).findFirst();
    }
}

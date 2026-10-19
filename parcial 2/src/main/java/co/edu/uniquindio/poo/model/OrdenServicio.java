package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdenServicio {
    private String codigoOrden;
    private LocalDate fechaCreacion;
    private Cliente clienteResponsable;
    private String observaciones;
    private EstadoOrden estadoOrden;
    private List<DetalleOrdenServicio> listaDetalleOrdenServicios;

    public OrdenServicio(String codigoOrden, LocalDate fechaCreacion, Cliente clienteResponsable, String observaciones, EstadoOrden estadoOrden, ArrayList<DetalleOrdenServicio> listaDetalleOrdenServicios) {
        this.codigoOrden = codigoOrden;
        this.fechaCreacion = fechaCreacion;
        this.clienteResponsable = clienteResponsable;
        this.observaciones = observaciones;
        this.estadoOrden = estadoOrden;
        this.listaDetalleOrdenServicios = new ArrayList<>();
    }

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Cliente getClienteResponsable() {
        return clienteResponsable;
    }

    public void setClienteResponsable(Cliente clienteResponsable) {
        this.clienteResponsable = clienteResponsable;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public List<DetalleOrdenServicio> getListaDetalleOrdenServicios() {
        return listaDetalleOrdenServicios;
    }

    public void setListaDetalleOrdenServicios(ArrayList<DetalleOrdenServicio> listaDetalleOrdenServicios) {
        this.listaDetalleOrdenServicios = listaDetalleOrdenServicios;
    }

    public double buscarSubTotalPorEquipo(String codigoEquipo) {
        for (DetalleOrdenServicio detalle : this.listaDetalleOrdenServicios) {
            if (detalle.getEquipo().getCodigoEquipo().equals(codigoEquipo)) {
                return detalle.calcularValorDetalle();
            }
        }
        return 0.0;
    }
    public double calcularValorTotal() {
        double totalOrden = 0.0;

        for (DetalleOrdenServicio detalle : this.listaDetalleOrdenServicios) {
            totalOrden += detalle.calcularValorDetalle();
        }

        return totalOrden;
    }

    public Optional<DetalleOrdenServicio> actualizarEstadoDetallePorSerie(String numeroSerie, String nuevoEstado) {
        for (DetalleOrdenServicio detalle : listaDetalleOrdenServicios) {
            if (detalle.getEquipo() != null && detalle.getEquipo().getNumeroSerie().equalsIgnoreCase(numeroSerie)) {
                return Optional.of(detalle.actualizarEstadoDetalle(nuevoEstado));
            }
        }
        return Optional.empty();
    }
    public OrdenServicio finalizarOrden() {
        this.estadoOrden = EstadoOrden.FINALIZADA;
        return this;
    }
}


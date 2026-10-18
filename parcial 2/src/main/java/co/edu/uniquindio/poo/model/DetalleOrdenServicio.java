package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class DetalleOrdenServicio {
    private String descripcion;
    private Tecnico tecnico;
    private int horasTrabajo;
    private String observacionesTecnicas;
    private Equipo equipo;
    private Servicio servicio;
    private ArrayList<DetalleRepuesto> listaDetalleRepuestos;

    public DetalleOrdenServicio(String descripcion, Tecnico tecnico, int horasTrabajo, String observacionesTecnicas, Equipo equipo, Servicio servicio, ArrayList<DetalleRepuesto> listaDetalleRepuestos) {
        this.descripcion = descripcion;
        this.tecnico = tecnico;
        this.horasTrabajo = horasTrabajo;
        this.observacionesTecnicas = observacionesTecnicas;
        this.equipo = equipo;
        this.servicio = servicio;
        this.listaDetalleRepuestos = listaDetalleRepuestos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public String getObservacionesTecnicas() {
        return observacionesTecnicas;
    }

    public void setObservacionesTecnicas(String observacionesTecnicas) {
        this.observacionesTecnicas = observacionesTecnicas;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public ArrayList<DetalleRepuesto> getListaDetalleRepuestos() {
        return listaDetalleRepuestos;
    }

    public void setListaDetalleRepuestos(ArrayList<DetalleRepuesto> listaDetalleRepuestos) {
        this.listaDetalleRepuestos = listaDetalleRepuestos;
    }
}

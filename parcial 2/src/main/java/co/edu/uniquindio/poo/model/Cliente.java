package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class Cliente {
    private String documento;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private String direccion;
    private ArrayList<Equipo> listaEquipos;

    public Cliente(String documento, String nombreCompleto, String telefono, String correo, String direccion, ArrayList<Equipo> listaEquipos) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.listaEquipos = listaEquipos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }


    public Optional<Equipo> buscarEquipo(String codigoEquipo) {
        return listaEquipos.stream().filter(equipo ->
                codigoEquipo.equals(equipo.getCodigoEquipo())).findFirst();
    }
}

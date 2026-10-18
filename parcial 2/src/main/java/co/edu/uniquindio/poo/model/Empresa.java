package co.edu.uniquindio.poo.model;
import java.util.*;

public class Empresa {
    private final String nombreEmpresa;
    private String ubicacion;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<OrdenServicio> listaOrdenServicios;
    private  ArrayList<Tecnico> listaTecnicos;
    private  ArrayList<Repuesto> listaRepuestos;

    public Empresa(String nombreEmpresa, String ubicacion, ArrayList<Cliente> listaClientes, ArrayList<OrdenServicio> listaOrdenServicios, ArrayList<Tecnico> listaTecnicos, ArrayList<Repuesto> listaRepuestos) {
        this.nombreEmpresa = nombreEmpresa;
        this.ubicacion = ubicacion;
        this.listaClientes = listaClientes;
        this.listaOrdenServicios = listaOrdenServicios;
        this.listaTecnicos = listaTecnicos;
        this.listaRepuestos = listaRepuestos;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<OrdenServicio> getListaOrdenServicios() {
        return listaOrdenServicios;
    }

    public void setListaOrdenServicios(ArrayList<OrdenServicio> listaOrdenServicios) {
        this.listaOrdenServicios = listaOrdenServicios;
    }

    public ArrayList<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(ArrayList<Tecnico> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    public ArrayList<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setListaRepuestos(ArrayList<Repuesto> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }

    //1.
    public String registrarCliente(Cliente cliente){
        Optional<Cliente> clienteEncontrado = buscarCliente(cliente.getDocumento());
        if(clienteEncontrado.isEmpty()){
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        }else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }
    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        return listaClientes.stream().filter(cliente ->
                documentoIdentidad.equals(cliente.getDocumento())).findFirst();
    }
}

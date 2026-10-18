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

    //1.Registrar Cliente
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
    //2.Registrar equipo
    public String registrarEquipo(Cliente cliente, Equipo equipo){
        Optional<Equipo> equipoEncontrado = cliente.buscarEquipo(equipo.getCodigoEquipo());

        if (equipoEncontrado.isEmpty()) {
            cliente.getListaEquipos().add(equipo);
            return "El equipo fue registrado exitosamente";
        } else {
            return "No se puede registrar, el equipo ya existe.";
        }
    }
//3. Registrar técnico
public String registrarTecnico(Tecnico tecnico){
    Optional<Tecnico> tecnicoEncontrado = buscarTecnico(tecnico.getDocumentoTecnico());
    if(tecnicoEncontrado.isEmpty()){
        listaTecnicos.add(tecnico);
        return "El técnico fue registrado exitosamente";
    }else return "No se puede registrar, ya existe un técnico con esa informacion registrado anteriormente.";
}
    public Optional<Tecnico> buscarTecnico(String documentoIdentidad) {
        return listaTecnicos.stream().filter(tecnico ->
                documentoIdentidad.equals(tecnico.getDocumentoTecnico())).findFirst();
    }
    //4. registrar repuesto
    public String registrarRepuesto(Repuesto repuesto){
        Optional<Repuesto> repuestoEncontrado = buscarRepuesto(repuesto.getCodigoRepuesto());
        if(repuestoEncontrado.isEmpty()){
            listaRepuestos.add(repuesto);
            return "El repuesto fue registrado exitosamente";
        }else return "No se puede registrar, ya existe un repuesto con esa informacion registrado anteriormente.";
    }
    public Optional<Repuesto> buscarRepuesto(String codigo) {
        return listaRepuestos.stream().filter(repuesto ->
                codigo.equals(repuesto.getCodigoRepuesto())).findFirst();
    }

}

package co.edu.uniquindio.poo.model;
import java.util.*;
import java.util.stream.Collectors;

public class Empresa {
    private final String nombreEmpresa;
    private String ubicacion;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<OrdenServicio> listaOrdenServicios;
    private ArrayList<Tecnico> listaTecnicos;
    private ArrayList<Repuesto> listaRepuestos;

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
    public String registrarCliente(Cliente cliente) {
        Optional<Cliente> clienteEncontrado = buscarCliente(cliente.getDocumento());
        if (clienteEncontrado.isEmpty()) {
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        } else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }

    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        return listaClientes.stream().filter(cliente ->
                documentoIdentidad.equals(cliente.getDocumento())).findFirst();
    }

    //2.Registrar equipo
    public String registrarEquipo(Cliente cliente, Equipo equipo) {
        Optional<Equipo> equipoEncontrado = cliente.buscarEquipo(equipo.getCodigoEquipo());

        if (equipoEncontrado.isEmpty()) {
            cliente.getListaEquipos().add(equipo);
            return "El equipo fue registrado exitosamente";
        } else {
            return "No se puede registrar, el equipo ya existe.";
        }
    }

    //3. Registrar técnico
    public String registrarTecnico(Tecnico tecnico) {
        Optional<Tecnico> tecnicoEncontrado = buscarTecnico(tecnico.getDocumentoTecnico());
        if (tecnicoEncontrado.isEmpty()) {
            listaTecnicos.add(tecnico);
            return "El técnico fue registrado exitosamente";
        } else return "No se puede registrar, ya existe un técnico con esa informacion registrado anteriormente.";
    }

    public Optional<Tecnico> buscarTecnico(String documentoIdentidad) {
        return listaTecnicos.stream().filter(tecnico ->
                documentoIdentidad.equals(tecnico.getDocumentoTecnico())).findFirst();
    }

    //4. registrar repuesto
    public String registrarRepuesto(Repuesto repuesto) {
        Optional<Repuesto> repuestoEncontrado = buscarRepuesto(repuesto.getCodigoRepuesto());
        if (repuestoEncontrado.isEmpty()) {
            listaRepuestos.add(repuesto);
            return "El repuesto fue registrado exitosamente";
        } else return "No se puede registrar, ya existe un repuesto con esa informacion registrado anteriormente.";
    }

    public Optional<Repuesto> buscarRepuesto(String codigo) {
        return listaRepuestos.stream().filter(repuesto ->
                codigo.equals(repuesto.getCodigoRepuesto())).findFirst();
    }

    //5. crear orden servicio
    public String crearOrdenServicio(OrdenServicio ordenServicio) {
        Optional<OrdenServicio> ordenServicioEncontrada = buscarOrdenServicio(ordenServicio.getCodigoOrden());
        if (ordenServicioEncontrada.isEmpty()) {
            listaOrdenServicios.add(ordenServicio);
            return "El servicio fue creado exitosamente";
        } else return "No se puede registrar, ya existe un servicio con esa informacion registrado anteriormente.";
    }

    public Optional<OrdenServicio> buscarOrdenServicio(String codigo) {
        return listaOrdenServicios.stream().filter(ordenServicio ->
                codigo.equals(ordenServicio.getCodigoOrden())).findFirst();
    }

    //6. agregar detalle a una orden
    public String agregarDetalleOrdenServicio(OrdenServicio ordenServicio, DetalleOrdenServicio detalleOrdenServicio) {
        Optional<OrdenServicio> ordenEncontrada = buscarOrdenServicio(ordenServicio.getCodigoOrden());

        if (ordenEncontrada.isEmpty()) {
            return "No se puede registrar porque la orden no existe.";
        } else {
            ordenServicio.getListaDetalleOrdenServicios().add(detalleOrdenServicio);
            return "Se agregó el detalle a la orden con éxito";
        }
    }

    //7.asignar tecnico
    public String asignarTecnico(Tecnico tecnico, OrdenServicio ordenServicio) {
        Optional<Tecnico> tecnicoEncontrado = buscarTecnico(tecnico.getDocumentoTecnico());
        Optional<OrdenServicio> ordenEncontrada = buscarOrdenServicio(ordenServicio.getCodigoOrden());
        if (tecnicoEncontrado.isPresent() && ordenEncontrada.isPresent()) {
            if (tecnicoEncontrado.get().getEstadoLaboral() == EstadoLaboral.ACTIVO) {
                ordenServicio.getListaDetalleOrdenServicios()
                        .forEach(detalle -> detalle.setTecnico(tecnicoEncontrado.get()));

                return "Técnico asignado exitosamente";
            } else return "No se puede registrar,el técnico no está activo por el momento.";

        } else
            return "No se puede registrar, asegurese de que haya escrito bien el código de la orden o el código del técnico.";
    }

    //8.Registrar repuestos utilizados
    public List<DetalleRepuesto> registrarRepuestosUtilizados(Repuesto repuesto, int cantidadUsada) {
        List<DetalleRepuesto> repuestosUsados = new ArrayList<>();
        if (repuesto.getCantidadDisponible() >= cantidadUsada) {
            DetalleRepuesto nuevoDetalle = new DetalleRepuesto(cantidadUsada, repuesto, repuesto.getPrecioUnitario());

            nuevoDetalle.setCantidadUsada(cantidadUsada);
            nuevoDetalle.setRepuesto(repuesto);
            nuevoDetalle.setPrecioUnitarioAplicado(repuesto.getPrecioUnitario());
            repuestosUsados.add(nuevoDetalle);

            int nuevoStock = repuesto.getCantidadDisponible() - cantidadUsada;
            repuesto.setCantidadDisponible(nuevoStock);
        }
        return repuestosUsados;
    }
    //9.Calcular valor de un detalle
    public double calcularValorDetalle(String codigoOrden, String codigoEquipo) {
        for (OrdenServicio orden : this.listaOrdenServicios) {

            if (orden.getCodigoOrden().equals(codigoOrden)) {

                return orden.buscarSubTotalPorEquipo(codigoEquipo);
            }
        }
        return 0.0; // Si no existe la orden o el equipo
    }
    //10.Calcular valor total de la orden
    public double calcularValorTotal(String codigoOrden) {
        for (OrdenServicio orden : this.listaOrdenServicios) {
            if (orden.getCodigoOrden().equals(codigoOrden)) {
                return orden.calcularValorTotal();
            }
        }
        return 0.0; // Si no encuentra la orden
    }
    //11.Actualizar estado de un detalle
    public Optional<DetalleOrdenServicio> actualizarEstadoDetalle(String codigoOrden, String numeroSerie, String nuevoEstado) {
        for (OrdenServicio orden : listaOrdenServicios) {
            if (orden.getCodigoOrden().equalsIgnoreCase(codigoOrden)) {
                return orden.actualizarEstadoDetallePorSerie(numeroSerie, nuevoEstado);
            }
        }
        return Optional.empty();
    }
    //12.Finalizar una orden
    public Optional<OrdenServicio> finalizarOrdenServicio(String codigoOrden) {
        for (OrdenServicio orden : listaOrdenServicios) {
            if (orden.getCodigoOrden().equalsIgnoreCase(codigoOrden)) {
                return Optional.of(orden.finalizarOrden());
            }
        }
        return Optional.empty();
    }
    //13.Consultar órdenes de un cliente
    public List<OrdenServicio> consultarOrdenesPorCliente(String nombreCliente, String documentoCliente) {
        return listaOrdenServicios.stream()
                .filter(orden -> orden.getClienteResponsable().getDocumento().equalsIgnoreCase(documentoCliente) && orden.getClienteResponsable().getNombreCompleto().equalsIgnoreCase(Cliente))
                .collect(Collectors.toList());
    }
    //14.Consultar trabajos hechos por un técnico
    public List<DetalleOrdenServicio> consultarTrabajosTecnico(String nombreTecnico, String documentoTecnico) {
        return listaOrdenServicios.stream()
                .flatMap(orden -> orden.getListaDetalleOrdenServicios().stream())
                .filter(detalle -> detalle.getTecnico().getDocumentoTecnico().equalsIgnoreCase(documentoTecnico) &&
                        detalle.getTecnico().getNombreTecnico().equalsIgnoreCase(nombreTecnico))
                .collect(Collectors.toList());
    }
    //15.Consultar equipos pendientes
    public List<OrdenServicio> consultarEquiposPendientes() {
        return listaOrdenServicios.stream()
                .filter(orden -> orden.getEstadoOrden() == EstadoOrden.EN_PROCESO)
                .collect(Collectors.toList());
    }
    //16.Generar reporte de servicios :Mostrar cantidad de servicios por tipo y total facturado por
    //cada categoría.
    public List<String> calcularCantidadTipoServicio() {
        int cantidadDiagnostico = 0;
        int cantidadMantenimiento = 0;
        int cantidadReparacion = 0;
        for (OrdenServicio orden : listaOrdenServicios) {
            for (DetalleOrdenServicio detalle : orden.getListaDetalleOrdenServicios()) {
                Servicio servicio = detalle.getServicio();
                if (servicio instanceof Diagnostico) {
                    cantidadDiagnostico++;
                } else if (servicio instanceof MantenimientoPreventivo) {
                    cantidadMantenimiento++;
                } else if (servicio instanceof ReparacionCorrectiva) {
                    cantidadReparacion++;
                }
            }
        }
        List<String> resultado = new ArrayList<>();
        resultado.add("Diagnostico: " + cantidadDiagnostico);
        resultado.add("MantenimientoPreventivo: " + cantidadMantenimiento);
        resultado.add("ReparacionCorrectiva: " + cantidadReparacion);
        return resultado;
    }
    public List<String> calcularTotalTipoServicio() {
        double totalDiagnostico = 0.0;
        double totalMantenimiento = 0.0;
        double totalReparacion = 0.0;
        for (OrdenServicio orden : listaOrdenServicios) {
            for (DetalleOrdenServicio detalle : orden.getListaDetalleOrdenServicios()) {
                Servicio servicio = detalle.getServicio();
                if (servicio instanceof Diagnostico) {
                    totalDiagnostico += servicio.calcularSubCosto();
                } else if (servicio instanceof MantenimientoPreventivo) {
                    totalMantenimiento += servicio.calcularSubCosto();
                } else if (servicio instanceof ReparacionCorrectiva) {
                    totalReparacion += servicio.calcularSubCosto();
                }
            }
        }
        List<String> resultado = new ArrayList<>();
        resultado.add("Diagnostico Total: " + totalDiagnostico+"$");
        resultado.add("MantenimientoPreventivo Total: " + totalMantenimiento+"$");
        resultado.add("ReparacionCorrectiva Total: " + totalReparacion+"$");
        return resultado;
    }

    //17.Generar reporte de técnicos:Determinar cuántas intervenciones finalizó cada técnico y
    //el valor de los servicios atendidos.
    public List<String> generarReporteTecnicos() {
        List<String> reporte = new ArrayList<>();
        for (Tecnico tecnico : listaTecnicos) {
            int intervencionesFinalizadas = 0;
            double valorServiciosAtendidos = 0.0;
            for (OrdenServicio orden : listaOrdenServicios) {
                for (DetalleOrdenServicio detalle : orden.getListaDetalleOrdenServicios()) {
                    if (detalle.getTecnico() != null &&
                            detalle.getTecnico().getDocumentoTecnico().equalsIgnoreCase(tecnico.getDocumentoTecnico())) {
                        if (detalle.getEstado().equalsIgnoreCase("FINALIZADA") ||
                                detalle.getEstado().equalsIgnoreCase("FINALIZADO")) {
                            intervencionesFinalizadas++;
                            valorServiciosAtendidos += detalle.getServicio().calcularSubCosto();
                        }
                    }
                }
            }
            reporte.add("Tecnico: " + tecnico.getNombreTecnico() +
                    " | Documento: " + tecnico.getDocumentoTecnico() +
                    " | Intervenciones Finalizadas: " + intervencionesFinalizadas +
                    " | Total Atendido: " + valorServiciosAtendidos+"$");
        }
        return reporte;
    }

}

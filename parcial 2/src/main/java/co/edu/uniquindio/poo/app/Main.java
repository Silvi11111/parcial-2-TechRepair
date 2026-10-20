package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    static Empresa empresa=new Empresa("TechRepair","Armenia, Quindío");
    public static void main(String[] args) {
        cargarDatosPrueba();
        //panel de la app
        String menu = "----- TechRepair -----\n\n"
                + "1. Registrar cliente\n"
                + "2. Registrar equipo\n"
                + "3. Registrar técnico\n"
                + "4. Registrar repuesto\n"
                + "5. Crear orden de servicio\n"
                + "6. Agregar detalle a una orden\n"
                + "7. Asignar técnico\n"
                + "8. Registrar repuestos utilizados\n"
                + "9. Calcular valor de un detalle\n"
                + "10. Calcular valor total de la orden\n"
                + "11. Actualizar estado de un detalle\n"
                + "12. Finalizar una orden\n"
                + "13. Consultar órdenes de un cliente\n"
                + "14. Consultar trabajos de un técnico\n"
                + "15. Consultar equipos pendientes\n"
                + "16. Generar reporte de servicios\n"
                + "17. Generar reporte de técnicos\n"
                + "18. Consultar inventario crítico\n"
                + "0. Salir\n\n"
                + "Seleccione una opción:";
        int opcion = -1;
        do {
            String entrada = JOptionPane.showInputDialog(null, menu, "Menú principal", JOptionPane.QUESTION_MESSAGE);
            if (entrada == null) {
                opcion = 0;
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema TechRepair, adiós.");
                break;
            }
            opcion = Integer.parseInt(entrada);
            switch (opcion) {
                case 1:
                    String documento=JOptionPane.showInputDialog(null,"Ingrese su documento: ");
                    String nombreCompleto=JOptionPane.showInputDialog(null,"Ingrese su nombre completo: ");
                    String telefono=JOptionPane.showInputDialog(null,"Ingrese su teléfono: ");
                    String correo=JOptionPane.showInputDialog(null,"Ingrese su correo electrónico: ");
                    String direccion=JOptionPane.showInputDialog(null,"Ingrese su dirección: ");

                    Cliente clienteRegistrar=new Cliente(documento,nombreCompleto,telefono,correo,direccion);
                    String mensajeRegistrarCliente=empresa.registrarCliente(clienteRegistrar);
                    JOptionPane.showMessageDialog(null, mensajeRegistrarCliente);
                    break;
                case 2:
                    String documentoCliente=JOptionPane.showInputDialog(null,"Ingrese el documento del dueño del equipo: ");
                    String codigoEquipo=JOptionPane.showInputDialog(null,"Ingrese un nuevo código para identificar el equipo: ");
                    String numeroSerie=JOptionPane.showInputDialog(null,"Ingrese el número de serie del equipo: ");
                    String marca=JOptionPane.showInputDialog(null,"Ingrese la marca del equipo: ");
                    String modelo=JOptionPane.showInputDialog(null,"Ingrese el modelo del equipo: ");
                    String anoFabricacion=JOptionPane.showInputDialog(null,"Ingrese el año de fabricación del equipo (AAAA-MM-DD): ");
                    LocalDate fabricacion=LocalDate.parse(anoFabricacion);
                    String descripcionEstadoFisico=JOptionPane.showInputDialog(null,"Describa el estado físico del equipo: ");
                    String capacidadAlmacenamiento=JOptionPane.showInputDialog(null,"Ingrese el almacenamiento de su equipo(GB): ");
                    Equipo nuevoEquipo=new Equipo(codigoEquipo,numeroSerie,marca,modelo,fabricacion,descripcionEstadoFisico,capacidadAlmacenamiento);
                    String mensaje=empresa.registrarEquipo(documentoCliente,nuevoEquipo);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case 3:
                    String codigoTecnico=JOptionPane.showInputDialog(null,"Ingrese el código del técnico: ");
                    String nombreTecnico=JOptionPane.showInputDialog(null,"Ingrese el nombre del técnico: ");
                    String documentoTecnico=JOptionPane.showInputDialog(null,"Ingrese el nombre del técnico: ");
                    Especialidad especialidad = (Especialidad) JOptionPane.showInputDialog(
                            null,
                            "Seleccione la especialidad:",
                            "Especialidad del Técnico",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            Especialidad.values(),     // Pasa las opciones del enum (COMPUTADORES, DISPOSITIVOS_MOVILES, SOPORTE_GENERAL)
                            Especialidad.values()[0]
                    );
                    EstadoLaboral estadoLaboral = (EstadoLaboral) JOptionPane.showInputDialog(
                            null,
                            "Seleccione el estado laboral:",
                            "Estado Laboral",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            EstadoLaboral.values(),    // Pasa las opciones del enum (ACTIVO, INACTIVO)
                            EstadoLaboral.values()[0]
                    );
                    if (especialidad != null && estadoLaboral != null) {
                        Tecnico nuevoTecnico = new Tecnico(codigoTecnico, nombreTecnico,documentoTecnico, especialidad, estadoLaboral);

                        String mensajeRegistrarTecnico = empresa.registrarTecnico(nuevoTecnico);
                        JOptionPane.showMessageDialog(null, mensajeRegistrarTecnico);
                    }
                    break;
                case 4:
                    String codigoRepuesto=JOptionPane.showInputDialog(null,"Ingrese el código del repuesto: ");
                    String nombreRepuesto=JOptionPane.showInputDialog(null,"Ingrese el nombre del repuesto: ");
                    String cantidadDisponible=JOptionPane.showInputDialog(null,"Ingrese la cantidad disponible de ese repuesto(números enteros): ");
                    int cantidadDisponibleRepuesto=Integer.parseInt(cantidadDisponible);
                    String descripcionRepuesto=JOptionPane.showInputDialog(null,"Describa el repuesto: ");
                    String categoriaCompatible=JOptionPane.showInputDialog(null,"Ingrese la categoria donde encaje el repuesto: ");
                    String precioUnitario=JOptionPane.showInputDialog(null,"Ingrese el precio de ese repuesto(por unidad): ");
                    double precioUnitarioRepuesto=Double.parseDouble(precioUnitario);

                    Repuesto nuevoRepuesto = new Repuesto(
                            codigoRepuesto,
                            nombreRepuesto,
                            cantidadDisponibleRepuesto,
                            descripcionRepuesto,
                            categoriaCompatible,
                            precioUnitarioRepuesto,
                            new ArrayList<>()
                    );


                    String mensajeRegistrarRepuesto = empresa.registrarRepuesto(nuevoRepuesto); // Asegúrate de tener este método en Empresa
                    JOptionPane.showMessageDialog(null, mensajeRegistrarRepuesto);

                    break;
                case 5:
                    String documentoClienteOrden=JOptionPane.showInputDialog(null,"Ingrese el documento del cliente: ");
                    String codigoOrden=JOptionPane.showInputDialog(null,"Ingrese el código de la orden: ");
                    String fechaCreacion=JOptionPane.showInputDialog(null,"Ingrese la fecha de la orden (AAAA-MM-DD): ");
                    LocalDate fechaCreacionOrden=LocalDate.parse(fechaCreacion);
                    String observaciones = JOptionPane.showInputDialog(null, "Ingrese las observaciones:");
                    EstadoOrden estadoOrden = (EstadoOrden) JOptionPane.showInputDialog(
                            null,
                            "Seleccione el estado de la orden:",
                            "Estado de Orden",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            EstadoOrden.values(),
                            EstadoOrden.ABIERTA
                    );
                    OrdenServicio nuevaOrden = new OrdenServicio(
                            codigoOrden,
                            fechaCreacionOrden,
                            null, // clienteResponsable
                            observaciones,
                            estadoOrden,
                            new ArrayList<>() // listaDetalleOrdenServicios nueva vacía
                    );
                    String mensajeCrearOrden = empresa.crearOrdenServicio(nuevaOrden, documentoClienteOrden);
                    JOptionPane.showMessageDialog(null, mensajeCrearOrden);
                    break;
                case 6:
                    String codigoOrdenDetalle = JOptionPane.showInputDialog(null, "Ingrese el código de la orden del servicio:");
                    Optional<OrdenServicio> ordenOpt = empresa.buscarOrdenServicio(codigoOrdenDetalle);
                    if (ordenOpt.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se puede registrar porque la orden no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    OrdenServicio ordenExistente = ordenOpt.get();
                    String descripcionDetalle = JOptionPane.showInputDialog(null, "Ingrese la descripción del trabajo:");
                    int horasTrabajo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese las horas de trabajo:"));
                    String observacionesTecnicas = JOptionPane.showInputDialog(null, "Ingrese las observaciones técnicas:");
                    String estadoDetalle = JOptionPane.showInputDialog(null, "Ingrese el estado del detalle:");
                    String codigoTecnicoOrden = JOptionPane.showInputDialog(null, "Ingrese el código del técnico asignado:");
                    Tecnico tecnico = empresa.buscarTecnico(codigoTecnicoOrden).orElse(null);
                    String codigoEquipoOrden = JOptionPane.showInputDialog(null, "Ingrese el código del equipo a intervenir:");
                    Equipo equipo = ordenExistente.getClienteResponsable().buscarEquipo(codigoEquipoOrden).orElse(null);
                    String[] opcionesServicio = {"Diagnostico", "Mantenimiento Preventivo", "Reparacion Correctiva"};
                    String tipoServicioSeleccionado = (String) JOptionPane.showInputDialog(
                            null,
                            "Seleccione el tipo de servicio:",
                            "Tipo de Servicio",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesServicio,
                            opcionesServicio[0]
                    );
                    String codigoServicio = JOptionPane.showInputDialog(null, "Ingrese el código del servicio:");
                    String nombreServicio = JOptionPane.showInputDialog(null, "Ingrese el nombre del servicio:");
                    String descServicio = JOptionPane.showInputDialog(null, "Ingrese la descripción del servicio:");
                    Servicio servicio = null;
                    if ("Diagnostico".equals(tipoServicioSeleccionado)) {
                        servicio = new Diagnostico(codigoServicio, nombreServicio, descServicio,0.0);
                    } else if ("Mantenimiento Preventivo".equals(tipoServicioSeleccionado)) {
                        servicio = new MantenimientoPreventivo(codigoServicio, nombreServicio, descServicio,0.0);
                    } else if ("Reparacion Correctiva".equals(tipoServicioSeleccionado)) {
                        servicio = new ReparacionCorrectiva(codigoServicio, nombreServicio, descServicio,0.0);
                    }
                    DetalleOrdenServicio nuevoDetalle = new DetalleOrdenServicio(
                            descripcionDetalle,
                            tecnico,
                            horasTrabajo,
                            observacionesTecnicas,
                            estadoDetalle,
                            equipo,
                            servicio,
                            new ArrayList<>()
                    );
                    String mensajeCrearDetalleOrdenServicio = empresa.agregarDetalleOrdenServicio(ordenExistente, nuevoDetalle);
                    JOptionPane.showMessageDialog(null, mensajeCrearDetalleOrdenServicio);
                    break;
                case 7:
                    String codigoTecnicoAsignar = JOptionPane.showInputDialog(null, "Ingrese el código del técnico:");
                    String codigoOrdenAsignar = JOptionPane.showInputDialog(null, "Ingrese el código de la orden de servicio:");
                    Optional<Tecnico> tecnicoAsignarOpt = empresa.buscarTecnico(codigoTecnicoAsignar);
                    Optional<OrdenServicio> ordenAsignarOpt = empresa.buscarOrdenServicio(codigoOrdenAsignar);
                    if (tecnicoAsignarOpt.isEmpty() && ordenAsignarOpt.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El técnico o la orden del servicio no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    Tecnico tecnicoAsignar = tecnicoAsignarOpt.get();
                    OrdenServicio ordenServicioAsignar = ordenAsignarOpt.get();
                    String mensajeAsignarTecnico = empresa.asignarTecnico(tecnicoAsignar, ordenServicioAsignar);
                    JOptionPane.showMessageDialog(null, mensajeAsignarTecnico);
                    break;
                case 8:
                    String codigoRepuestoUtilizado = JOptionPane.showInputDialog(null, "Ingrese el código del repuesto que se usó:");
                    Optional<Repuesto> repuestoUtilizadoOpt = empresa.buscarRepuesto(codigoRepuestoUtilizado);
                    if (repuestoUtilizadoOpt.isEmpty()){
                        JOptionPane.showMessageDialog(null, "El repuesto no está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    Repuesto asignarRepuestoUsado=repuestoUtilizadoOpt.get();
                    String cantidadUsada = JOptionPane.showInputDialog(null, "Ingrese la cantidad que se utilizó:");
                    int cantidadUsadaRepuesto=Integer.parseInt(cantidadUsada);
                    List<DetalleRepuesto> mensajeRegistrarRepuestoUsado=empresa.registrarRepuestosUtilizados(asignarRepuestoUsado,cantidadUsadaRepuesto);
                    JOptionPane.showMessageDialog(null, mensajeRegistrarRepuestoUsado+"El repuesto usado fue registrado con éxito");
                    break;
                case 9:
                    String codigoOrdenValorDetalle = JOptionPane.showInputDialog(null, "Ingrese el código de la orden que quiere calcular:");
                    String codigoEquipoValorDetalle = JOptionPane.showInputDialog(null, "Ingrese el código del equipo donde esta el detalle:");
                    if (codigoOrdenValorDetalle.isEmpty()&&codigoEquipoValorDetalle.isEmpty()){
                        JOptionPane.showMessageDialog(null, "La orden o el equipo no están registrados.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    double valorDetalle= empresa.calcularValorDetalle(codigoOrdenValorDetalle,codigoEquipoValorDetalle);
                    JOptionPane.showMessageDialog(null, "El valor del detalle del equipo "+codigoEquipoValorDetalle+"es de: "+valorDetalle);
                    break;
                case 10:
                    String codigoOrdenValorTotal = JOptionPane.showInputDialog(null, "Ingrese el código de la orden que quiere calcular:");
                    if (codigoOrdenValorTotal.isEmpty()){
                        JOptionPane.showMessageDialog(null, "La orden no está registrada.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    double calcularTotal= empresa.calcularValorTotal(codigoOrdenValorTotal);
                    JOptionPane.showMessageDialog(null, "El valor total de la orden es de "+calcularTotal);
                    break;
                case 11:
                    String codigoOrdenActualizar = JOptionPane.showInputDialog(null, "Ingrese el código de la orden:");
                    String numeroSerieActualizar = JOptionPane.showInputDialog(null, "Ingrese el número de serie del equipo:");
                    String nuevoEstadoActualizacion = JOptionPane.showInputDialog(null, "Ingrese el nuevo estado del detalle:");
                    Optional<DetalleOrdenServicio> nuevoEstado = empresa.actualizarEstadoDetalle(
                            codigoOrdenActualizar.trim(),
                            numeroSerieActualizar.trim(),
                            nuevoEstadoActualizacion.trim()
                    );
                    JOptionPane.showMessageDialog(null,nuevoEstado);
                    break;
                case 12:
                    String codigoOrdenFinalizar = JOptionPane.showInputDialog(null, "Ingrese el código de la orden:");
                    Optional<OrdenServicio> finalizarOrden=empresa.finalizarOrdenServicio(codigoOrdenFinalizar);
                    if (finalizarOrden.isEmpty()){
                        JOptionPane.showMessageDialog(null, "La orden no se pudo finalizar, revise el código de la orden.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null,"Orden finalizada con éxito");
                    break;
                case 13:
                    String nombreClienteBuscarOrdenes = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
                    String documentoClienteBuscarOrdenes = JOptionPane.showInputDialog(null, "Ingrese el documento del cliente:");
                    List<OrdenServicio> ordenesCliente = empresa.consultarOrdenesPorCliente(nombreClienteBuscarOrdenes, documentoClienteBuscarOrdenes);
                    if (ordenesCliente.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se encontraron órdenes para " + nombreClienteBuscarOrdenes + " (Doc: " + documentoClienteBuscarOrdenes + ").", "Sin resultados", JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        StringBuilder mensajeBuscarOrdenes = new StringBuilder();
                        mensajeBuscarOrdenes.append("--ÓRDENES DE ").append(nombreClienteBuscarOrdenes.toUpperCase()).append(" ===\n\n");
                        for (OrdenServicio orden : ordenesCliente) {
                            mensajeBuscarOrdenes.append("- Código: ").append(orden.getCodigoOrden()).append("\n")
                                    .append("- Fecha: ").append(orden.getFechaCreacion()).append("\n")
                                    .append("- Estado: ").append(orden.getEstadoOrden()).append("\n")
                                    .append("- Total a pagar: $").append(orden.calcularValorTotal()).append("\n");
                        }
                        JOptionPane.showMessageDialog(
                                null,
                                mensajeBuscarOrdenes.toString(),
                                "Órdenes del Cliente",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                    break;
                case 14:
                    String documentotecnicoConsultarTrabajo = JOptionPane.showInputDialog(null, "Ingrese el nombre del técnico:");
                    String nombretecnicoConsultarTrabajo = JOptionPane.showInputDialog(null, "Ingrese el documento del técnico:");
                    if (documentotecnicoConsultarTrabajo.isEmpty() && nombretecnicoConsultarTrabajo.isEmpty()){
                        JOptionPane.showMessageDialog(null, "el técnico no está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    List<DetalleOrdenServicio> consultarTrabajos=empresa.consultarTrabajosTecnico(nombretecnicoConsultarTrabajo,documentotecnicoConsultarTrabajo);
                    StringBuilder mensajeBuscarTrabajos = new StringBuilder();
                    mensajeBuscarTrabajos.append("--ÓRDENES DE ").append(documentotecnicoConsultarTrabajo.toUpperCase()).append("\n");
                    for (DetalleOrdenServicio detalleOrdenServicio : consultarTrabajos) {
                        mensajeBuscarTrabajos.append("- Observaciones técnicas: ").append(detalleOrdenServicio.getObservacionesTecnicas()).append("\n")
                                .append("- Estado: ").append(detalleOrdenServicio.getEstado()).append("\n")
                                .append("- Descripción: ").append(detalleOrdenServicio.getDescripcion()).append("\n")
                                .append("- Equipo").append(detalleOrdenServicio.getEquipo()).append("\n");
                    }
                    JOptionPane.showMessageDialog(
                            null,
                            mensajeBuscarTrabajos.toString(),
                            "Trabajos del técnico",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    break;
                case 15:
                    List<OrdenServicio> equiposPendientes=empresa.consultarEquiposPendientes();
                    StringBuilder mensajeEquiposPendientes = new StringBuilder();
                    mensajeEquiposPendientes.append("---EQUIPOS PENDIENTES--- ").append("\n");
                    for (OrdenServicio ordenServicio : equiposPendientes) {
                        mensajeEquiposPendientes.append("- Código: ").append(ordenServicio.getCodigoOrden()).append("\n")
                                .append("- Fecha de creación: ").append(ordenServicio.getFechaCreacion()).append("\n")
                                .append("- Cliente: ").append(ordenServicio.getClienteResponsable().getNombreCompleto()).append("\n")
                                .append("- Observaciones: ").append(ordenServicio.getObservaciones()).append("\n")
                                 .append("- Estado de la orden: ").append(ordenServicio.getEstadoOrden()).append("\n");
                    }
                    JOptionPane.showMessageDialog(
                            null,
                            mensajeEquiposPendientes.toString(),
                            "Trabajos del técnico",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
                case 16:
                    List<String> cantidades = empresa.calcularCantidadTipoServicio();
                    List<String> totales = empresa.calcularTotalTipoServicio();
                    StringBuilder reporte = new StringBuilder();
                    reporte.append("--- REPORTE DE SERVICIOS ---\n\n");
                    reporte.append("- Cantidad de servicios realizados -\n");
                    for (String item : cantidades) {
                        reporte.append("• ").append(item).append("\n");
                    }
                    reporte.append("\n- Total facturado por categoría -\n");
                    for (String item : totales) {
                        reporte.append("- ").append(item).append("\n");
                    }
                    JOptionPane.showMessageDialog(
                            null,
                            reporte.toString(),
                            "Reporte General de Servicios",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
                case 17:
                    List<String> reporteTecnicos = empresa.generarReporteTecnicos();
                    if (reporteTecnicos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay datos registrados para generar el reporte de técnicos.", "Reporte de Técnicos", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        StringBuilder mensajeGenerarReporte = new StringBuilder();
                        mensajeGenerarReporte.append("--- REPORTE DE TÉCNICOS ---\n\n");
                        for (String item : reporteTecnicos) {
                            mensajeGenerarReporte.append("- ").append(item).append("\n\n");
                        }
                        JOptionPane.showMessageDialog(
                                null,
                                mensajeGenerarReporte.toString(),
                                "Reporte de Desempeño de Técnicos",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                    break;
                case 18:
                    List<Repuesto> repuestosCriticos = empresa.consultarInventarioCritico();
                    if (repuestosCriticos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay repuestos con inventario crítico.", "Inventario en Buen Estado", JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        StringBuilder mensajeInventarioCritico = new StringBuilder();
                        mensajeInventarioCritico.append("--- REPORTE DE INVENTARIO CRÍTICO ---\n\n");
                        for (Repuesto repuesto : repuestosCriticos) {
                            mensajeInventarioCritico.append("• Nombre: ").append(repuesto.getNombreRepuesto()).append("\n")
                                    .append("  Código: ").append(repuesto.getCodigoRepuesto()).append("\n")
                                    .append("  Cantidad disponible: ").append(repuesto.getCantidadDisponible()).append(" unidades\n")
                                    .append("  Precio unitario: $").append(repuesto.getPrecioUnitario()).append("\n");
                        }
                        JOptionPane.showMessageDialog(
                                null,
                                mensajeInventarioCritico.toString(),
                                "Alerta de Inventario Crítico",
                                JOptionPane.WARNING_MESSAGE
                        );
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema TechRepair, adiós.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (opcion != 0);

    }
    static void cargarDatosPrueba(){
        Cliente cliente1=new Cliente("123456","Juan Pablo Perez","3123456789","juanPerez@gmail","en su casa");
        Cliente cliente2=new Cliente("789012","Sandra marcela Gonzalez","3987654321","Sandramarcela@gmail","en un puente");
        Cliente cliente3=new Cliente("345678","Juan David Millan","3987654321","juanDavid@gmail","Bogotá");
        empresa.registrarCliente(cliente1);
        empresa.registrarCliente(cliente2);
        empresa.registrarCliente(cliente3);

        Tecnico tecnico1=new Tecnico("001","Pedrito piedritas","13483135",Especialidad.COMPUTADORES,EstadoLaboral.ACTIVO);
        Tecnico tecnico2=new Tecnico("002","Elsa pato","6842353221",Especialidad.DISPOSITIVOS_MOVILES,EstadoLaboral.INACTIVO);
        Tecnico tecnico3=new Tecnico("003","Sammy el heladero","153483152",Especialidad.SOPORTE_GENERAL,EstadoLaboral.ACTIVO);
        empresa.registrarTecnico(tecnico1);
        empresa.registrarTecnico(tecnico2);
        empresa.registrarTecnico(tecnico3);

        ArrayList<DetalleRepuesto> listaDetallesRepuesto1 = new ArrayList<>();
        Repuesto repuesto1 = new Repuesto("0001", "tornillos", 40, "es un tornillito","computadores",1000,listaDetallesRepuesto1);
        DetalleRepuesto detalleRepuesto1 = new DetalleRepuesto(2, repuesto1, repuesto1.getPrecioUnitario());
        listaDetallesRepuesto1.add(detalleRepuesto1);
        ArrayList<DetalleRepuesto> listaDetallesRepuesto2 = new ArrayList<>();
        Repuesto repuesto2 = new Repuesto("0002", "soldadura", 3, "es una soldadura :3","todos",5000,listaDetallesRepuesto2);
        DetalleRepuesto detalleRepuesto2 = new DetalleRepuesto(0, repuesto2, repuesto2.getPrecioUnitario());
        listaDetallesRepuesto2.add(detalleRepuesto2);
        empresa.registrarRepuesto(repuesto1);
        empresa.registrarRepuesto(repuesto2);

    }
}


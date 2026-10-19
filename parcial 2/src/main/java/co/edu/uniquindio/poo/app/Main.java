package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Empresa empresa=new Empresa("TechRepair","Armenia, Quindío");
    public static void main(String[] args) {
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
                    String codigoEquipo=JOptionPane.showInputDialog(null,"Ingrese el código del equipo: ");
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
                    String documentoClienteOrden=JOptionPane.showInputDialog(null,"Ingrese el código del cliente: ");
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
                            null, // clienteResponsable (Empresa lo asignará tras buscarlo por documento)
                            observaciones,
                            estadoOrden,
                            new ArrayList<>() // listaDetalleOrdenServicios vacía
                    );

                    // Guardamos y mostramos el resultado
                    String mensajeCrearOrden = empresa.crearOrdenServicio(nuevaOrden, documentoClienteOrden);
                    JOptionPane.showMessageDialog(null, mensajeCrearOrden);

                    /*;
    private Cliente clienteResponsable;
    private String observaciones;
    private EstadoOrden estadoOrden;
    private List<DetalleOrdenServicio> listaDetalleOrdenServicios;*/
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema TechRepair, adiós.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (opcion != 0);

    }
}


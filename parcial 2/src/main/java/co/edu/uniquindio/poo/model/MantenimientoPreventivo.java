package co.edu.uniquindio.poo.model;

public class MantenimientoPreventivo extends Servicio{
    public MantenimientoPreventivo(String codigo, String nombre, String descripcion, double tarifaBase) {
        super(codigo, nombre, descripcion, tarifaBase);
    }
    @Override
    public double calcularSubCosto(int horasTrabajo, Equipo equipo) {
        double tarifaCelular=40000;
        double tarifaComputadorPortatil=60000;
        double tarifaComputadorEscritorio=70000;
        if (equipo instanceof ComputadoraPortatil) {
            return tarifaComputadorPortatil;
        } else if (equipo instanceof ComputadorEscritorio) {
            return tarifaComputadorEscritorio;
        } else if (equipo instanceof Celular) {
            return tarifaCelular;
        }
        else return 0;
    }
}

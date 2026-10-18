package co.edu.uniquindio.poo.model;

public class ReparacionCorrectiva extends Servicio{
    public ReparacionCorrectiva(String codigo, String nombre, String descripcion, double tarifaBase) {
        super(codigo, nombre, descripcion, tarifaBase);
    }
    @Override
    public double calcularSubCosto(double tarifaBase,int horasTrabajo, Equipo equipo) {
        return 45000 * horasTrabajo;
    }
}

package co.edu.uniquindio.poo.model;

public class Diagnostico extends Servicio{
    public Diagnostico(String codigo, String nombre, String descripcion, double tarifaBase) {
        super(codigo, nombre, descripcion, tarifaBase);
    }

    @Override
    public double calcularSubCosto(int horasTrabajo, Equipo equipo) {
        return 35000;
    }
}

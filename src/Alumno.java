public class Alumno {
    private String rut;
    private String nombre;
    private String fechaNacimiento;

    public Alumno(String rut, String nombre, String fechaNacimiento) {
        this.rut = rut;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "RUT: " + rut + ", Nombre: " + nombre + ", Fecha de nacimiento: " + fechaNacimiento;
    }
}

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    // Lista de cursos iniciales
    public static List<Curso> cargarCursos() {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("C001", "Matemáticas", "Curso básico de matemáticas"));
        cursos.add(new Curso("C002", "Historia", "Curso de historia mundial"));
        cursos.add(new Curso("C003", "Ciencias", "Curso de ciencias naturales"));
        return cursos;
    }

    // Lista de alumnos iniciales
    public static List<Alumno> cargarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("12345678-9", "Juan Pérez", "12/04/2000"));
        alumnos.add(new Alumno("98765432-1", "María González", "05/09/2001"));
        alumnos.add(new Alumno("65432198-7", "Carlos López", "21/11/1999"));
        return alumnos;
    }
}

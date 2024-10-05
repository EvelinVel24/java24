import java.util.*;

public class Main {
    private static List<Curso> cursos = DataHelper.cargarCursos();
    private static List<Alumno> alumnos = DataHelper.cargarAlumnos();
    private static Map<Curso, List<Alumno>> cursoAlumnosMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    mostrarCursos();
                    break;
                case 2:
                    matricularAlumno();
                    break;
                case 3:
                    agregarCurso();
                    break;
                case 4:
                    asignarAlumnoACurso();
                    break;
                case 5:
                    mostrarAlumnosPorCurso();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Aplicación cerrada.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // Método para mostrar el menú
    private static void mostrarMenu() {
        System.out.println("\nMenú de Centros de Estudios:");
        System.out.println("1. Mostrar cursos disponibles");
        System.out.println("2. Matricular nuevo alumno");
        System.out.println("3. Agregar nuevo curso");
        System.out.println("4. Asignar curso a un alumno");
        System.out.println("5. Ver lista de cursos y alumnos asignados");
        System.out.println("6. Cerrar la aplicación");
        System.out.print("Selecciona una opción: ");
    }

    // Método para mostrar los cursos disponibles
    private static void mostrarCursos() {
        System.out.println("\nCursos disponibles:");
        cursos.forEach(System.out::println);
    }

    // Método para matricular un nuevo alumno
    private static void matricularAlumno() {
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.print("Introduce la fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNacimiento = scanner.nextLine();

        Alumno nuevoAlumno = new Alumno(rut, nombre, fechaNacimiento);
        alumnos.add(nuevoAlumno);
        System.out.println("Alumno matriculado: " + nuevoAlumno);
    }

    // Método para agregar un nuevo curso
    private static void agregarCurso() {
        System.out.print("Introduce el código del curso: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduce el nombre del curso: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la descripción del curso: ");
        String descripcion = scanner.nextLine();

        Curso nuevoCurso = new Curso(codigo, nombre, descripcion);
        cursos.add(nuevoCurso);
        System.out.println("Curso agregado: " + nuevoCurso);
    }

    // Método para asignar un alumno a un curso
    private static void asignarAlumnoACurso() {
        mostrarCursos();
        System.out.print("Introduce el código del curso: ");
        String codigoCurso = scanner.nextLine();
        Curso curso = cursos.stream().filter(c -> c.getCodigo().equals(codigoCurso)).findFirst().orElse(null);

        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        System.out.println("\nAlumnos disponibles:");
        alumnos.forEach(System.out::println);
        System.out.print("Introduce el RUT del alumno para asignar: ");
        String rutAlumno = scanner.nextLine();
        Alumno alumno = alumnos.stream().filter(a -> a.getRut().equals(rutAlumno)).findFirst().orElse(null);

        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        cursoAlumnosMap.computeIfAbsent(curso, k -> new ArrayList<>()).add(alumno);
        System.out.println("Alumno " + alumno.getNombre() + " asignado al curso " + curso.getNombre());
    }

    // Método para mostrar la lista de cursos y los alumnos asignados
    private static void mostrarAlumnosPorCurso() {
        cursoAlumnosMap.forEach((curso, alumnos) -> {
            System.out.println("\nCurso: " + curso.getNombre());
            alumnos.forEach(alumno -> System.out.println("  - " + alumno.getNombre()));
        });
    }
}

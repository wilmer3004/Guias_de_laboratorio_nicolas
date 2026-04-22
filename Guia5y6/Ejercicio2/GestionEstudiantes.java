import java.util.HashMap;

public class GestionEstudiantes {

    private HashMap<String, Estudiante> estudiantes = new HashMap<>();

    public void insertar(String codigo, Estudiante e) {
        estudiantes.put(codigo, e);
    }

    public Estudiante consultar(String codigo) {
        return estudiantes.get(codigo);
    }

    public boolean modificar(String codigo, Estudiante nuevo) {
        if (estudiantes.containsKey(codigo)) {
            estudiantes.put(codigo, nuevo);
            return true;
        }
        return false;
    }

    public boolean eliminar(String codigo) {
        return estudiantes.remove(codigo) != null;
    }

    public void mostrarTodos() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes.");
            return;
        }

        for (String codigo : estudiantes.keySet()) {
            System.out.println("Código: " + codigo + " -> " + estudiantes.get(codigo));
        }
    }
}
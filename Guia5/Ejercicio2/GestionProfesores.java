import java.util.HashMap;

public class GestionProfesores {

    private HashMap<String, Profesor> profesores = new HashMap<>();

    public void insertar(String codigo, Profesor p) {
        profesores.put(codigo, p);
    }

    public Profesor consultar(String codigo) {
        return profesores.get(codigo);
    }

    public boolean modificar(String codigo, Profesor nuevo) {
        if (profesores.containsKey(codigo)) {
            profesores.put(codigo, nuevo);
            return true;
        }
        return false;
    }

    public boolean eliminar(String codigo) {
        return profesores.remove(codigo) != null;
    }

    public void mostrarTodos() {
        for (String codigo : profesores.keySet()) {
            System.out.println("Código: " + codigo + " -> " + profesores.get(codigo));
        }
    }
}
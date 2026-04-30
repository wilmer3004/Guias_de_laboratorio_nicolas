import java.util.HashMap;

public class GestionAdministrativos {

    private HashMap<String, Administrativo> administrativos = new HashMap<>();

    public void insertar(String codigo, Administrativo a) {
        administrativos.put(codigo, a);
    }

    public Administrativo consultar(String codigo) {
        return administrativos.get(codigo);
    }

    public boolean modificar(String codigo, Administrativo nuevo) {
        if (administrativos.containsKey(codigo)) {
            administrativos.put(codigo, nuevo);
            return true;
        }
        return false;
    }

    public boolean eliminar(String codigo) {
        return administrativos.remove(codigo) != null;
    }

    public void mostrarTodos() {
        for (String codigo : administrativos.keySet()) {
            System.out.println("Código: " + codigo + " -> " + administrativos.get(codigo));
        }
    }
}
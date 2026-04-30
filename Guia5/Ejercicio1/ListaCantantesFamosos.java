import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ListaCantantesFamosos {

    private final ArrayList<CantanteFamoso> lista;

    public ListaCantantesFamosos() {
        lista = new ArrayList<>();
    }

    // ───────── CRUD ─────────

    public void aniadir(CantanteFamoso c) {
        lista.add(c);
    }

    public boolean eliminar(int index) {
        if (index < 0 || index >= lista.size()) return false;
        lista.remove(index);
        return true;
    }

    public boolean modificar(int index, String nombre, String disco, int ventas) {
        if (index < 0 || index >= lista.size()) return false;

        CantanteFamoso c = lista.get(index);
        c.setNombre(nombre);
        c.setDiscoConMasVentas(disco);
        c.setTotalDeVentas(ventas);
        return true;
    }

    // ───────── ITERATOR ─────────

    public void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("  (Lista vacía)");
            return;
        }

        Iterator<CantanteFamoso> it = lista.iterator();
        int i = 1;

        while (it.hasNext()) {
            System.out.printf("  [%d] %s%n", i++, it.next());
        }
    }

    // ───────── ORDENAMIENTO (MEJORADO) ─────────

    public ArrayList<CantanteFamoso> ordenar(boolean asc) {
        ArrayList<CantanteFamoso> copia = new ArrayList<>(lista);

        copia.sort(Comparator.comparingInt(CantanteFamoso::getTotalDeVentas));

        if (!asc) {
            Collections.reverse(copia);
        }

        return copia;
    }

    // ───────── BÚSQUEDA BINARIA ─────────

    public ArrayList<CantanteFamoso> busquedaBinaria(int ventas) {
        ArrayList<CantanteFamoso> sorted = ordenar(true);
        ArrayList<CantanteFamoso> resultado = new ArrayList<>();

        int left = 0;
        int right = sorted.size() - 1;
        int encontrado = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = sorted.get(mid).getTotalDeVentas();

            if (midVal == ventas) {
                encontrado = mid;
                break;
            } else if (midVal < ventas) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (encontrado == -1) return resultado;

        int i = encontrado;

        while (i >= 0 && sorted.get(i).getTotalDeVentas() == ventas) i--;
        i++;

        while (i < sorted.size() && sorted.get(i).getTotalDeVentas() == ventas) {
            resultado.add(sorted.get(i));
            i++;
        }

        return resultado;
    }

    // ───────── UTILIDADES ─────────

    public int size() { return lista.size(); }
    public boolean estaVacia() { return lista.isEmpty(); }
    public CantanteFamoso get(int i) { return lista.get(i); }
}
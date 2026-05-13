import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {

    Nodo raiz;

    public void insertar(String dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private Nodo insertarRecursivo(Nodo actual, String dato) {

        if (actual == null) {
            return new Nodo(dato);
        }

        if (dato.compareTo(actual.dato) < 0) {
            actual.izquierda = insertarRecursivo(actual.izquierda, dato);
        } else {
            actual.derecha = insertarRecursivo(actual.derecha, dato);
        }

        return actual;
    }

    // RECORRIDO INORDEN
    public void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda);
            System.out.print(nodo.dato + " ");
            inOrden(nodo.derecha);
        }
    }

    // PREORDEN
    public void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrden(nodo.izquierda);
            preOrden(nodo.derecha);
        }
    }

    // POSTORDEN
    public void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierda);
            postOrden(nodo.derecha);
            System.out.print(nodo.dato + " ");
        }
    }

    // ALTURA
    public int altura(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }

        int izquierda = altura(nodo.izquierda);
        int derecha = altura(nodo.derecha);

        return Math.max(izquierda, derecha) + 1;
    }

    // GRADO DEL ÁRBOL
    public int grado(Nodo nodo) {

        if (nodo == null) {
            return 0;
        }

        int hijos = 0;

        if (nodo.izquierda != null) hijos++;
        if (nodo.derecha != null) hijos++;

        int gradoIzq = grado(nodo.izquierda);
        int gradoDer = grado(nodo.derecha);

        return Math.max(hijos, Math.max(gradoIzq, gradoDer));
    }

    // NIVEL DE UN NODO
    public int nivelNodo(Nodo nodo, String dato, int nivel) {

        if (nodo == null) {
            return -1;
        }

        if (nodo.dato.equals(dato)) {
            return nivel;
        }

        int izquierda = nivelNodo(nodo.izquierda, dato, nivel + 1);

        if (izquierda != -1) {
            return izquierda;
        }

        return nivelNodo(nodo.derecha, dato, nivel + 1);
    }

    // BÚSQUEDA EN AMPLITUD
    public void busquedaAmplitud() {

        if (raiz == null) {
            return;
        }

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {

            Nodo actual = cola.poll();

            System.out.print(actual.dato + " ");

            if (actual.izquierda != null) {
                cola.add(actual.izquierda);
            }

            if (actual.derecha != null) {
                cola.add(actual.derecha);
            }
        }
    }
}
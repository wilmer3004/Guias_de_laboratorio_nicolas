
public class ArbolBinarioBusqueda {

    NodoArbol raiz;

    // INSERTAR
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, int dato) {

        if (actual == null) {
            return new NodoArbol(dato);
        }

        if (dato < actual.dato) {
            actual.izquierda = insertarRecursivo(actual.izquierda, dato);
        } else if (dato > actual.dato) {
            actual.derecha = insertarRecursivo(actual.derecha, dato);
        }

        return actual;
    }

    // BUSCAR
    public boolean buscar(int dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(NodoArbol actual, int dato) {

        if (actual == null) {
            return false;
        }

        if (dato == actual.dato) {
            return true;
        }

        if (dato < actual.dato) {
            return buscarRecursivo(actual.izquierda, dato);
        } else {
            return buscarRecursivo(actual.derecha, dato);
        }
    }

    // RECORRIDO INORDEN
    public void inOrden(NodoArbol nodo) {

        if (nodo != null) {

            inOrden(nodo.izquierda);

            System.out.print(nodo.dato + " ");

            inOrden(nodo.derecha);
        }
    }

    // RECORRIDO PREORDEN
    public void preOrden(NodoArbol nodo) {

        if (nodo != null) {

            System.out.print(nodo.dato + " ");

            preOrden(nodo.izquierda);

            preOrden(nodo.derecha);
        }
    }

    // RECORRIDO POSTORDEN
    public void postOrden(NodoArbol nodo) {

        if (nodo != null) {

            postOrden(nodo.izquierda);

            postOrden(nodo.derecha);

            System.out.print(nodo.dato + " ");
        }
    }

    // ELIMINAR NODO
    public void eliminar(int dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    private NodoArbol eliminarRecursivo(NodoArbol actual, int dato) {

        if (actual == null) {
            return null;
        }

        if (dato < actual.dato) {

            actual.izquierda = eliminarRecursivo(actual.izquierda, dato);

        } else if (dato > actual.dato) {

            actual.derecha = eliminarRecursivo(actual.derecha, dato);

        } else {

            // Nodo sin hijos
            if (actual.izquierda == null && actual.derecha == null) {
                return null;
            }

            // Nodo con un hijo
            if (actual.izquierda == null) {
                return actual.derecha;
            }

            if (actual.derecha == null) {
                return actual.izquierda;
            }

            // Nodo con dos hijos
            int menorValor = encontrarMenor(actual.derecha);

            actual.dato = menorValor;

            actual.derecha = eliminarRecursivo(actual.derecha, menorValor);
        }

        return actual;
    }

    // ENCONTRAR MENOR
    private int encontrarMenor(NodoArbol nodo) {

        int menor = nodo.dato;

        while (nodo.izquierda != null) {
            menor = nodo.izquierda.dato;
            nodo = nodo.izquierda;
        }

        return menor;
    }

    // VERIFICAR SI EL ÁRBOL ES LLENO
    public boolean esLleno(NodoArbol nodo) {

        if (nodo == null) {
            return true;
        }

        // Si tiene un solo hijo
        if ((nodo.izquierda == null && nodo.derecha != null) ||
            (nodo.izquierda != null && nodo.derecha == null)) {

            return false;
        }

        return esLleno(nodo.izquierda) &&
               esLleno(nodo.derecha);
    }
}
package Ejercicio1;

class ListaCircular {
    private Nodo cabeza;

    // Verificar si está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Insertar al final
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
    }

    // Mostrar lista
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo temp = cabeza;
        do {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        } while (temp != cabeza);

        System.out.println("(cabeza)");
    }

    // Buscar posición de un valor
    public int buscar(int valor) {
        if (estaVacia()) return -1;

        Nodo temp = cabeza;
        int pos = 0;

        do {
            if (temp.dato == valor) return pos;
            temp = temp.siguiente;
            pos++;
        } while (temp != cabeza);

        return -1;
    }

    // Actualizar valor
    public boolean actualizar(int viejo, int nuevo) {
        if (estaVacia()) return false;

        Nodo temp = cabeza;

        do {
            if (temp.dato == viejo) {
                temp.dato = nuevo;
                return true;
            }
            temp = temp.siguiente;
        } while (temp != cabeza);

        return false;
    }

    // Eliminar nodo
    public boolean eliminar(int valor) {
        if (estaVacia()) return false;

        Nodo actual = cabeza;
        Nodo anterior = null;

        do {
            if (actual.dato == valor) {

                // Caso: un solo nodo
                if (actual == cabeza && actual.siguiente == cabeza) {
                    cabeza = null;
                    return true;
                }

                // Caso: eliminar cabeza
                if (actual == cabeza) {
                    Nodo temp = cabeza;
                    while (temp.siguiente != cabeza) {
                        temp = temp.siguiente;
                    }
                    cabeza = cabeza.siguiente;
                    temp.siguiente = cabeza;
                    return true;
                }

                // Caso: nodo intermedio o final
                anterior.siguiente = actual.siguiente;
                return true;
            }

            anterior = actual;
            actual = actual.siguiente;

        } while (actual != cabeza);

        return false;
    }

    // 🔥 ORDENAR LISTA (Burbuja)
    public void ordenar() {
        if (estaVacia() || cabeza.siguiente == cabeza) return;

        boolean cambio;

        do {
            cambio = false;
            Nodo actual = cabeza;

            do {
                Nodo siguiente = actual.siguiente;

                // Evitar comparar con cabeza al final
                if (siguiente != cabeza && actual.dato > siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    cambio = true;
                }

                actual = actual.siguiente;

            } while (actual.siguiente != cabeza);

        } while (cambio);
    }
}
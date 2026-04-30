package Ejercicio4;

class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamaño;

    public Cola() {
        frente = null;
        fin = null;
        tamaño = 0;
    }

    // 🔹 Verificar si está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // 🔹 Encolar (insertar)
    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }

    // 🔹 Desencolar (eliminar)
    public T desencolar() {
        if (estaVacia()) return null;

        T dato = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        tamaño--;
        return dato;
    }

    // 🔹 Ver frente
    public T frente() {
        return estaVacia() ? null : frente.dato;
    }

    // 🔹 Tamaño
    public int tamaño() {
        return tamaño;
    }

    // 🔹 Vaciar cola
    public void vaciar() {
        frente = null;
        fin = null;
        tamaño = 0;
    }

    // 🔹 Buscar elemento
    public boolean buscar(T valor) {
        Nodo<T> temp = frente;
        while (temp != null) {
            if (temp.dato.equals(valor)) return true;
            temp = temp.siguiente;
        }
        return false;
    }

    // 🔹 Mostrar cola
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Cola vacía");
            return;
        }

        Nodo<T> temp = frente;
        System.out.print("Frente -> ");
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("Fin");
    }
}
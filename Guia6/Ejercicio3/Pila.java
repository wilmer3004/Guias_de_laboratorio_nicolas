package Ejercicio3;

class Pila<T> {
    private Nodo<T> cima;

    public boolean estaVacia() {
        return cima == null;
    }

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public T pop() {
        if (estaVacia()) return null;
        T dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    public T peek() {
        return (estaVacia()) ? null : cima.dato;
    }
}
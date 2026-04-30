package Ejercicio2;

class Pila {
    private Nodo cima;
    private String nombre;

    public Pila(String nombre) {
        this.nombre = nombre;
        this.cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void push(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public int pop() {
        if (estaVacia()) return -1;

        int valor = cima.dato;
        cima = cima.siguiente;
        return valor;
    }

    public int peek() {
        if (estaVacia()) return -1;
        return cima.dato;
    }

    public String getNombre() {
        return nombre;
    }

    public Nodo getCima() {
        return cima;
    }
}
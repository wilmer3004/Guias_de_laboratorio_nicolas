package Ejercicio2;

class Hanoi {
    private Pila A;
    private Pila B;
    private Pila C;
    private int movimientos = 0;

    public Hanoi(int n) {
        A = new Pila("A");
        B = new Pila("B");
        C = new Pila("C");

        // Llenar torre A
        for (int i = n; i >= 1; i--) {
            A.push(i);
        }
    }

    public void resolver(int n, Pila origen, Pila auxiliar, Pila destino) {
        if (n == 1) {
            mover(origen, destino);
        } else {
            resolver(n - 1, origen, destino, auxiliar);
            mover(origen, destino);
            resolver(n - 1, auxiliar, origen, destino);
        }
    }

    private void mover(Pila origen, Pila destino) {
        int disco = origen.pop();
        destino.push(disco);
        movimientos++;

        System.out.println("\nMovimiento #" + movimientos +
                ": " + origen.getNombre() + " -> " + destino.getNombre());

        mostrarTorres();
    }

    public void iniciar(int n) {
        System.out.println("Estado inicial:");
        mostrarTorres();

        resolver(n, A, B, C);

        System.out.println("\n✅ Resuelto en " + movimientos + " movimientos");
    }

    //  Visualización en consola
    public void mostrarTorres() {
        System.out.println("A\tB\tC");

        Nodo a = A.getCima();
        Nodo b = B.getCima();
        Nodo c = C.getCima();

        // Mostrar hasta cierta altura
        for (int i = 0; i < 5; i++) {
            String valA = (a != null) ? String.valueOf(a.dato) : "|";
            String valB = (b != null) ? String.valueOf(b.dato) : "|";
            String valC = (c != null) ? String.valueOf(c.dato) : "|";

            System.out.println(valA + "\t" + valB + "\t" + valC);

            if (a != null) a = a.siguiente;
            if (b != null) b = b.siguiente;
            if (c != null) c = c.siguiente;
        }

        System.out.println("---------------------");
    }
}
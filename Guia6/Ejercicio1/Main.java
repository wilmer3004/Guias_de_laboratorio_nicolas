package Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCircular lista = new ListaCircular();
        int opcion;

        do {
            System.out.println("\n--- MENU LISTA CIRCULAR ---");
            System.out.println("1. Insertar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("6. Ordenar");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Dato: ");
                    lista.insertar(sc.nextInt());
                    break;

                case 2:
                    lista.mostrar();
                    break;

                case 3:
                    System.out.print("Valor a buscar: ");
                    int pos = lista.buscar(sc.nextInt());
                    System.out.println(pos != -1 ? "Posición: " + pos : "No encontrado");
                    break;

                case 4:
                    System.out.print("Valor actual: ");
                    int viejo = sc.nextInt();
                    System.out.print("Nuevo valor: ");
                    int nuevo = sc.nextInt();
                    System.out.println(lista.actualizar(viejo, nuevo) ? "Actualizado" : "No encontrado");
                    break;

                case 5:
                    System.out.print("Valor a eliminar: ");
                    System.out.println(lista.eliminar(sc.nextInt()) ? "Eliminado" : "No encontrado");
                    break;

                case 6:
                    lista.ordenar();
                    System.out.println("Lista ordenada");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
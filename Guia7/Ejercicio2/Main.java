import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        int opcion;
        int dato;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Buscar nodo");
            System.out.println("3. Eliminar nodo");
            System.out.println("4. Recorrido InOrden");
            System.out.println("5. Recorrido PreOrden");
            System.out.println("6. Recorrido PostOrden");
            System.out.println("7. Verificar si el árbol es lleno");
            System.out.println("8. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese dato: ");
                    dato = sc.nextInt();

                    arbol.insertar(dato);

                    System.out.println("Nodo insertado.");

                    break;

                case 2:

                    System.out.print("Ingrese dato a buscar: ");
                    dato = sc.nextInt();

                    if (arbol.buscar(dato)) {
                        System.out.println("Nodo encontrado.");
                    } else {
                        System.out.println("Nodo NO encontrado.");
                    }

                    break;

                case 3:

                    System.out.print("Ingrese dato a eliminar: ");
                    dato = sc.nextInt();

                    arbol.eliminar(dato);

                    System.out.println("Nodo eliminado.");

                    break;

                case 4:

                    System.out.println("\nRecorrido InOrden:");

                    arbol.inOrden(arbol.raiz);

                    System.out.println();

                    break;

                case 5:

                    System.out.println("\nRecorrido PreOrden:");

                    arbol.preOrden(arbol.raiz);

                    System.out.println();

                    break;

                case 6:

                    System.out.println("\nRecorrido PostOrden:");

                    arbol.postOrden(arbol.raiz);

                    System.out.println();

                    break;

                case 7:

                    if (arbol.esLleno(arbol.raiz)) {
                        System.out.println("El árbol es lleno.");
                    } else {
                        System.out.println("El árbol NO es lleno.");
                    }

                    break;

                case 8:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 8);

        sc.close();
    }
}
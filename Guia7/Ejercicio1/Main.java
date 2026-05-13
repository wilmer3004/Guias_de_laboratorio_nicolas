import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArbolBinario arbol = new ArbolBinario();

        int opcion;

        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar dato");
            System.out.println("2. Recorrido InOrden");
            System.out.println("3. Recorrido PreOrden");
            System.out.println("4. Recorrido PostOrden");
            System.out.println("5. Altura");
            System.out.println("6. Grado");
            System.out.println("7. Nivel de un nodo");
            System.out.println("8. Busqueda en amplitud");
            System.out.println("9. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese dato: ");
                    String dato = sc.nextLine();
                    arbol.insertar(dato);
                    break;

                case 2:
                    arbol.inOrden(arbol.raiz);
                    break;

                case 3:
                    arbol.preOrden(arbol.raiz);
                    break;

                case 4:
                    arbol.postOrden(arbol.raiz);
                    break;

                case 5:
                    System.out.println("Altura: " + arbol.altura(arbol.raiz));
                    break;

                case 6:
                    System.out.println("Grado: " + arbol.grado(arbol.raiz));
                    break;

                case 7:
                    System.out.print("Nodo a buscar: ");
                    String buscar = sc.nextLine();

                    int nivel = arbol.nivelNodo(arbol.raiz, buscar, 0);

                    System.out.println("Nivel: " + nivel);
                    break;

                case 8:
                    arbol.busquedaAmplitud();
                    break;
            }

        } while (opcion != 9);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cola<Integer> cola = new Cola<>();

        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("        TAD COLA (QUEUE)      ");
            System.out.println("==============================");
            System.out.println("1. Encolar");
            System.out.println("2. Desencolar");
            System.out.println("3. Ver frente");
            System.out.println("4. Buscar elemento");
            System.out.println("5. Mostrar cola");
            System.out.println("6. Tamaño");
            System.out.println("7. Vaciar cola");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese dato: ");
                    cola.encolar(sc.nextInt());
                    System.out.println("✅ Elemento encolado");
                    break;

                case 2:
                    Integer eliminado = cola.desencolar();
                    System.out.println(eliminado != null ?
                            "🗑 Eliminado: " + eliminado :
                            "❌ Cola vacía");
                    break;

                case 3:
                    System.out.println(cola.frente() != null ?
                            "👀 Frente: " + cola.frente() :
                            "❌ Cola vacía");
                    break;

                case 4:
                    System.out.print("Valor a buscar: ");
                    System.out.println(cola.buscar(sc.nextInt()) ?
                            "🔍 Encontrado" : "❌ No está");
                    break;

                case 5:
                    cola.mostrar();
                    break;

                case 6:
                    System.out.println("📏 Tamaño: " + cola.tamaño());
                    break;

                case 7:
                    cola.vaciar();
                    System.out.println("🧹 Cola vaciada");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("❌ Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
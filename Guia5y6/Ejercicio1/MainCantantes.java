import java.util.ArrayList;
import java.util.Scanner;

public class MainCantantes {

    private static Scanner sc = new Scanner(System.in);

    private static final String LINE  = "═".repeat(70);
    private static final String LINE2 = "─".repeat(70);

    public static void main(String[] args) {

        ListaCantantesFamosos lista = new ListaCantantesFamosos();

        lista.aniadir(new CantanteFamoso("Michael Jackson", "Thriller", 66000000));
        lista.aniadir(new CantanteFamoso("AC/DC", "Back in Black", 50000000));

        boolean salir = false;

        while (!salir) {
            mostrarTitulo("SISTEMA DE CANTANTES");
            menu();
            String op = sc.nextLine().toUpperCase();

            switch (op) {

                case "A":
                    mostrarTitulo("AÑADIR CANTANTE");
                    lista.aniadir(crearCantante());
                    mensajeOK("Cantante añadido correctamente");
                    pausa();
                    break;

                case "B":
                    mostrarTitulo("LISTA DE CANTANTES");
                    mostrarTabla(lista);
                    pausa();
                    break;

                case "C":
                    mostrarTitulo("ELIMINAR CANTANTE");
                    mostrarTabla(lista);
                    System.out.print("\n  ➤ Índice a eliminar: ");
                    int e = leerEntero() - 1;

                    if (lista.eliminar(e)) mensajeOK("Eliminado correctamente");
                    else mensajeError("Índice inválido");

                    pausa();
                    break;

                case "D":
                    mostrarTitulo("MODIFICAR CANTANTE");
                    mostrarTabla(lista);

                    System.out.print("\n  ➤ Índice a modificar: ");
                    int m = leerEntero() - 1;

                    if (m < 0 || m >= lista.size()) {
                        mensajeError("Índice inválido");
                        pausa();
                        break;
                    }

                    CantanteFamoso actual = lista.get(m);

                    System.out.println("\n  (Enter para mantener valor actual)");

                    System.out.print("  Nombre [" + actual.getNombre() + "]: ");
                    String nombre = leerTextoOpcional(actual.getNombre());

                    System.out.print("  Disco [" + actual.getDiscoConMasVentas() + "]: ");
                    String disco = leerTextoOpcional(actual.getDiscoConMasVentas());

                    System.out.print("  Ventas [" + actual.getTotalDeVentas() + "]: ");
                    int ventas = leerEnteroOpcional(actual.getTotalDeVentas());

                    lista.modificar(m, nombre, disco, ventas);

                    mensajeOK("Modificado correctamente");
                    pausa();
                    break;

                case "E":
                    mostrarTitulo("ORDEN MAYOR → MENOR");
                    mostrarOrden(lista.ordenar(false));
                    pausa();
                    break;

                case "F":
                    mostrarTitulo("ORDEN MENOR → MAYOR");
                    mostrarOrden(lista.ordenar(true));
                    pausa();
                    break;

                case "G":
                    mostrarTitulo("BÚSQUEDA POR VENTAS");
                    System.out.print("  ➤ Ventas a buscar: ");
                    int v = leerEntero();

                    ArrayList<CantanteFamoso> res = lista.busquedaBinaria(v);

                    if (res.isEmpty()) {
                        mensajeError("No encontrado");
                    } else {
                        mostrarOrden(res);
                    }

                    pausa();
                    break;

                case "S":
                    mostrarTitulo("SALIENDO DEL SISTEMA");
                    mensajeOK("Hasta luego 👋");
                    salir = true;
                    break;

                default:
                    mensajeError("Opción inválida");
                    pausa();
            }
        }
    }

    // ════════════════════════════════════════════════
    // UI BONITA
    // ════════════════════════════════════════════════

    private static void mostrarTitulo(String titulo) {
        System.out.println("\n" + LINE);
        System.out.printf("  %-66s%n", titulo);
        System.out.println(LINE);
    }

    private static void menu() {
        System.out.println("\n  A) Añadir cantante");
        System.out.println("  B) Mostrar lista");
        System.out.println("  C) Eliminar");
        System.out.println("  D) Modificar");
        System.out.println("  E) Ordenar (Mayor → Menor)");
        System.out.println("  F) Ordenar (Menor → Mayor)");
        System.out.println("  G) Buscar por ventas");
        System.out.println("  S) Salir");
        System.out.println(LINE2);
        System.out.print("  ➤ Seleccione una opción: ");
    }

    private static void mostrarTabla(ListaCantantesFamosos lista) {
        System.out.println(LINE2);
        System.out.printf("  %-4s %-25s %-25s %10s%n",
                "#", "ARTISTA", "DISCO", "VENTAS");
        System.out.println(LINE2);

        if (lista.estaVacia()) {
            System.out.println("  (Lista vacía)");
            return;
        }

        for (int i = 0; i < lista.size(); i++) {
            CantanteFamoso c = lista.get(i);
            System.out.printf("  [%2d] %-25s %-25s %,10d%n",
                    i + 1,
                    c.getNombre(),
                    c.getDiscoConMasVentas(),
                    c.getTotalDeVentas());
        }
    }

    private static void mostrarOrden(ArrayList<CantanteFamoso> lista) {
        System.out.println(LINE2);
        int i = 1;
        for (CantanteFamoso c : lista) {
            System.out.printf("  [%2d] %s%n", i++, c);
        }
    }

    private static void mensajeOK(String msg) {
        System.out.println("\n  ✔ " + msg);
    }

    private static void mensajeError(String msg) {
        System.out.println("\n  ✖ " + msg);
    }

    private static void pausa() {
        System.out.print("\n  Presiona ENTER para continuar...");
        sc.nextLine();
    }

    // ════════════════════════════════════════════════
    // INPUT
    // ════════════════════════════════════════════════

    private static CantanteFamoso crearCantante() {
        System.out.print("  Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("  Disco: ");
        String disco = sc.nextLine();

        System.out.print("  Ventas: ");
        int ventas = leerEntero();

        return new CantanteFamoso(nombre, disco, ventas);
    }

    private static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("  ⚠ Número inválido: ");
            }
        }
    }

    private static int leerEnteroOpcional(int actual) {
        String input = sc.nextLine();
        if (input.isEmpty()) return actual;

        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return actual;
        }
    }

    private static String leerTextoOpcional(String actual) {
        String input = sc.nextLine();
        return input.isEmpty() ? actual : input;
    }
}
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        GestionEstudiantes ge = new GestionEstudiantes();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU ESTUDIANTES ===");
            System.out.println("1. Insertar");
            System.out.println("2. Consultar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("5. Mostrar todos");
            System.out.println("0. Salir");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Código: ");
                    String cod = sc.nextLine();

                    ge.insertar(cod, crearEstudiante());
                    break;

                case 2:
                    System.out.print("Código: ");
                    System.out.println(ge.consultar(sc.nextLine()));
                    break;

                case 3:
                    System.out.print("Código: ");
                    String c = sc.nextLine();

                    if (ge.modificar(c, crearEstudiante()))
                        System.out.println("Modificado");
                    else
                        System.out.println("No existe");
                    break;

                case 4:
                    System.out.print("Código: ");
                    if (ge.eliminar(sc.nextLine()))
                        System.out.println("Eliminado");
                    else
                        System.out.println("No existe");
                    break;

                case 5:
                    ge.mostrarTodos();
                    break;

                case 0:
                    salir = true;
            }
        }
    }

    private static Estudiante crearEstudiante() {
        System.out.print("Nombres: ");
        String n = sc.nextLine();

        System.out.print("Apellidos: ");
        String a = sc.nextLine();

        System.out.print("Direccion: ");
        String d = sc.nextLine();

        System.out.print("Telefono: ");
        String t = sc.nextLine();

        System.out.print("Carrera: ");
        String c = sc.nextLine();

        return new Estudiante(n, a, d, t, c);
    }
}
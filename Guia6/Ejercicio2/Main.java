package Ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TORRES DE HANOI ===");
        System.out.print("Ingrese número de discos: ");
        int n = sc.nextInt();

        Hanoi juego = new Hanoi(n);
        juego.iniciar(n);

        sc.close();
    }
}
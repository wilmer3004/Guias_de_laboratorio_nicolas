package Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("   EVALUADOR DE EXPRESIONES (PILAS)  ");
        System.out.println("=====================================");

        System.out.print("Ingrese expresión infija: ");
        String expresion = sc.nextLine().replaceAll(" ", "");

        // 1. Verificar balanceo
        if (!Expresion.balanceada(expresion)) {
            System.out.println("❌ Error: Expresión NO balanceada");
            return;
        }

        System.out.println("✅ Expresión balanceada");

        // 2. Convertir a postfija
        String postfija = Expresion.infijaAPostfija(expresion);
        System.out.println("📌 Notación Postfija: " + postfija);

        // 3. Evaluar
        double resultado = Expresion.evaluarPostfija(postfija);
        System.out.println("🧮 Resultado: " + resultado);

        System.out.println("=====================================");

        sc.close();
    }
}
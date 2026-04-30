package Ejercicio3;

class Expresion {

    // 🔹 Verificar balanceo
    public static boolean balanceada(String exp) {
        Pila<Character> pila = new Pila<>();

        for (char c : exp.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.estaVacia()) return false;

                char tope = pila.pop();
                if (!esPareja(tope, c)) return false;
            }
        }
        return pila.estaVacia();
    }

    private static boolean esPareja(char a, char b) {
        return (a == '(' && b == ')') ||
               (a == '[' && b == ']') ||
               (a == '{' && b == '}');
    }

    // 🔹 Prioridad de operadores
    private static int prioridad(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return 0;
    }

    // 🔹 Infija → Postfija
    public static String infijaAPostfija(String exp) {
        Pila<Character> pila = new Pila<>();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // Números (varios dígitos)
            if (Character.isDigit(c)) {
                while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                    salida.append(exp.charAt(i));
                    i++;
                }
                salida.append(" ");
                i--;
            }
            // Paréntesis apertura
            else if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            }
            // Paréntesis cierre
            else if (c == ')' || c == ']' || c == '}') {
                while (!pila.estaVacia() && !esApertura(pila.peek())) {
                    salida.append(pila.pop()).append(" ");
                }
                pila.pop(); // quitar apertura
            }
            // Operadores
            else if (esOperador(c)) {
                while (!pila.estaVacia() &&
                       prioridad(pila.peek()) >= prioridad(c)) {
                    salida.append(pila.pop()).append(" ");
                }
                pila.push(c);
            }
        }

        while (!pila.estaVacia()) {
            salida.append(pila.pop()).append(" ");
        }

        return salida.toString();
    }

    private static boolean esOperador(char c) {
        return "+-*/^".indexOf(c) != -1;
    }

    private static boolean esApertura(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    // 🔹 Evaluar Postfija
    public static double evaluarPostfija(String post) {
        Pila<Double> pila = new Pila<>();
        String[] tokens = post.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            if (token.matches("\\d+")) {
                pila.push(Double.parseDouble(token));
            } else {
                double b = pila.pop();
                double a = pila.pop();

                switch (token.charAt(0)) {
                    case '+': pila.push(a + b); break;
                    case '-': pila.push(a - b); break;
                    case '*': pila.push(a * b); break;
                    case '/': pila.push(a / b); break;
                    case '^': pila.push(Math.pow(a, b)); break;
                }
            }
        }
        return pila.pop();
    }
}
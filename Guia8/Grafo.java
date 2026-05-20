import java.util.*;

public class Grafo {

    private int vertices;

    private LinkedList<Arista>[] listaAdyacencia;

@SuppressWarnings("unchecked")

    public Grafo(int vertices) {

        this.vertices = vertices;

        listaAdyacencia = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {

            listaAdyacencia[i] = new LinkedList<>();
        }
    }

    // AGREGAR ARISTA

    public void agregarArista(int origen,
                               int destino,
                               int peso) {

        listaAdyacencia[origen]
                .add(new Arista(destino,peso));

        listaAdyacencia[destino]
                .add(new Arista(origen,peso));
    }

    // MOSTRAR LISTA

    public void mostrarListaAdyacencia() {

        System.out.println("\nLISTA ADYACENCIA");

        for (int i = 0; i < vertices; i++) {

            System.out.print("Nodo " + i + " -> ");

            for (Arista arista :
                    listaAdyacencia[i]) {

                System.out.print("("
                        + arista.destino
                        + ", "
                        + arista.peso
                        + "km) ");
            }

            System.out.println();
        }
    }

    // MATRIZ ADYACENCIA

    public void mostrarMatrizAdyacencia() {

        int[][] matriz =
                new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {

            for (Arista arista :
                    listaAdyacencia[i]) {

                matriz[i][arista.destino]
                        = arista.peso;
            }
        }

        System.out.println("\nMATRIZ ADYACENCIA");

        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {

                System.out.print(
                        matriz[i][j] + "\t");
            }

            System.out.println();
        }
    }

    // BFS

    public void BFS(int inicio) {

        boolean[] visitado =
                new boolean[vertices];

        Queue<Integer> cola =
                new LinkedList<>();

        visitado[inicio] = true;

        cola.add(inicio);

        System.out.println("\nRECORRIDO BFS");

        while (!cola.isEmpty()) {

            int nodo = cola.poll();

            System.out.print(nodo + " ");

            for (Arista arista :
                    listaAdyacencia[nodo]) {

                if (!visitado[arista.destino]) {

                    visitado[arista.destino] = true;

                    cola.add(arista.destino);
                }
            }
        }

        System.out.println();
    }

    // DFS

    public void DFS(int inicio) {

        boolean[] visitado =
                new boolean[vertices];

        System.out.println("\nRECORRIDO DFS");

        DFSRecursivo(inicio, visitado);

        System.out.println();
    }

    private void DFSRecursivo(int nodo,
                              boolean[] visitado) {

        visitado[nodo] = true;

        System.out.print(nodo + " ");

        for (Arista arista :
                listaAdyacencia[nodo]) {

            if (!visitado[arista.destino]) {

                DFSRecursivo(
                        arista.destino,
                        visitado);
            }
        }
    }

    // DIJKSTRA

    public void dijkstra(int inicio) {

        int[] distancia =
                new int[vertices];

        boolean[] visitado =
                new boolean[vertices];

        Arrays.fill(
                distancia,
                Integer.MAX_VALUE);

        distancia[inicio] = 0;

        for (int i = 0;
             i < vertices - 1;
             i++) {

            int u =
                    minimo(distancia, visitado);

            visitado[u] = true;

            for (Arista arista :
                    listaAdyacencia[u]) {

                int v = arista.destino;

                int peso = arista.peso;

                if (!visitado[v]
                        && distancia[u]
                        != Integer.MAX_VALUE
                        && distancia[u]
                        + peso < distancia[v]) {

                    distancia[v]
                            = distancia[u] + peso;
                }
            }
        }

        System.out.println(
                "\nALGORITMO DIJKSTRA");

        for (int i = 0;
             i < vertices;
             i++) {

            System.out.println(
                    "Nodo "
                            + i
                            + " Distancia = "
                            + distancia[i]);
        }
    }

    private int minimo(int[] distancia,
                       boolean[] visitado) {

        int min = Integer.MAX_VALUE;

        int indice = -1;

        for (int i = 0;
             i < vertices;
             i++) {

            if (!visitado[i]
                    && distancia[i] < min) {

                min = distancia[i];

                indice = i;
            }
        }

        return indice;
    }

    // FLOYD WARSHALL

    public void floydWarshall() {

        int INF = 99999;

        int[][] dist =
                new int[vertices][vertices];

        for (int i = 0;
             i < vertices;
             i++) {

            for (int j = 0;
                 j < vertices;
                 j++) {

                if (i == j)
                    dist[i][j] = 0;

                else
                    dist[i][j] = INF;
            }
        }

        for (int i = 0;
             i < vertices;
             i++) {

            for (Arista arista :
                    listaAdyacencia[i]) {

                dist[i][arista.destino]
                        = arista.peso;
            }
        }

        for (int k = 0;
             k < vertices;
             k++) {

            for (int i = 0;
                 i < vertices;
                 i++) {

                for (int j = 0;
                     j < vertices;
                     j++) {

                    if (dist[i][k]
                            + dist[k][j]
                            < dist[i][j]) {

                        dist[i][j]
                                = dist[i][k]
                                + dist[k][j];
                    }
                }
            }
        }

        System.out.println(
                "\nALGORITMO FLOYD");

        for (int i = 0;
             i < vertices;
             i++) {

            for (int j = 0;
                 j < vertices;
                 j++) {

                System.out.print(
                        dist[i][j] + "\t");
            }

            System.out.println();
        }
    }
}
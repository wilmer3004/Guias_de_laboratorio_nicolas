public class Main {

    public static void main(String[] args) {

        Grafo grafo = new Grafo(10);

        // CONEXIONES

        grafo.agregarArista(0,1,5);
        grafo.agregarArista(0,2,7);
        grafo.agregarArista(1,3,4);
        grafo.agregarArista(1,4,6);
        grafo.agregarArista(2,5,3);
        grafo.agregarArista(2,6,8);
        grafo.agregarArista(3,7,2);
        grafo.agregarArista(4,7,5);
        grafo.agregarArista(5,8,7);
        grafo.agregarArista(6,9,4);
        grafo.agregarArista(7,8,1);
        grafo.agregarArista(8,9,2);

        // MOSTRAR

        grafo.mostrarListaAdyacencia();

        grafo.mostrarMatrizAdyacencia();

        grafo.BFS(0);

        grafo.DFS(0);

        grafo.dijkstra(0);

        grafo.floydWarshall();

        // GRAFO VISUAL

        VentanaGrafo.mostrar();
    }
}
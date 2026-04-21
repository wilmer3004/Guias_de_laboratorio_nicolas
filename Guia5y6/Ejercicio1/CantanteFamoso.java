public class CantanteFamoso {

    private String nombre;
    private String discoConMasVentas;
    private int totalDeVentas;

    public CantanteFamoso(String nombre, String discoConMasVentas, int totalDeVentas) {
        this.nombre = nombre;
        this.discoConMasVentas = discoConMasVentas;
        this.totalDeVentas = totalDeVentas;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDiscoConMasVentas() { return discoConMasVentas; }
    public int getTotalDeVentas() { return totalDeVentas; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDiscoConMasVentas(String disco) { this.discoConMasVentas = disco; }
    public void setTotalDeVentas(int totalDeVentas) { this.totalDeVentas = totalDeVentas; }

    @Override
    public String toString() {
        return String.format("%-25s | %-30s | %,d ventas",
                nombre, discoConMasVentas, totalDeVentas);
    }
}
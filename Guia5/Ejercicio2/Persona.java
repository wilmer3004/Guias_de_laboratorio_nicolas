public class Persona {

    protected String nombres;
    protected String apellidos;
    protected String direccion;
    protected String telefono;
    protected String area; // carrera o área

    public Persona(String nombres, String apellidos, String direccion, String telefono, String area) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.area = area;
    }

    // Getters y Setters
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    @Override
    public String toString() {
        return nombres + " " + apellidos + " | " + direccion + " | " + telefono + " | " + area;
    }
}
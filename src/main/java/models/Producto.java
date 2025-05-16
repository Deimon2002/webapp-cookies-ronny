// Paquete donde se encuentra el modelo Producto
package models;

// Clase que representa un producto con sus atributos y métodos
public class Producto {

    // Atributos privados del producto (encapsulamiento)
    private Long id;
    private String nombre;
    private String tipo;
    private double precio;

    // Constructor vacío (necesario para algunas operaciones como frameworks o serialización)
    public Producto() {
    }

    // Constructor con parámetros para inicializar el objeto directamente
    public Producto(Long id, String nombre, String tipo, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Métodos getter y setter para acceder y modificar el atributo id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Métodos getter y setter para el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para el tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Métodos getter y setter para el precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

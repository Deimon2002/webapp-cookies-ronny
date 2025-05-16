// Paquete donde se encuentra la interfaz de servicios
package services;

// Se importa la clase Producto y las utilidades para manejar listas
import models.Producto;
import java.util.List;

// Definición de una interfaz que describe las operaciones disponibles sobre productos
public interface ProductoService {

    // Método que debe implementar cualquier clase que use esta interfaz.
    // Su propósito es devolver una lista de productos.
    List<Producto> listar();
}

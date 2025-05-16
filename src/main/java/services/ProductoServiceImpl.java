// Paquete donde se encuentra la clase que implementa el servicio
package services;

// Se importa la clase Producto y utilidades de colección
import models.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Clase que implementa la interfaz ProductoService
public class ProductoServiceImpl implements ProductoService {

    // Implementación del método listar() definido en la interfaz
    @Override
    public List<Producto> listar() {
        // Retorna una lista fija (inmutable) de productos con valores quemados (hardcoded)
        return Arrays.asList(
                new Producto(1L, "laptop", "computacion", 523.21),
                new Producto(2L, "Mouse", "inalambrico", 15.25),
                new Producto(3L, "Impresora", "tinta continua", 256.25)
        );
    }
}

// Paquete del controlador
package controllers;

// Importación de clases necesarias para Servlets y modelos/servicios usados
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.Producto;
import services.ProductoService;
import services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// Anotación que define la URL en la que se ejecutará este Servlet
@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {

    // Método que responde a las peticiones GET (cuando el usuario accede a /productos)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Se crea una instancia del servicio que gestiona productos
        ProductoServiceImpl services = new ProductoServiceImpl();

        // Se obtiene la lista de productos desde el servicio
        List<Producto> productos = services.listar();

        // Se define el tipo de contenido de la respuesta como HTML con codificación UTF-8
        resp.setContentType("text/html;charset=UTF-8");

        // Se obtiene el escritor para enviar la respuesta al cliente
        PrintWriter out = resp.getWriter();

        // Comienza la construcción del HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>Listar Producto</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Listar producto</h1>");

        // Comienza la tabla para mostrar los productos
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>ID PRODUCTO</th>");
        out.println("<th>NOMBRE</th>");
        out.println("<th>TIPO</th>");
        out.println("<th>PRECIO</th>");
        out.println("</tr>");

        // Recorre la lista de productos y agrega cada uno como una fila en la tabla
        for (Producto p : productos) {
            out.println("<tr>");
            out.println("<td>" + p.getId() + "</td>");
            out.println("<td>" + p.getNombre() + "</td>");
            out.println("<td>" + p.getTipo() + "</td>");
            out.println("<td>" + p.getPrecio() + "</td>");
            out.println("</tr>");
        }

        // Cierra la tabla y el documento HTML
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}

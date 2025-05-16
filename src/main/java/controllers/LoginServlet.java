// Paquete donde se encuentra la clase
package controllers;

// Importación de clases necesarias para el manejo de servlets, cookies y entrada/salida
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

// Anotación que define el servlet y las rutas en las que responderá ("/login" y "/login.html")
@WebServlet({"/login","/login.html"})
public class LoginServlet extends HttpServlet {

    // Credenciales estáticas para autenticación básica
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    // Método que se ejecuta cuando se hace una petición GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se obtienen las cookies de la petición, si no hay se crea un arreglo vacío
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];

        // Se busca una cookie llamada "username"
        Optional<String> cookieOptional = Arrays.stream(cookies)
                .filter(c -> "username".equals(c.getName())) // se filtra por nombre
                .map(Cookie::getValue) // se obtiene su valor
                .findAny(); // se toma cualquiera (solo se espera una)

        if (cookieOptional.isPresent()) {
            // Si la cookie existe, el usuario ya inició sesión anteriormente
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                // Se genera una respuesta HTML personalizada
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"utf-8\">");
                out.println("<title>Bienvenido</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Hola " + cookieOptional.get() + " ya iniciaste sesión anteriormente!</h1>");
                out.println("<p><a href='" + req.getContextPath() + "/index.html'>Volver al inicio</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            // Si no hay cookie, se redirige al formulario de login (login.jsp)
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    // Método que se ejecuta cuando se hace una petición POST (ej. desde el formulario de login)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se obtienen los parámetros del formulario (nombre de usuario y contraseña)
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Se validan las credenciales ingresadas con las credenciales definidas
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // Si las credenciales son correctas, se crea una cookie con el nombre de usuario
            Cookie usernameCookie = new Cookie("username", username);
            resp.addCookie(usernameCookie); // se agrega la cookie a la respuesta

            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                // Se genera una respuesta HTML de bienvenida
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"utf-8\">");
                out.println("<title>Bienvenido a la app</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Bienvenido a mi APP</h1>");
                out.println("</body>");
                out.println("</html>");
            }

            // Redirección a la misma ruta para que se procese de nuevo pero con la cookie establecida
            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else {
            // Si las credenciales no son válidas, se devuelve un error 401 (no autorizado)
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no tiene acceso");
        }
    }
}

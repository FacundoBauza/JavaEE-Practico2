package com.example.demo;

import Clases.Pelicula;

import java.io.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        try (PrintWriter out = response.getWriter()) {
            String aux = "";
            try {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("cineCalidadPU");
                EntityManager e = factory.createEntityManager();

                e.getTransaction().begin();
                e.persist(new Pelicula("wrpbto", "3[o4kgtm", "3po4igtj"));
                e.flush();
                e.getTransaction().commit();
            }
            catch (Exception ex) {
                aux = ex.getMessage();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet altaUsuario</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Tamo aqui</h1>");
                out.println(aux);
                out.println("</body>");
                out.println("</html>");
            }
        }


        /*PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");*/
    }

    public void destroy() {
    }
}
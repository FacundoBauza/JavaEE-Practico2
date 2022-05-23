package Servelets;

import Clases.Pelicula;
import Negocios.PeliculaSessionBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Servelets.PeliServlet.getListaPeliculas;

@WebServlet(name = "buscar", value = "/buscar")
public class buscar extends HttpServlet {

    public List<Pelicula> dataPel(List<Pelicula> aux, String text)
    {
        List<Pelicula> retun = new ArrayList();

        for(Pelicula p: aux)
        {
            int intIndex = p.getNombre().indexOf(text);
            int intIndex1 = p.getDescripcion().indexOf(text);
            if(intIndex != - 1 || intIndex1 != -1){
                retun.add(p);
            }
        }
        return retun;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String texto = request.getParameter("TextoFiltro");

        List<Pelicula> P = (List<Pelicula>) getListaPeliculas(request);
        List<Pelicula> returner = dataPel(P, texto);

        request.setAttribute("LisPel", returner);
        RequestDispatcher rd = request.getRequestDispatcher("MostrarPeliculas.jsp");
        rd.forward(request, response);
    }
}


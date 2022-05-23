package Servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Clases.Pelicula;
import Negocios.*;


/**
 * Servlet implementation class PeliServlet
 */
@WebServlet("/PeliServlet")
public class PeliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeliServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String yourName = request.getParameter("yourName");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + yourName + "</h1>");
		writer.close();*/

		PeliculaSessionBean p = new PeliculaSessionBean();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cineCalidadPU");
		EntityManager e = factory.createEntityManager();

		e.getTransaction().begin();
		for(Pelicula aux : p.getPeliculas()) {
			e.persist(aux);
		}
		e.flush();
		e.getTransaction().commit();

		ISingletone s = Fabrica.getInstance();
		
		HttpSession session = request.getSession();
		session.setAttribute("Singletone", s);
		session.setAttribute("GlobalPelis", p.getPeliculas());
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
	}

	  protected void doGet(HttpServletRequest request,
              HttpServletResponse response) throws IOException {/*
			PrintWriter writer = response.getWriter();
			PeliculaSessionBeanRemote p = new PeliculaSessionBean();
			String message = p.getPelicula(0).toString();
			
			writer.println(message);*/
	  }

	static public List<Pelicula> getListaPeliculas(HttpServletRequest request)
			throws ServletException, IOException {
		return (List<Pelicula>) request.getSession().getAttribute("GlobalPelis");
	}
}

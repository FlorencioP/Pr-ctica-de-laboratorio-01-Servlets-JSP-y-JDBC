package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class VisualizacionProductosIntitado
 */
@WebServlet("/VisualizacionProductosInvitado")
public class VisualizacionProductosInvitado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ProductosDao prodDAO;
	
    public VisualizacionProductosInvitado() {
        prodDAO= DAOFactory.getFactory().getProductosDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		String url2=null;
		try {
			int idEmp=Integer.parseInt(request.getParameter("idEmp"));
			List<Producto> list= prodDAO.findE(idEmp);
			request.setAttribute("listaProd", list);
			url = "/HTMLs/Invitado/invVin.jsp";
		}catch(Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.sql.UpdateTagSupport;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class EditarProds
 */
@WebServlet("/EditarProds")
public class EditarProds extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductosDao proDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProds() {
    	proDao= DAOFactory.getFactory().getProductosDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		try {
			int idEmp=Integer.parseInt(request.getParameter("idEmp"));
			System.out.println(idEmp);
			
			
			
			request.setAttribute("idEmp", idEmp);
			

				
				List<Producto> list=proDao.findE(idEmp);
				
				request.setAttribute("listaProd", list);
				
				Usuario ste = new Usuario(0, "F", "F", "F", "F", 'F',  idEmp);
				
				request.setAttribute("usu", ste);
			
			
			
			url = "/HTMLs/Admin/TablaEditarProds.jsp";
			
		}catch(Exception e) {
			System.out.println("Error : "+e) ;
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

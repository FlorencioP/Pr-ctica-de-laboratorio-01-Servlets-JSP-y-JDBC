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
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class FiltrarProdPorCatInv
 */
@WebServlet("/FiltrarProdPorCatInv")
public class FiltrarProdPorCatInv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductosDao prodDAO;
	
    public FiltrarProdPorCatInv() {
    	prodDAO= DAOFactory.getFactory().getProductosDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		
		String idEmpP=request.getParameter("idEmpre");
		
		String idCatP=request.getParameter("idCat");
		
		
		
		System.out.println(idCatP+" y "+idEmpP);
		
		int idCat =Integer.parseInt(idCatP);
		int idEmp =Integer.parseInt(idEmpP);
		
		System.out.println(idCat+"y"+idCat);
		
		
		Usuario ste = new Usuario(0, "", "", "", "", 'a', idEmp);
		
		
		if(idCat==0) {
			System.out.println("idcat="+idCat);
			
			try {
				
				List<Producto> list= prodDAO.findE(idEmp);
				request.setAttribute("listaProd", list);
				request.setAttribute("idEmp", ste);
				
				url = "/HTMLs/Invitado/ActualizarTablaInv.jsp";
			}catch(Exception e) {
				url = "/JSPs/error.jsp";
			}
		}else {
			try {
				List<Producto> list= prodDAO.findC(idCat,idEmp);
				request.setAttribute("listaProd", list);
				request.setAttribute("idEmp", ste);
				
				url = "/HTMLs/Invitado/ActualizarTablaInv.jsp";
			}catch(Exception e) {
				url = "/JSPs/error.jsp";
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

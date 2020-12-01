package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filtroqweqwe
 */
@WebFilter({"/Filtro","/HTMLs/User/usrVin.jsp","/HTMLs/User/usrVincreate.jsp","/HTMLs/User/MostrarDetalles.jsp",
			"/HTMLs/User/MostrarPedidos.jsp","/HTMLs/User/MensajeExito.jsp","/HTMLs/User/ActualizarDetalles.jsp",
			"/HTMLs/Admin/TablaEditarProds.jsp","/HTMLs/Admin/TablonCrear.jsp","/HTMLs/Admin/usersEmpresa.jsp",
			"/HTMLs/Admin/usersPedidos.jsp","/HTMLs/Admin/usersPedidosDetall.jsp"})
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		if(session.getAttribute("accesos") ==  null) {
			System.out.println("no puedes pasaaar");
			((HttpServletResponse)response).sendRedirect("/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/index.html");
			
		}
		else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

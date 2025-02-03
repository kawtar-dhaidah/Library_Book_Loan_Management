

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.apache.jasper.EmbeddedServletOptions;

import classes.Emprunt;

/**
 * Servlet implementation class FiltreServlet
 */
@WebServlet("/FiltreServlet")
public class FiltreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltreServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	;
		if(!request.getParameter("search_name").isEmpty()) {
		List<Emprunt> Emprunts=new ArrayList<>();
		Emprunts=Emprunt.getEmprunt_name(request.getParameter("search_name"));
		request.setAttribute("client", Emprunts);
		 request.getRequestDispatcher("/name_Search.jsp").forward(request, response);
		}
		
	
		if(!request.getParameter("search_Date").isEmpty()) {
			List<Emprunt> Emprunts=new ArrayList<>();
			Emprunts=Emprunt.getEmprunt_date(request.getParameter("search_Date"));
			request.setAttribute("client", Emprunts);
			 request.getRequestDispatcher("/Date_search.jsp").forward(request, response);
			
		}
	}

}

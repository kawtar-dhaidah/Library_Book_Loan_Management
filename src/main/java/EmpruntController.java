

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jee_pr_oof.Emprunt;
import jee_pr_oof.EmpruntDao;

/**
 * Servlet implementation class EmpruntController
 */
@WebServlet("/EmpruntController")
public class EmpruntController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpruntController() {
        super();
        // TODO Auto-generated constructor stub
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
		String nom = request.getParameter("nom");
        String cin = request.getParameter("cin");
        String tel = request.getParameter("tel");
        String livre = request.getParameter("livre");
        double prix = Double.parseDouble(request.getParameter("prix"));
        Date dateEmprunt = Date.valueOf(request.getParameter("date_emprunt"));
        Date dateRetour = Date.valueOf(request.getParameter("date_retour"));

        Emprunt emprunt = new Emprunt();
        emprunt.setNom(nom);
        emprunt.setCin(cin);
        emprunt.setTel(tel);
        emprunt.setLivre(livre);
        emprunt.setPrix(prix);
        emprunt.setDateEmprunt(dateEmprunt);
        emprunt.setDateRetour(dateRetour);

        EmpruntDao empruntDao = new EmpruntDao();
        empruntDao.insertEmprunt(emprunt);

        response.sendRedirect("tab_emp.jsp");
	}

}

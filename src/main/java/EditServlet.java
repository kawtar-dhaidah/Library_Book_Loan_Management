

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/editurl")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String query = "update livres set nom=?,auteur=?,prix=?,qte=? where id=?";
   	@Override
   	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
   	//get PrintWriter
   			PrintWriter pw = res.getWriter();
   			//set content type
   			res.setContentType("text/html");
   			//get the id of record
   			int id = Integer.parseInt(req.getParameter("id"));
   			//get the edit data we want to edit
   			String Name = req.getParameter("uname");
   			String auteur = req.getParameter("auteur");
   			float prix = Float.parseFloat(req.getParameter("prix"));
   			int qte = Integer.parseInt(req.getParameter("qte"));

   			RegisterDao reg=new RegisterDao();
   	         reg.loadDriver("com.mysql.cj.jdbc.Driver");
   			
   			try {
   				Connection con=reg.getConnection();
   				String query=reg.editservlet(id);
   				PreparedStatement ps = con.prepareStatement(query);
   				ps.setString(1, Name);
   				ps.setString(2, auteur);
   				ps.setFloat(3, prix);
   				ps.setInt(4, qte);

   				ps.setInt(5, id);
   				int count = ps.executeUpdate();
   				if(count==1) {
   					pw.println("<style>");
   					pw.println("div { background-color: #1DA1F2;padding: 20px;text-align: center;border-radius:4px;box-shadow: 14px 14px 20px #cbced1, -14px -14px 20px white;");

   					pw.println("</style>");
   					pw.println("<div>");
   					pw.println("<h2>Le livre a été modifié avec succès !</h2>");
   					
   				}else {
   					pw.println("<h2>Le livre n'a pas été modifié avec succès</h2>");
   				}
   			}catch(SQLException se) {
   				se.printStackTrace();
   				pw.println("<h1>"+se.getMessage()+"</h2>");
   			}catch(Exception e) {
   				e.printStackTrace();
   				pw.println("<h1>"+e.getMessage()+"</h2>");
   			}
   			pw.println("<a href='Livre.jsp'>Ajout</a>");
   			pw.println("<br>");
   			pw.println("<a href='List'>Book List</a>");
   			pw.println("</div>");
   	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

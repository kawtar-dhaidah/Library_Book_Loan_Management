

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditScreenServlet
 */
@WebServlet("/editScreen")
public class EditScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditScreenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //private static final String query = "SELECT nom,auteur,prix,qte FROM livres where id=?";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get the id of record
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			HttpSession session=req.getSession();
			String login="";
			if (session.getAttribute("login")!=null){
				login=session.getAttribute("login").toString();
			}else{
				res.sendRedirect("auth.jsp");
			}
			RegisterDao  r=new RegisterDao();
			ResultSet rs=r.update(id);				
			pw.println("<form action='editurl?id="+id+"' method='post'>");
			
			pw.println("<style>");
			pw.println(".container{ border-spacing: 1;border-collapse: collapse;  background: #ecf0f3;  border-radius: 10px;   overflow: hidden;   position: absolute; left:35%; top: 15%; align-content:center;align-item:center;  box-shadow: 14px 14px 20px #cbced1, -14px -14px 20px white;width:400px;height:450px ; padding:60px }");
			pw.println("th, td { text-align: left; padding: 8px; }");
			pw.println("body { background-color: #ecf0f3;    align-items: center;}");
			pw.println(".b{ width: 40px; padding: 8px; }");
			pw.println(".fct{ position:absolute; top:70%; left:30%}");
			pw.println("h1 {font-size: 24px;  margin-top: 10px; font-weight: 900; font-size: 1.8rem;  color: #1DA1F2; letter-spacing: 1px;  text-align: center;}");
			pw.println("tr:nth-child(even){ background-color: #ecf0f3; }");
			pw.println("input { background: #ecf0f3;  padding: 10px;padding-left: 20px; height: 50px; font-size: 14px; border-radius: 50px; box-shadow: inset 6px 6px 6px #cbced1, inset -6px -6px 6px white;}");
			pw.println(".aj { font-size: 35px;  bottom: 4px;right: 4px;text-decoration: none; color: black; background: #1DA1F2; border-radius: 10px;padding: 2px; }");
			pw.println(".logout{ background:#d8d8d8;width: 100px;cursor:pointer; position:absolute; right:2%; top:2%; border-radius:50px; padding:10px 20px 10px 0; color:White;font-size:14px; text-align:left;text-indent:40px; display:block; margin:0 auto; font-family: Arial, Helvetica, sans-serif;-webkit-transition-timing-function: ease-in-out; -webkit-transition-duration: .4s; -webkit-transition-property: all; -moz-transition-timing-function: ease-in-out;-moz-transition-duration: .4s; -moz-transition-property: all;}");
			pw.println(".logout:hover {background-image: url( 'https://dh3vbjnk0bnfa.cloudfront.net/static/centralauth/images/btn-login.png' );background-position: 65px 5px;text-indent: 15px;  }");
			pw.println(".log_out{text-decoration: none;outline: none;color: black;}");
			pw.println("</style>");
			pw.println("<div  class='logout' > <a  class='log_out' href='Logout' >Logout</a></div> ");
			pw.println("<br>");
			pw.println("<br>");
			pw.println("<br>");
			pw.println("<div class='container'>");

			pw.println("<table class='table table-hover'>");
			pw.println("<h1>Modification d'un Livre</h1>");

			pw.println("<tr>");
			pw.println("<td>Nom de livre</td>");
			pw.println("<td><input type='text' name='uname' value='"+rs.getString(1)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Auteur</td>");
			pw.println("<td><input type='text' name='auteur' value='"+rs.getString(2)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Prix</td>");
			pw.println("<td><input type='text' name='prix' value='"+rs.getFloat(3)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Quantité</td>");
			pw.println("<td><input type='text' name='qte' value='"+rs.getInt(4)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr class='fct'>");
			pw.println("<td class='b'><input type='submit' value='Modifier'></td>");
			pw.println("<td class='b'><input type='reset' value='cancel'></td>");
			pw.println("</tr>");
			pw.println("</table>");
			
			pw.println("</div>");

			pw.println("</form>");
		}catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1>"+se.getMessage()+"</h2>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h2>");
		}
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

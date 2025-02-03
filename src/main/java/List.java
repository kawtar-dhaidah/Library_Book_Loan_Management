

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String query = "SELECT * FROM livres";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		RegisterDao reg=new RegisterDao();
        reg.loadDriver("com.mysql.cj.jdbc.Driver");
		
		try {
			//Connection con=reg.getConnection();
		
			//	PreparedStatement ps = con.prepareStatement(query);
			HttpSession session=req.getSession();
			String login="";
			if (session.getAttribute("login")!=null){
				login=session.getAttribute("login").toString();
			}else{
				res.sendRedirect("auth.jsp");
			}
			ResultSet rs = reg.selectAll();
			
			pw.println("<style>");
			pw.println("table { border-spacing: 1;border-collapse: collapse;  background: #ecf0f3;  border-radius: 10px;   overflow: hidden; width: 100%;  position: relative;  position:center;align-content:center;  box-shadow: 14px 14px 20px #cbced1, -14px -14px 20px white; }");
			pw.println("th, td { text-align: left; padding: 8px; }");
			pw.println("body { background-color: #ecf0f3; }");

			pw.println("th { background-color: #1DA1F2; color: white; }");
			pw.println("tr:nth-child(even){ background-color: #ecf0f3; }");
			pw.println("a { color: #1DA1F2; text-decoration: none; }");
			pw.println(".aj { position: absolute; font-size: 20px;  bottom: 4px;right: 4px;text-decoration: none; background: #1DA1F2 ;color: black;  border-radius: 10px;padding: 10px; }");
			pw.println(".aj1 {  color: black;  }");
			pw.println(".logout{ background:#d8d8d8;width: 100px;cursor:pointer; position:absolute; right:2%; top:2%; border-radius:50px; padding:10px 20px 10px 0; color:White;font-size:14px; text-align:left;text-indent:40px; display:block; margin:0 auto; font-family: Arial, Helvetica, sans-serif;-webkit-transition-timing-function: ease-in-out; -webkit-transition-duration: .4s; -webkit-transition-property: all; -moz-transition-timing-function: ease-in-out;-moz-transition-duration: .4s; -moz-transition-property: all;}");
			pw.println(".logout:hover {background-image: url( 'https://dh3vbjnk0bnfa.cloudfront.net/static/centralauth/images/btn-login.png' );background-position: 65px 5px;text-indent: 15px;  }");
			pw.println(".log_out{text-decoration: none;outline: none;color: black;}");

			
			pw.println("</style>");
			pw.println("<div  class='logout' > <a  class='log_out' href='Logout' >Logout</a></div> ");
			pw.println("<br>");
			pw.println("<br>");pw.println("<br>");pw.println("<br>");
			pw.println("<table  border='1' align='center'>");
			pw.println("<tr>");
			pw.println("<th>Id</th>");
			pw.println("<th '>Nom de livre</th>");
			pw.println("<th >Auteur</th>");
			pw.println("<th>Prix DH</th>");
			pw.println("<th>Qte</th>");

			pw.println("<th>Modifier</th>");
			pw.println("<th>Supprimer</th>");
			pw.println("</tr>");
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");

				pw.println("<td>"+rs.getFloat(4)+"</td>");
				pw.println("<td>"+rs.getInt(5)+"</td>");
				pw.println("<td><a href='editScreen?id="+rs.getInt(1)+"'>Modifier</a></td>");
				pw.println("<td><a href='deleteurl?id="+rs.getInt(1)+"'>Supprimer</a></td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
		}catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1>"+se.getMessage()+"</h2>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h2>");
		}
		pw.println("<br>");
		pw.println("<button class='aj'><a class='aj1'href='Livre.jsp'>Ajouter</a></button>");
		//pw.println("<button class='aj'><a  href='Livre.jsp'>Ajout</a></button>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

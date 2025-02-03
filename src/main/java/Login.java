

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String login=request.getParameter("login");
		String pass=request.getParameter("pwd");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
			 PreparedStatement ps=con.prepareStatement("select username from login where username=? and pasword=?");
			 ps.setString(1,login);
			 ps.setString(2,pass);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()) {
				 session.setAttribute("login", login);
				 response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("auth.jsp");
		}
			rs.close();
			ps.close();
			con.close();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	}



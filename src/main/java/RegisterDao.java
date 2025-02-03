import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
	private String dburl = "jdbc:mysql://localhost:3306/bibliotheque";
	private String dbuname = "root";
	private String dbpassword = "";
	private String dbdriver = "com.mysql.jdbc.Driver";

	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}


	public String insert(Member member) {
		loadDriver(dbdriver);
		Connection con = getConnection();
		String sql = "insert into livres(nom,auteur,prix,qte) values(?,?,?,?)";
		
		String result="<h1 style={background-color:red} >Les donnees ont ete entrees avec succes<h1>";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, member.getUname());
			ps.setString(2, member.getAuteur());
			ps.setString(3, member.getPrix());
			ps.setNString(4, member.getQte());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result="<h1 background-color='red'> Les donnees n'ont pas ete entrees avec succes</h1>";
			e.printStackTrace();
		}
		return result;
		
 
	}
	
	public String delete(int id) {
		String reslt = null;
	try {	loadDriver(dbdriver);
		Connection con = getConnection();
		String query = "delete from livres where id=?";
		//LOAD jdbc driver
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1, id);

			int count = ps.executeUpdate();
			
if(count==1) {
				reslt="<h1>L'enregistrement a été supprimé avec succès</h1>";
				return reslt;
			}else {
				reslt="<h1>L'enregistrement n'a pas été supprimé avec succès</h1>";
				return reslt;
			}
		}catch(Exception cnf) {
			cnf.printStackTrace();
		}
	return reslt;
	
	}
	
	public String editservlet(int id) {
		loadDriver(dbdriver);
		Connection con = getConnection();
	
		String query = "update livres set nom=?,auteur=?,prix=?,qte=? where id=?";
		
			return query;
	}
			
		
		
		
	public ResultSet update(int id) {
		String reslt;ResultSet rs = null;
	try {	loadDriver(dbdriver);
		Connection con = getConnection();
		
		String query = "SELECT nom,auteur,prix,qte FROM livres where id=?";
					PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, id);
				 rs = ps.executeQuery();
				rs.next();

}catch(Exception cnf) {
	cnf.printStackTrace();
}return rs;}
	


public ResultSet selectAll() {
	
	ResultSet rs = null;PreparedStatement ps;
	try {	loadDriver(dbdriver);
	Connection con = getConnection();
	 String query = "SELECT * FROM livres";
		 ps = con.prepareStatement(query);
		 rs = ps.executeQuery();
	}catch(Exception cnf) {
		cnf.printStackTrace();
	}
	return rs;
	
	
}
	

}

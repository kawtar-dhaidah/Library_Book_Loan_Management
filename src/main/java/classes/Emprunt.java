package classes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Emprunt {
	static Connection con;
	String client,CIN,telephone,livre,prix,etat,id;
	String date_emprunt,date_retour;
	
	public Emprunt () {}
	
	public Emprunt(String id,String client, String cIN, String telephone, String livre, String prix,
		String date_emprunt, String date_retour, String etat) {
		super();
		this.id=id;
		this.client = client;
		CIN = cIN;
		this.telephone = telephone;
		this.livre = livre;
		this.prix = prix;
		this.etat = etat;
		this.date_emprunt = date_emprunt;
		this.date_retour = date_retour;
	}
	
	public String getID() {
		return this.id;
	}
	public String getClient() {
		return this.client;
	}
	public String getCIN() {
		return this.CIN;
	}
	
	public String getTelehone() {
		return this.telephone;
	}
	public String getLivre() {
		return this.livre;
	}
	public String getPrix() {
		return this.prix;
	}
	public String getDate_Emprunt() {
		return this.date_emprunt;
	}
	public String getDate_retour() {
		return this.date_retour;
	}
	public String getEtat() {
		return this.etat;
	}
	

	public static ArrayList<Emprunt> getAll() {
		con= connection.getCon();
		String req="SELECT * FROM emprunt ";
		List<Emprunt> Emprunts = new ArrayList<>();
		try {
			
			PreparedStatement ps =con.prepareStatement(req);
			ResultSet res =ps.executeQuery();
			while(res.next()) {
				Emprunt E=new Emprunt(res.getString("id"),res.getString("client"),res.getString("CIN"),res.getString("Telephone"),res.getString("livre"),res.getString("prix"),res.getString("date_emprunt"),res.getString("date_retour"),res.getString("etat"));
				Emprunts.add(E);
				
			}
		} catch (Exception e) {
			System.out.println("problem");
		}
		return (ArrayList<Emprunt>) Emprunts;
		
	}
	
	public static ArrayList<Emprunt> getEmprunt_name(String name) {
		con= connection.getCon();
		String req="SELECT * FROM emprunt where CIN LIKE '%"+name+"%'";
		List<Emprunt> Emprunts = new ArrayList<>();
		try {
			
			PreparedStatement ps =con.prepareStatement(req);
			ResultSet res =ps.executeQuery();
			while(res.next()) {
				Emprunt E=new Emprunt(res.getString("id"),res.getString("client"),res.getString("CIN"),res.getString("Telephone"),res.getString("livre"),res.getString("prix"),res.getString("date_emprunt"),res.getString("date_retour"),res.getString("etat"));
				Emprunts.add(E);
				
			}
		} catch (Exception e) {
			System.out.println("problem");
		}
		return (ArrayList<Emprunt>) Emprunts;
		
	}
	
	public static ArrayList<Emprunt> getEmprunt_date(String date) {
		con= connection.getCon();
		String req="SELECT * FROM emprunt where date_retour LIKE '%"+date+"%'";
		List<Emprunt> Emprunts = new ArrayList<>();
		try {
			
			PreparedStatement ps =con.prepareStatement(req);
			ResultSet res =ps.executeQuery();
			while(res.next()) {
				Emprunt E=new Emprunt(res.getString("id"),res.getString("client"),res.getString("CIN"),res.getString("Telephone"),res.getString("livre"),res.getString("prix"),res.getString("date_emprunt"),res.getString("date_retour"),res.getString("etat"));
				Emprunts.add(E);
				
			}
		} catch (Exception e) {
			System.out.println("problem");
		}
		return (ArrayList<Emprunt>) Emprunts;
		
	}
	
	public static ArrayList<Emprunt> getEmprunt_id(String id) {
		con= connection.getCon();
		String req="SELECT * FROM emprunt where id="+id;
		List<Emprunt> Emprunts = new ArrayList<>();
		try {
			
			PreparedStatement ps =con.prepareStatement(req);
			ResultSet res =ps.executeQuery();
			while(res.next()) {
				Emprunt E=new Emprunt(res.getString("id"),res.getString("client"),res.getString("CIN"),res.getString("Telephone"),res.getString("livre"),res.getString("prix"),res.getString("date_emprunt"),res.getString("date_retour"),res.getString("etat"));
				Emprunts.add(E);
				
			}
		} catch (Exception e) {
			System.out.println("problem");
		}
		return (ArrayList<Emprunt>) Emprunts;
		
	}
	public static void Update_Etat(String id,String etat) {
		con= connection.getCon();
		String req="UPDATE Emprunt SET etat='"+etat+"' WHERE id="+id;
		try {
			
			PreparedStatement ps =con.prepareStatement(req);
			ps.executeUpdate();
			System.out.println("update done ...");
			
		} catch (Exception e) {
			System.out.println("problem");
		}
		
	}
	public static ArrayList<Emprunt> getEmprunt_Retard() {
		con= connection.getCon();
		String req="SELECT * FROM emprunt where etat LIKE 'Retard'";
		List<Emprunt> Emprunts = new ArrayList<>();
		try {
			
			PreparedStatement ps =con.prepareStatement(req);
			ResultSet res =ps.executeQuery();
			while(res.next()) {
				Emprunt E=new Emprunt(res.getString("id"),res.getString("client"),res.getString("CIN"),res.getString("Telephone"),res.getString("livre"),res.getString("prix"),res.getString("date_emprunt"),res.getString("date_retour"),res.getString("etat"));
				Emprunts.add(E);
				
			}
		} catch (Exception e) {
			System.out.println("problem");
		}
		return (ArrayList<Emprunt>) Emprunts;
		
	}

}



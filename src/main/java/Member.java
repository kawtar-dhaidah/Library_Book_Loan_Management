
public class Member {
	private String uname,auteur,prix,qte;

	public Member() {
		super();
	}

	public Member(String uname, String auteur, String prix, String qte) {
		super();
		this.uname = uname;
		this.auteur = auteur;
		this.prix = prix;
		this.qte = qte;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String aut) {
		this.auteur = aut;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String pr) {
		this.prix = pr;
	}

	public String getQte() {
		return qte;
	}

	public void setQte(String qte) {
		this.qte = qte;
	}
	
}

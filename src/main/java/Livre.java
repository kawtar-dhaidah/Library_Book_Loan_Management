
public class Livre {
	 private int id;
	  private String nom;
	  private String auteur;
	  private int quantite;

	  public Livre() {
		    this.id = 0;
		    this.nom = "";
		    this.auteur = "";
		    this.quantite = 0;
		  }
	  
	  public Livre(int id, String nom, String auteur, int quantite) {
	    this.id = id;
	    this.nom = nom;
	    this.auteur = auteur;
	    this.quantite = quantite;
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getNom() {
	    return nom;
	  }

	  public void setNom(String nom) {
	    this.nom = nom;
	  }

	  public String getAuteur() {
	    return auteur;
	  }

	  public void setAuteur(String auteur) {
	    this.auteur = auteur;
	  }

	  public int getQuantite() {
	    return quantite;
	  }

	  public void setQuantite(int quantite) {
	    this.quantite = quantite;
	  }
	

}

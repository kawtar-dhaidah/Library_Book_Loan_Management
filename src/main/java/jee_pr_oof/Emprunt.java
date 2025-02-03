package jee_pr_oof;

import java.sql.Date;

public class Emprunt {
	private int id;
    private String nom;
    private String cin;
    private String tel;
    private String livre;
    private double prix;
    private Date dateEmprunt;
    private Date dateRetour;

    // Getters and setters
    public Emprunt(String nom,String cin,String tel,String livre,double prix,Date String,Date dateEmprunt,Date dateRetour) {
    	this.nom=nom;
    	this.cin=cin;
    	this.tel=tel;
    	this.livre=livre;
    	this.prix=prix;
    	this.dateEmprunt=dateEmprunt;
    	this.dateRetour=dateRetour;
    	
    }
    public Emprunt() {
    	
    }
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLivre() {
        return livre;
    }

    public void setLivre(String livre) {
        this.livre = livre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }
}


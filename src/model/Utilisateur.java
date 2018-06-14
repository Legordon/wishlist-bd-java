package model;

public class Utilisateur {

	private String pseudo;
	private int utilisateurId;
	
	public Utilisateur(String pseudo, int utilisateurId) {
		this.pseudo = pseudo;
		this.utilisateurId = utilisateurId;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	
	
}

package dao;

import model.Utilisateur;

public interface UtilisateurDAO {

	public abstract boolean checkUtilisateur(String pseudo, String mdp);
	
	public abstract Utilisateur connectUtilisateur(String pseudo, String mdp);
	
}

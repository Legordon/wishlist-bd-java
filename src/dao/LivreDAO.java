package dao;

import java.util.ArrayList;

import model.Livre;

public interface LivreDAO {

	public abstract ArrayList<Livre> getLivres();
	
	public abstract boolean createLivre(String titre, int tome, int genre, int idUtilisateur);
	
	public abstract boolean updateLivre(int idLivre, int tome);
	
	public abstract boolean deleteLivre(int idLivre);
	
}

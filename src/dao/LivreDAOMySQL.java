package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import model.Livre;

public class LivreDAOMySQL implements LivreDAO {

	
	
	/*************/
	/* VARIABLES */
	/******************************/
	
	private static Connection connect;
	
	public LivreDAOMySQL() {
		connect = ConnectBDDlivre.getConnection();
	}
	
	
	
	/************/
	/* METHODES */
	/******************************/
		
	
	// Remplissage de la biliothèque
	@Override
	public ArrayList<Livre> getLivres() {
		
		ArrayList<Livre> biblio = new ArrayList<>();
		PreparedStatement ps;
		ResultSet rs;
		
		
		try {
			ps = connect.prepareStatement("SELECT id_bd AS id, str_titre AS titre, int_tome AS tome, str_label_genre AS genre\r\n" + 
					"FROM bd, genre\r\n" + 
					"WHERE bd.id_genre = genre.id_genre\r\n" + 
					"ORDER BY str_label_genre, str_titre");
			rs = ps.executeQuery();
			
			while(rs.next()) {
								
				biblio.add( new Livre( rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4) ));
			}
			
			
			ps.close();
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return biblio;
	}

	
	// Ajouter un livre
	@Override
	public boolean createLivre(String titre, int tome, int genre, int idUtilisateur) {
		
		PreparedStatement ps;
		
		try {
			ps = connect.prepareStatement("INSERT INTO `wishlist`.`bd` (str_titre, int_tome, id_genre, id_utilisateurs) VALUES (?, ?, ?, ?)");
			ps.setString(1, titre);
			ps.setInt(2, tome);
			ps.setInt(3, genre);
			ps.setInt(4, idUtilisateur);
			int result = ps.executeUpdate();
						
			ps.close();
			
			
			// check si la requète a réussie
			if(result > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
	
	// Mettre un livre a jour
	@Override
	public boolean updateLivre(int idLivre, int tome) {
		
		PreparedStatement ps;
		
		try {
			ps = connect.prepareStatement("UPDATE wishlist.bd SET int_tome = ? WHERE id_bd = ?");
			ps.setInt(1, tome);
			ps.setInt(2, idLivre);
			int result = ps.executeUpdate();
			
			ps.close();
			
			
			// check si la requète a réussie
			if (result > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	// Effacer un livre
	@Override
	public boolean deleteLivre(int idLivre) {

		PreparedStatement ps;
		
		try {
			ps = connect.prepareStatement("DELETE FROM wishlist.bd WHERE id_bd = ?");
			ps.setInt(1, idLivre);
			int result = ps.executeUpdate();
			
			ps.close();
			
			// check si la requète a réussie
			if(result > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}

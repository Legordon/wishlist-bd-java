package dao;
import java.sql.*;

import com.mysql.cj.jdbc.CallableStatement;

import model.Utilisateur;
import sun.security.util.Password;

public class UtilisateurDAOMySQL implements UtilisateurDAO {

	/************/
	/* VARIABLE */
	/***************************/
	
	private static Connection connect;
		
	
	// Constructeur avec connection
	public UtilisateurDAOMySQL() {
		connect = ConnectBDDlivre.getConnection();
	}
	
	
	
	/************/
	/* METHODES */
	/**************************/
	
	public boolean checkUtilisateur(String pseudo, String mdp) {
		
		PreparedStatement ps;
		ResultSet rs;
		
		String mdpCrypt = "";
		
		try {
			
			ps = connect.prepareStatement("SELECT str_mdp FROM wishlist.utilisateurs WHERE str_pseudo = ?");
			ps.setString(1, pseudo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(1).equals(mdp)) {
					return true;
				} else {
					return false;
				}
			}
			
			ps.close();
			rs.close();
			
			
		} catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
		
		
			
		return false;
	}

	
	@Override
	public Utilisateur connectUtilisateur(String pseudo, String mdp) {
		
		Utilisateur utilisateur = null;
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			
			ps = connect.prepareStatement("SELECT str_pseudo, id_utilisateurs FROM wishlist.utilisateurs WHERE str_pseudo = ?");
			ps.setString(1, pseudo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				utilisateur = new Utilisateur(rs.getString(1), rs.getInt(2));
			}
			
		} catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
		
		
		return utilisateur;
	}

	
}

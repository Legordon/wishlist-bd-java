package model;

public class Livre {

	private int id;
	private String titre;
	private int tome;
	private String genre;
	
	
	public Livre(int id, String titre, int tome, String genre) {
		this.id = id;
		this.titre = titre;
		this.tome = tome;
		this.genre = genre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}

	
	public int getTome() {
		return tome;
	}


	public void setTome(int tome) {
		this.tome = tome;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
}

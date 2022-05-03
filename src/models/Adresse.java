package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import views.HomeView;

public class Adresse {
	
	private static Statement stmt;
	private int id_adresse;
	private String num;
	private String designation;
	private String ville;
	private int codePostal;
	private String gouvernorat;
	
	public Adresse(int id_adresse, String num, String designation, String ville, int codePostal, String gouvernorat) {
		this.id_adresse = id_adresse;
		this.num = num;
		this.designation = designation;
		this.ville = ville;
		this.codePostal = codePostal;
		this.gouvernorat = gouvernorat;
	}
	
	
	
	public Adresse() {
			
		}



	/************************************************* Add *************************************************/
	
	public boolean addAdresse() throws SQLException {
		String MyRequest = "Insert into adresse values('"+
				this.getId_adresse() + "','" + 
				this.getNum() + "','" + 
				this.getDesignation() + "','" + 
				this.getVille() + "','" + 
				this.getCodePostal() + "','" + 
				this.getGouvernorat() + "')";
		
			if(HomeView.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
	}
	
	
	/************************************************* Update *************************************************/
	
	public boolean updateAdresse() throws SQLException {
		String MyRequest = "update adresse set "+
				" numeroRue_adresse	 ='" + this.getNum() + "' ,"+
				" libelle_adresse ='" + this.getDesignation() + "' ,"+
				" ville_adresse ='" + this.getVille() + "' ,"+
				" postal_adresse ='" + this.getCodePostal() + "' ,"+
				" gouvernorat ='" + this.getGouvernorat() + "'"+
				" where id_adresse ='"+ this.getId_adresse() +"'";
		
			if(HomeView.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
	}

	
	
	
	

	public static Adresse getAdresse(int id_adresse) throws SQLException
	{
		//stmt = MyConnection.getC().createStatement();
		String MyRequest = "select * from adresse where id_adresse='"+ id_adresse +"'";
				
		ResultSet rs = HomeView.myConnection.executeQuery(MyRequest);
		
		if(rs.next()) {
			Adresse ad = new Adresse(rs.getInt(1),rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getInt(5),rs.getString(6));
			return ad;
		}else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Adresse [id_adresse=" + id_adresse + ", num=" + num + ", designation=" + designation + ", ville="
				+ ville + ", codePostal=" + codePostal + ", gouvernorat=" + gouvernorat + "]";
	}
	
	
	
	public void setCodePostalString(String codePostal) {
		this.codePostal = Integer.valueOf(codePostal);
	}
	
	public int getId_adresse() {
		return id_adresse;
	}

	public void setId_adresse(int id_adresse) {
		this.id_adresse = id_adresse;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	
}

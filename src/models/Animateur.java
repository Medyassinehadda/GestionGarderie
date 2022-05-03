package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import views.HomeView;

public class Animateur {
	
	
	private int cinAnim;
	private String nomAnim;
	private String prenomAnim;
	private int telAnim;
	private String pereAnim;
	private Date dateNaisAnim;
	private Adresse adresseAnim;
	private String imageAnim;
	
	public Animateur(int cinAnim, String nomAnim, String prenomAnim, int telAnim, String pereAnim, Date dateNaisAnim,
			Adresse adresseAnim, String imageAnim) {
		this.cinAnim = cinAnim;
		this.nomAnim = nomAnim;
		this.prenomAnim = prenomAnim;
		this.telAnim = telAnim;
		this.pereAnim = pereAnim;
		this.dateNaisAnim = dateNaisAnim;
		this.adresseAnim = adresseAnim;
		this.imageAnim = imageAnim;
	}

	public Animateur() {
	}

	
	
	public static Animateur getAnimateur(int cinAnim) throws SQLException
	{
		
		String MyRequest = "SELECT * FROM animateur WHERE cin_animateur ='"+ cinAnim +"'";
		
		ResultSet rs = HomeView.myConnection.executeQuery(MyRequest);
		
		if(rs.next()) {
			Animateur a = new Animateur(rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getInt(4),
				rs.getString(5),
				rs.getDate(6),
				Adresse.getAdresse(rs.getInt(7)),
				rs.getString(8));
			return a;
		}else {
			return null;
		}
		
	}
	
	
	//Methods:
	
	/************************************************* Add *************************************************/
	
	public boolean add() throws SQLException {
		String MyRequest = "Insert into animateur values('"+
				this.getCinAnim() + "','" + 
				this.getNomAnim() + "','" + 
				this.getPrenomAnim() + "','" + 
				this.getTelAnim() + "','" + 
				this.getPereAnim() + "','" + 
				this.getDateNaisAnim() + "','" + 
				this.getAdresseAnim().getId_adresse() + "','" + 
				this.getImageAnim() + "')";
		
			if(HomeView.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
	}

	/************************************************* Delete *************************************************/
	
	public boolean delete(int _cin) throws SQLException { 
		String MyRequest = "delete from animateur "
				+ " where cin_animateur='"+ _cin +"'";
			if(HomeView.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;	
	}
	
	/************************************************* Update *************************************************/

	public boolean update() throws SQLException {
		String MyRequest = "update animateur set "+
				" nom_animateur ='" + this.getNomAnim() + "' ,"+
				" prenom_animateur ='" + this.getPrenomAnim() + "' ,"+
				" telephone_animateur ='" + this.getTelAnim() + "' ,"+
				" pere_animateur ='" + this.getPereAnim() + "' ,"+
				" date_naissance_animateur ='" + this.getDateNaisAnim() + "' ,"+
				" adresse_animateur ='" + this.getAdresseAnim().getId_adresse() + "' ,"+
				" image_animateur ='" + this.getImageAnim() + "'"+
				" where cin_animateur ='"+ this.getCinAnim() +"'";
		
			if(HomeView.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
	}

	/************************************************* Lister *************************************************/
	
	public ArrayList<Animateur> lister() throws SQLException {
		
		ArrayList<Animateur> listeAnimateurs = new ArrayList<Animateur>();
		String MyRequest = "select * from animateur";
		ResultSet rs = HomeView.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeAnimateurs.add(new Animateur(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getString(5),
					rs.getDate(6),
					Adresse.getAdresse(rs.getInt(7)),
					rs.getString(8)));
		}
		return listeAnimateurs;
	}
	
	

	/////////////////////////////////////////
	public void setCinAnimString(String cinAnim)
	{
		this.cinAnim = Integer.valueOf(cinAnim);
	}
	
	public void setTelAnimString(String telAnim) {
		this.telAnim = Integer.valueOf(telAnim);
	}
	
	/////////////////////////////////////////
	
	public int getCinAnim() {
		return cinAnim;
	}

	public void setCinAnim(int cinAnim) {
		this.cinAnim = cinAnim;
	}

	public String getNomAnim() {
		return nomAnim;
	}

	public void setNomAnim(String nomAnim) {
		this.nomAnim = nomAnim;
	}

	public String getPrenomAnim() {
		return prenomAnim;
	}

	public void setPrenomAnim(String prenomAnim) {
		this.prenomAnim = prenomAnim;
	}

	public int getTelAnim() {
		return telAnim;
	}

	public void setTelAnim(int telAnim) {
		this.telAnim = telAnim;
	}

	public String getPereAnim() {
		return pereAnim;
	}

	public void setPereAnim(String pereAnim) {
		this.pereAnim = pereAnim;
	}

	public Date getDateNaisAnim() {
		return dateNaisAnim;
	}

	public void setDateNaisAnim(Date dateNaisAnim) {
		this.dateNaisAnim = dateNaisAnim;
	}

	public Adresse getAdresseAnim() {
		return adresseAnim;
	}

	public void setAdresseAnim(Adresse adresseAnim) {
		this.adresseAnim = adresseAnim;
	}

	public String getImageAnim() {
		return imageAnim;
	}

	public void setImageAnim(String imageAnim) {
		this.imageAnim = imageAnim;
	}

	@Override
	public String toString() {
		return "Animateur [cinAnim=" + cinAnim + ", nomAnim=" + nomAnim + ", prenomAnim=" + prenomAnim + ", telAnim="
				+ telAnim + ", pereAnim=" + pereAnim + ", dateNaisAnim=" + dateNaisAnim + ", adresseAnim=" + adresseAnim
				+ ", imageAnim=" + imageAnim + "]";
	}
	
}

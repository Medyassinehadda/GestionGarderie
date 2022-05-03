package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import views.HomeView;


public class Eleve{
	
// Les attributs 
	
	private String nom_eleve ;
	private String prenom_elve ;
	private Date dateNaiEleve ;
	private Adresse adresseEleve ;
	private String imageProfile ;
	private int nvscolaire, cinpere;
	private int numtel;
	private String prpereEleve, prgrandEleve, nommereEleve, prmereEleve;
	
	
	public Eleve(String nom_eleve, String prenom_elve, Date dateNaiEleve, Adresse adresseEleve, String imageProfile,
			int nvscolaire, int cinpere, int numtel, String prpereEleve, String prgrandEleve, String nommereEleve,
			String prmereEleve) {
		super();
		this.nom_eleve = nom_eleve;
		this.prenom_elve = prenom_elve;
		this.dateNaiEleve = dateNaiEleve;
		this.adresseEleve = adresseEleve;
		this.imageProfile = imageProfile;
		this.nvscolaire = nvscolaire;
		this.cinpere = cinpere;
		this.numtel = numtel;
		this.prpereEleve = prpereEleve;
		this.prgrandEleve = prgrandEleve;
		this.nommereEleve = nommereEleve;
		this.prmereEleve = prmereEleve;
	}


	public Eleve() {
		super();
	}
	
	//Methods:
	
	public static Eleve getEleve(int cinEleve) throws SQLException
	{
		
		String MyRequest = "SELECT * FROM eleve WHERE cin_eleve_pere ='"+ cinEleve +"'";
		
		ResultSet rs = HomeView.myConnection.executeQuery(MyRequest);
		
		if(rs.next()) {
			Eleve e = new Eleve(rs.getString(2),
					rs.getString(3),
					rs.getDate(9),
					Adresse.getAdresse(rs.getInt(8)),
					rs.getString(12),
					rs.getInt(11),
					rs.getInt(1),
					rs.getInt(10),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7));
			return e;
		}else {
			return null;
		}
		
	}
	
		/************************************************* Add *************************************************/
		
		public boolean add() throws SQLException {
			String MyRequest = "Insert into eleve values('"+
					this.getCinpere() + "','" + 
					this.getNom_eleve() + "','" + 
					this.getPrenom_elve() + "','" + 
					this.getPrpereEleve() + "','" + 
					this.getPrgrandEleve() + "','" + 
					this.getNommereEleve() + "','" + 
					this.getPrmereEleve() + "','" + 
					this.getAdresseEleve().getId_adresse() + "','" + 
					this.getDateNaiEleve() + "','" + 
					this.getNumtel() + "','" + 
					this.getNvscolaire() + "','" + 
					this.getImageProfile() + "')";
			
				if(HomeView.myConnection.executeUpdate(MyRequest)==0)
					return false;
				else
					return true;
		}
	
		
		/************************************************* Delete *************************************************/
		
		public boolean delete(int _cin) throws SQLException {
			String MyRequest = "delete from eleve "
					+ " where cin_eleve_pere='"+ _cin +"'";
				if(HomeView.myConnection.executeUpdate(MyRequest)==0)
					return false;
				else
					return true;	
		}
	
		
		/************************************************* Update *************************************************/

		public boolean update() throws SQLException {
			String MyRequest = "update eleve set "+
					" nom_eleve ='" + this.getNom_eleve() + "' ,"+
					" prenom_eleve ='" + this.getPrenom_elve() + "' ,"+
					" pr_pere_eleve ='" + this.getPrpereEleve() + "' ,"+
					" pr_gr_pere_eleve ='" + this.getPrgrandEleve() + "' ,"+
					" nom_mere_eleve ='" + this.getNommereEleve() + "' ,"+
					" prenom_mere_eleve ='" + this.getPrmereEleve() + "' ,"+
					" adresse_eleve ='" + this.getAdresseEleve().getId_adresse() + "' ,"+
					" date_nai_eleve ='" + this.getDateNaiEleve() + "' ,"+
					" numero_eleve ='" + this.getNumtel() + "' ,"+
					" niveau_scolaire ='" + this.getNvscolaire() + "' ,"+
					" image_eleve ='" + this.getImageProfile() + "'"+
					" where cin_eleve_pere='"+ this.getCinpere() +"'";
					if(HomeView.myConnection.executeUpdate(MyRequest)==0)
						return false;
					else
						return true;
		}

		/************************************************* Lister *************************************************/
		
		public ArrayList<Eleve> lister() throws SQLException {
			
			ArrayList<Eleve> listeEleves = new ArrayList<Eleve>();
			String MyRequest = "select * from eleve";
			ResultSet rs = HomeView.myConnection.executeQuery(MyRequest);
			
			while(rs.next())
			{
				listeEleves.add(new Eleve(rs.getString(2),
						rs.getString(3),
						rs.getDate(9),
						Adresse.getAdresse(rs.getInt(8)),
						rs.getString(12),
						rs.getInt(11),
						rs.getInt(1),
						rs.getInt(10),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
			return listeEleves;
		}
		
		
	/////////////////////////////////////////
		
	public void setCinEleveString(String cinpere)
	{
		this.cinpere = Integer.valueOf(cinpere);
	}
	
	public void setTelEleveString(String numtel) {
		this.numtel = Integer.valueOf(numtel);
	}
	
	public void setNivScolaireString(String nvscolaire) {
		this.nvscolaire = Integer.valueOf(nvscolaire);
	}
	
	/////////////////////////////////////////
	
	/************************* getter and setter *************************/


	public String getNom_eleve() {
		return nom_eleve;
	}


	public void setNom_eleve(String nom_eleve) {
		this.nom_eleve = nom_eleve;
	}


	public String getPrenom_elve() {
		return prenom_elve;
	}


	public void setPrenom_elve(String prenom_elve) {
		this.prenom_elve = prenom_elve;
	}


	public Date getDateNaiEleve() {
		return dateNaiEleve;
	}


	public void setDateNaiEleve(Date dateNaiEleve) {
		this.dateNaiEleve = dateNaiEleve;
	}


	public Adresse getAdresseEleve() {
		return adresseEleve;
	}


	public void setAdresseEleve(Adresse adresseEleve) {
		this.adresseEleve = adresseEleve;
	}


	public String getImageProfile() {
		return imageProfile;
	}


	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
	}


	public int getNvscolaire() {
		return nvscolaire;
	}


	public void setNvscolaire(int nvscolaire) {
		this.nvscolaire = nvscolaire;
	}


	public int getCinpere() {
		return cinpere;
	}


	public void setCinpere(int cinpere) {
		this.cinpere = cinpere;
	}
	

	public int getNumtel() {
		return numtel;
	}


	public void setNumtel(int numtel) {
		this.numtel = numtel;
	}


	public String getPrpereEleve() {
		return prpereEleve;
	}


	public void setPrpereEleve(String prpereEleve) {
		this.prpereEleve = prpereEleve;
	}


	public String getPrgrandEleve() {
		return prgrandEleve;
	}


	public void setPrgrandEleve(String prgrandEleve) {
		this.prgrandEleve = prgrandEleve;
	}


	public String getNommereEleve() {
		return nommereEleve;
	}


	public void setNommereEleve(String nommereEleve) {
		this.nommereEleve = nommereEleve;
	}


	public String getPrmereEleve() {
		return prmereEleve;
	}


	public void setPrmereEleve(String prmereEleve) {
		this.prmereEleve = prmereEleve;
	}


	@Override
	public String toString() {
		return "Eleve [nom_eleve=" + nom_eleve + ", prenom_elve=" + prenom_elve + ", dateNaiEleve=" + dateNaiEleve
				+ ", adresseEleve=" + adresseEleve + ", imageProfile=" + imageProfile + ", nvscolaire=" + nvscolaire
				+ ", cinpere=" + cinpere + ", numtel=" + numtel + ", prpereEleve=" + prpereEleve + ", prgrandEleve="
				+ prgrandEleve + ", nommereEleve=" + nommereEleve + ", prmereEleve=" + prmereEleve + "]";
	}
	
	
	
	
		
	

	
	
	
	


}

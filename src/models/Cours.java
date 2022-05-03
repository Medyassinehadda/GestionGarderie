package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import views.HomeView;

public class Cours {
	
	// Les attributs :
	private int code;
	private String designation;
	private Animateur animateurResponsable;
	
	public Cours()
	{
		
	}

	public Cours(int code, String designation, Animateur animateurResponsable) {
		super();
		this.code = code;
		this.designation = designation;
		this.animateurResponsable = animateurResponsable;
	}
	
	
	
	public static Cours getCours(int code) throws SQLException
	{
		
		String MyRequest = "SELECT * FROM cours WHERE code ='"+ code +"'";
		
		ResultSet rs = HomeView.myConnection.executeQuery(MyRequest);
		
		if(rs.next()) {
			Cours c = new Cours(rs.getInt(1),
					rs.getString(2),
					Animateur.getAnimateur(rs.getInt(3)));
			return c;
		}else {
			return null;
		}
		
	}
	/************************************************* Add *************************************************/
	
	public boolean addCours() throws SQLException {
		String MyRequest = "Insert into cours values('"+
				this.getCode() + "','" + 
				this.getDesignation() + "','" + 
				this.getAnimateurResponsable().getCinAnim() + "')";
		
			if(HomeView.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
	}
	
	/************************************************* Delete *************************************************/
	
	public boolean deleteCours(int _Code) throws SQLException {
		String MyRequest = "delete from cours "
				+ " where code ='"+ _Code +"'";
			if(HomeView.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;	
	}
	
	/************************************************* Update *************************************************/

	public boolean updateCours() throws SQLException {
		String MyRequest = "update cours set "+
				" code ='" + this.getCode() + "' ,"+
				" designation ='" + this.getDesignation() + "'"+
				" where anim_Responsable ='"+ this.getAnimateurResponsable().getCinAnim() +"'";
		
			if(HomeView.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
	}

	/************************************************* Lister *************************************************/
	
	public ArrayList<Cours> listerCours() throws SQLException {
		
		ArrayList<Cours> listeCours = new ArrayList<Cours>();
		String MyRequest = "select * from cours";
		ResultSet rs = HomeView.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeCours.add(new Cours(rs.getInt(1),
					rs.getString(2),
					Animateur.getAnimateur(rs.getInt(3))));
		}
		return listeCours;
	}
	
	

	/////////////////////////////////////////
	
	
	public void setCodeString(String code)
	{
		this.code = Integer.valueOf(code);
	}
	
	
	
	/////////////////////////////////////////
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Animateur getAnimateurResponsable() {
		return animateurResponsable;
	}

	public void setAnimateurResponsable(Animateur animateurResponsable) {
		this.animateurResponsable = animateurResponsable;
	}

	@Override
	public String toString() {
		return "Cours [code=" + code + ", designation=" + designation + ", animateurResponsable=" + animateurResponsable
				+ "]";
	}
	
	
	
	

}

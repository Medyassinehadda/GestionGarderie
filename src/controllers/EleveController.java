package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Eleve;



public class EleveController {
	public boolean addEleve(Eleve e) throws SQLException
	{
		return e.add();
	}
	
	
	public boolean updateEleve(Eleve e) throws SQLException
	{
		return e.update();
	}
	
	
	public boolean deleteEleve(int _cin) throws SQLException
	{
		return new Eleve().delete(_cin);
	}
	
	
	public ArrayList<Eleve> listerEleve() throws SQLException
	{
		return new Eleve().lister();
	}
}

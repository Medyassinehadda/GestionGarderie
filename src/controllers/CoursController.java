package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Cours;

public class CoursController {
	public boolean addCours(Cours e) throws SQLException
	{
		return e.addCours();
	}
	
	
	public boolean updateCours(Cours e) throws SQLException
	{
		return e.updateCours();
	}
	
	
	public boolean deleteCours(int _Code) throws SQLException
	{
		return new Cours().deleteCours(_Code);
	}
	
	
	public ArrayList<Cours> listerCours() throws SQLException
	{
		return new Cours().listerCours();
	}
}

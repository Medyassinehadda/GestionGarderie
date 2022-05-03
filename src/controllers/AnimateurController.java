package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Animateur;

public class AnimateurController {

	public Animateur getAnimateur(int _cin) throws SQLException 
	{
		new Animateur();
		return Animateur.getAnimateur(_cin);
	}
	
	public boolean addAnimateur(Animateur a) throws SQLException
	{
		return a.add();
	}
	
	
	public boolean updateAnimateur(Animateur a) throws SQLException
	{
		return a.update();
	}
	
	
	public boolean deleteAnimateur(int _cin) throws SQLException
	{
		return new Animateur().delete(_cin);
	}
	
	
	public ArrayList<Animateur> listerAnimateur() throws SQLException
	{
		return new Animateur().lister();
	}
	
}

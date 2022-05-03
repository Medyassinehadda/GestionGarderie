package controllers;

import java.sql.SQLException;

import models.Adresse;


public class Adressecontroller {
	
	public boolean addAdresse(Adresse a) throws SQLException
	{
		return a.addAdresse();
	}
	
	public boolean updateAdresse(Adresse a) throws SQLException
	{
		return a.updateAdresse();
	}
}

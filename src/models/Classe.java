package models;

import java.util.Vector;


public class Classe {
	int idC;
	private String nomClasse;
	private Vector<Eleve> listeEleves;
	private Vector<Cours> listeCours;
	
	
	
	 public Classe(int idC, String nomClasse, Vector<Eleve> listeEleves, Vector<Cours> listeCours) {
		super();
		this.idC = idC;
		this.nomClasse = nomClasse;
		this.listeEleves = listeEleves;
		this.listeCours = listeCours; 
	}


	public int getIdC() {
		return idC;
	}


	public void setIdC(int idC) {
		this.idC = idC;
	}


	public String getNomClasse() {
		return nomClasse;
	}


	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}


	public Vector<Eleve> getListeEleves() {
		return listeEleves;
	}


	public void setListeEleves(Vector<Eleve> listeEleves) {
		this.listeEleves = listeEleves;
	}


	public Vector<Cours> getListeCours() {
		return listeCours;
	}


	public void setListeCours(Vector<Cours> listeCours) {
		this.listeCours = listeCours;
	}


	void ajouterListeEleve(Eleve eleve) {
		
		this.listeEleves.add(eleve);

	}


	@Override
	public String toString() {
		return "Classe [idC=" + idC + ", nomClasse=" + nomClasse + ", listeEleves=" + listeEleves + ", listeCours="
				+ listeCours + "]";
	}


}

package models;


public class Personne {

	String nom ;
	String prenom ;
	String dateNaissance ;
	Adresse adresse ;
	String imageProfile ;
	
	public Personne(String nom, String prenom, String dateNaissance, Adresse adresse, String imageProfile) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.imageProfile = imageProfile;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	/////////////////////////////////////////////////////////
	
	//Adresse
	/*
	public int getNumeroRue() {
		return adresse.numeroRue;
	}

	public void setNumeroRue(int numeroRue) {
		this.adresse.numeroRue = numeroRue;
	}

	public String getDesignationRue() {
		return adresse.designationRue;
	}

	public void setDesignationRue(String designationRue) {
		this.adresse.designationRue = designationRue;
	}

	public String getVille() {
		return adresse.ville;
	}

	public void setVille(String ville) {
		this.adresse.ville = ville;
	}

	public int getCodePostale() {
		return adresse.codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.adresse.codePostale = codePostale;
	}

	public String getGouvernorat() {
		return adresse.gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.adresse.gouvernorat = gouvernorat;
	}*/
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/////////////////////////////////////////////////////////
	
	
	public String getImageProfile() {
		return imageProfile;
	}

	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
	}

	@Override
	public String toString() {
		return "Personne \n\tNom : " + nom +
				"\n\tPrenom : " + prenom +
				"\n\tDateNaissance=" + dateNaissance +
				"\n\tAdresse : " + adresse +
				"\n\tLien image Profile : " + imageProfile +
				"\n";
	}

	
}

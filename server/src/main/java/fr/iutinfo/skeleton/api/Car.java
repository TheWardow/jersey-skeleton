package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.CarDto;

public class Car {
	
	final static Logger logger = LoggerFactory.getLogger(Car.class);
    private String userlogin;
    private String marque;
    private String modele;
    private String couleur;
    private int id = 0;
    private String commentaire;
    private String immatriculation;

    public Car(String userLogin, String marque, String modele, String couleur, int id, String commentaire, String immatriculation) {
		this.userlogin = userLogin;
    	this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
		this.id = id;
		this.commentaire = commentaire;
		this.immatriculation = immatriculation;
	}


    public Car() {
    }

    
    public String getImmatriculation() {
		return immatriculation;
	}


	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}


	public String getUserlogin() {
		return userlogin;
	}


	public void setUserlogin(String userlogin) {
		this.userlogin = userlogin;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

    @Override
    public boolean equals(Object arg) {
        if (getClass() != arg.getClass())
            return false;
        Car voiture = (Car) arg;
        return marque.equals(voiture.marque) && modele.equals(voiture.modele) && couleur.equals(voiture.couleur);
    }


    public void initFromDto(CarDto dto) {
        this.setMarque(dto.getMarque());
        this.setModele(dto.getModele());
        this.setId(dto.getId());
        this.setCouleur(dto.getCouleur());
        this.setCommentaire(dto.getCommentaire());
        this.setUserlogin(dto.getUserlogin());
        this.setImmatriculation(dto.getImmatriculation());
    }

    public CarDto convertToDto() {
        CarDto dto = new CarDto();
        dto.setMarque(this.getMarque());
        dto.setModele(this.getModele());
        dto.setId(this.getId());
        dto.setCouleur(this.getCouleur());
        dto.setCommentaire(this.getCommentaire());
        dto.setUserlogin(this.getUserlogin());
        dto.setImmatriculation(this.getImmatriculation());
        return dto;
    }
}

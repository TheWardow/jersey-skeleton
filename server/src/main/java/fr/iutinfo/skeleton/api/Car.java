package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.CarDto;

public class Car {
	
	final static Logger logger = LoggerFactory.getLogger(Car.class);
    private int userId;
    private String marque;
    private String modele;
    private String couleur;
    private int id = 0;
    private String commentaire;

    public Car(int userId, String marque, String modele, String couleur, int id, String commentaire) {
		this.userId = userId;
    	this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
		this.id = id;
		this.commentaire = commentaire;
	}


    public Car() {
    }

    
    public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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
    }

    public CarDto convertToDto() {
        CarDto dto = new CarDto();
        dto.setMarque(dto.getMarque());
        dto.setModele(dto.getModele());
        dto.setId(dto.getId());
        dto.setCouleur(dto.getCouleur());
        dto.setCommentaire(dto.getCommentaire());
        return dto;
    }
}

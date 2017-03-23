package fr.iutinfo.skeleton.api;

import java.time.LocalDateTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.CommandeDto;
import fr.iutinfo.skeleton.common.dto.UserDto;

public class Commande{
    final static Logger logger = LoggerFactory.getLogger(Commande.class);
    private int id;
    private LocalDateTime date;
    private boolean termine;
    private int idcar;
    private int idnettoyeur;
    private int idpicture;
    private int duree; // Minutes
    private boolean accepte;
    
    public Commande(int id, int idCar, int idNettoyeur){
    	this.id = id;
    	this.idcar = idCar;
    	this.idnettoyeur = idNettoyeur;
    }
    
    public Commande(){
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean isTermine() {
		return termine;
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	public int getIdCar() {
		return idcar;
	}

	public void setIdCar(int idCar) {
		this.idcar = idCar;
	}

	public int getIdNettoyeur() {
		return idnettoyeur;
	}

	public void setIdNettoyeur(int idNettoyeur) {
		this.idnettoyeur = idNettoyeur;
	}

	public int getIdPicture() {
		return idpicture;
	}

	public void setIdPicture(int idPicture) {
		this.idpicture = idPicture;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public boolean isAccepte() {
		return accepte;
	}

	public void setAccepte(boolean accepte) {
		this.accepte = accepte;
	}
    
	public void initFromDto(CommandeDto dto) {
        this.setIdNettoyeur(dto.getIdNettoyeur());
        this.setIdCar(dto.getIdCar());
        this.setIdPicture(dto.getIdPicture());
        this.setAccepte(dto.isAccepte());
        this.setTermine(dto.isTermine());
        this.setDate(dto.getDate());
        this.setDuree(dto.getDuree());
    }

    public CommandeDto convertToDto() {
        CommandeDto dto = new CommandeDto();
        dto.setIdNettoyeur(this.getIdNettoyeur());
        dto.setIdCar(this.getIdCar());
        dto.setIdPicture(this.getIdPicture());
        dto.setAccepte(this.isAccepte()); 
        dto.setTermine(this.isTermine());
        dto.setDate(this.getDate());
        dto.setDuree(this.getDuree());
        return dto;
    }
}

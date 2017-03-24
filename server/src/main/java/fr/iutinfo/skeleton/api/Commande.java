package fr.iutinfo.skeleton.api;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.CommandeDto;

public class Commande{
    final static Logger logger = LoggerFactory.getLogger(Commande.class);
    private int id;
    private LocalDateTime date;
    private boolean termine;
    private int idcar;
    private String logincleaner;
    private int duree; // Minutes
    private boolean accepte;
    
    public Commande(int id, int idCar, String loginCleaner){
    	this.id = id;
    	this.idcar = idCar;
    	this.logincleaner = loginCleaner;
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


	public int getIdcar() {
		return idcar;
	}

	public String getLogincleaner() {
		return logincleaner;
	}

	public void setIdcar(int idcar) {
		this.idcar = idcar;
	}

	public void setLogincleaner(String logincleaner) {
		this.logincleaner = logincleaner;
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
        this.setLogincleaner(dto.getLoginCleaner());
        this.setIdCar(dto.getIdCar());
        this.setAccepte(dto.isAccepte());
        this.setTermine(dto.isTermine());
        this.setDate(dto.getDate());
        this.setDuree(dto.getDuree());
    }

    public CommandeDto convertToDto() {
        CommandeDto dto = new CommandeDto();
        dto.setLoginCleaner(this.getLogincleaner());
        dto.setIdCar(this.getIdCar());
        dto.setAccepte(this.isAccepte()); 
        dto.setTermine(this.isTermine());
        dto.setDate(this.getDate());
        dto.setDuree(this.getDuree());
        return dto;
    }
}

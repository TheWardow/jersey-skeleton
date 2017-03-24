package fr.iutinfo.skeleton.common.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandeDto{
	
    final static Logger logger = LoggerFactory.getLogger(CommandeDto.class);
    private LocalDateTime date;
    private boolean termine;
    private int idCar;
    private String loginCleaner;
    private int id;
    private int duree; // Minutes
    private boolean accepte;
    
    
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
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	
	public String getLoginCleaner() {
		return loginCleaner;
	}
	public void setLoginCleaner(String loginCleaner) {
		this.loginCleaner = loginCleaner;
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
     
}
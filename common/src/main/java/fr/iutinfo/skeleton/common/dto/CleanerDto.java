package fr.iutinfo.skeleton.common.dto;

import java.security.Principal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CleanerDto implements Principal {
	
    final static Logger logger = LoggerFactory.getLogger(CleanerDto.class);    
    
    private int id = 0;
    private String nom;
    private String prenom;
    private String tel;
    private Date dob;
    private String email;
    private String login;
    private String password;
    private String localisation;
    private Double note;
    
    
	


	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getTel() {
		return tel;
	}

	public Date getDob() {
		return dob;
	}
	
	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getLocalisation() {
		return localisation;
	}

	public Double getNote() {
		return note;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return login;
	}

}

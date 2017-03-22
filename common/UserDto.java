package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.Date;

public class UserDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(UserDto.class);
    private String login;
    private String nom;
    private String prenom;
    private int id = 0;
    private String email;
    private String tel;
    private Date dob;
    private String password;

    public String getLogin(){
    	return this.login;
    }
    
    public void setLogin(String login){
    	this.login = login;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}

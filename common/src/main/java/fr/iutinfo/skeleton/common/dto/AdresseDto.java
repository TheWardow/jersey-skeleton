package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdresseDto {

	final static Logger logger = LoggerFactory.getLogger(AdresseDto.class);
	private int adresseId = 0;
	private String numero;
	private String voie;
	private String ville;
	private int cp;
	private String userlogin;
	
	public int getAdresseId() {
		return adresseId;
	}
	public void setAdresseId(int adresseId) {
		this.adresseId = adresseId;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	public String getUserlogin() {
		return userlogin;
	}
	public void setUserlogin(String login) {
		this.userlogin = login;
	}
}

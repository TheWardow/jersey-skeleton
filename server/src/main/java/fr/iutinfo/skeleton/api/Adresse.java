package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.AdresseDto;
import fr.iutinfo.skeleton.common.dto.CarDto;

public class Adresse {
	
	final static Logger logger = LoggerFactory.getLogger(Adresse.class);
    private int adresseId = 0;
    private String numero;
    private String voie;
    private String ville;
    private int cp;
    private String userlogin;

    public Adresse(String numero, String voie, String ville, int cp, String login) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
		this.userlogin = login;
	}

	public Adresse() {
    }

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

	public void setUserlogin(String userLogin) {
		this.userlogin = userLogin;
	}

	public void initFromDto(AdresseDto dto) {
        this.setAdresseId(dto.getAdresseId());
        this.setNumero(dto.getNumero());
        this.setVoie(dto.getVoie());
        this.setVille(dto.getVille());
        this.setCp(dto.getCp());
        this.setUserlogin(dto.getUserlogin());
    }

    public AdresseDto convertToDto() {
    	AdresseDto dto = new AdresseDto();
    	dto.setAdresseId(this.getAdresseId());
    	dto.setNumero(this.getNumero());
    	dto.setVoie(this.getVoie());
    	dto.setVille(this.getVille());
        dto.setCp(this.getCp());
        dto.setUserlogin(this.getUserlogin());
        return dto;
    }
}

package fr.iutinfo.skeleton.api;

import java.security.SecureRandom;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import fr.iutinfo.skeleton.common.dto.ProductDto;
import fr.iutinfo.skeleton.common.dto.UserDto;

public class Product{
    final static Logger logger = LoggerFactory.getLogger(Product.class);
    
    private int id;
    private String type;
    private String modele;
    private String cleanerLogin;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public String getCleanerLogin() {
		return cleanerLogin;
	}

	public void setCleanerLogin(String cleanerLogin) {
		this.cleanerLogin = cleanerLogin;
	}

	public void initFromDto(ProductDto dto) {
        this.setCleanerLogin(dto.getCleanerLogin());
        this.setModele(dto.getModele());
        this.setType(dto.getType());
        this.setId(dto.getId());
    }

    public ProductDto convertToDto() {
        ProductDto dto = new ProductDto();
        dto.setCleanerLogin(this.getCleanerLogin());
        dto.setModele(this.getModele());
        dto.setType(this.getType());
        dto.setId(this.getId());
        return dto;
    }

}

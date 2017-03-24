package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.ProductDto;

public class Product{
    final static Logger logger = LoggerFactory.getLogger(Product.class);
    
    private int id;
    private String type;
    private String marque;
    private String cleanerLogin;
    
    public Product(String type, String modele, String cleanerLogin) {
		this.type = type;
		this.marque = modele;
		this.cleanerLogin = cleanerLogin;
	}
    
    public Product(){
    	
    }

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

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public String getCleanerLogin() {
		return cleanerLogin;
	}

	public void setCleanerLogin(String cleanerLogin) {
		this.cleanerLogin = cleanerLogin;
	}

	public void initFromDto(ProductDto dto) {
        this.setCleanerLogin(dto.getCleanerLogin());
        this.setMarque(dto.getMarque());
        this.setType(dto.getType());
        this.setId(dto.getId());
    }

    public ProductDto convertToDto() {
        ProductDto dto = new ProductDto();
        dto.setCleanerLogin(this.getCleanerLogin());
        dto.setMarque(this.getMarque());
        dto.setType(this.getType());
        dto.setId(this.getId());
        return dto;
    }

}

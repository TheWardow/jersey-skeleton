package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.ProductDto;

public class Product{
    final static Logger logger = LoggerFactory.getLogger(Product.class);
    
    private int id;
    private String type;
    private String marque;
    private String cleanerlogin;
    private int quantite;
    
    public Product(String type, String modele, int quantite, String cleanerlogin) {
		this.type = type;
		this.marque = modele;
		this.quantite = quantite;
		this.cleanerlogin = cleanerlogin;
	}
    
    public Product(){
    	
    }
    
    public String getCleanerlogin() {
		return cleanerlogin;
	}
	public void setCleanerlogin(String cleanerLogin) {
		this.cleanerlogin = cleanerLogin;
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
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void initFromDto(ProductDto dto) {
        this.setQuantite(dto.getQuantite());
        this.setMarque(dto.getMarque());
        this.setType(dto.getType());
        this.setId(dto.getId());
        this.setCleanerlogin(dto.getCleanerlogin());
    }

    public ProductDto convertToDto() {
        ProductDto dto = new ProductDto();
        dto.setQuantite(this.getQuantite());
        dto.setMarque(this.getMarque());
        dto.setType(this.getType());
        dto.setId(this.getId());
        dto.setCleanerlogin(this.getCleanerlogin());
        return dto;
    }

}

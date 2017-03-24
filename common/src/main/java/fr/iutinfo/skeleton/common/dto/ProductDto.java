package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDto{
	
    final static Logger logger = LoggerFactory.getLogger(ProductDto.class);
    private int id;
    private String marque;
    private String type;
    private String cleanerLogin;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCleanerLogin() {
		return cleanerLogin;
	}
	public void setCleanerLogin(String cleanerLogin) {
		this.cleanerLogin = cleanerLogin;
	}
    
    
}

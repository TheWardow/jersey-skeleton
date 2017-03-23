package fr.iutinfo.skeleton.common.dto;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PictureDto {
	
    final static Logger logger = LoggerFactory.getLogger(UserDto.class);
    private int id = 0;
    private LocalDateTime date;
    private int nettoye;
    private String path;
    private int commandeid;
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
	public int getNettoye() {
		return nettoye;
	}
	public void setNettoye(int nettoye) {
		this.nettoye = nettoye;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getCommandeid() {
		return commandeid;
	}
	public void setCommandeid(int commandeid) {
		this.commandeid = commandeid;
	}
    
    
}

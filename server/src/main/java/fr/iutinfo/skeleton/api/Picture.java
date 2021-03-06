package fr.iutinfo.skeleton.api;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.PictureDto;

public class Picture {
    final static Logger logger = LoggerFactory.getLogger(Picture.class);
    private int id = 0;
    private LocalDateTime date;
    private int nettoye;
    private String path;
    private int commandeid;

    public Picture(int id) {
        this.id = id;
    }
    
    public Picture(int commandeId, String path,int nettoye, LocalDateTime date) {
        this.commandeid = commandeId;
        this.path = path;
        this.nettoye = nettoye;
        this.date = date;
    }

    public Picture() {
    }

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

	public void initFromDto(PictureDto dto) {
        this.setDate(LocalDateTime.now());
        this.setNettoye(dto.getNettoye());
        this.setPath(dto.getPath());
        this.setCommandeid(dto.getCommandeid());
    }

    public PictureDto convertToDto() {
    	PictureDto dto = new PictureDto();
        dto.setDate(LocalDateTime.now());
        dto.setNettoye(this.getNettoye());
        dto.setPath(dto.getPath());
        dto.setCommandeid(this.getCommandeid());
        return dto;
    }
}

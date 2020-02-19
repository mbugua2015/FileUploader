package com.fileuploader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UploadedFile implements Serializable {
	
	public UploadedFile(){ }
	
	public UploadedFile(String filename){
		this.filename=filename;
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	private String filename;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePlaced;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public Date getDatePlaced() {
		return datePlaced;
	}
	
	public void setDatePlaced(Date datePlaced) {
		this.datePlaced = datePlaced;
	}
}

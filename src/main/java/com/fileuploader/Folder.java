package com.fileuploader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Folder {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String folderId;
	
	public Folder(){}
	
	public Folder(String name, String folderId){
		this.name=name;
		this.folderId=folderId;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFolderId() {
		return folderId;
	}
	
	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}
}

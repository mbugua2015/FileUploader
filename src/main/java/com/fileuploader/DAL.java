package com.fileuploader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DAL {
	
	static EntityManagerFactory entityManagerFactory=null;
	
	private static EntityManagerFactory getEntityManagerFactory(){
		if(entityManagerFactory!=null) return entityManagerFactory;
		
		entityManagerFactory= Persistence.
				createEntityManagerFactory(Utility.getResources().getUploaderDbPath());
		
		return entityManagerFactory;
	}
	
	public static void addFile(String file){
		EntityManager entityManager= getEntityManagerFactory().createEntityManager();
		try{
			entityManager.getTransaction().begin();
			UploadedFile uploadedFile= new UploadedFile(file);
			entityManager.persist(uploadedFile);
			entityManager.getTransaction().commit();
		}
		finally {
			entityManager.close();
		}
	}
	
	public static boolean fileExists(String file){
		EntityManager entityManager= getEntityManagerFactory().createEntityManager();
		try{
			Query q= entityManager.createQuery(
					"Select f from UploadedFile f where f.filename= :filename", UploadedFile.class);
			q.setParameter("filename",file);
			List<UploadedFile> files= q.getResultList();
			return !files.isEmpty();
		}
		finally {
			entityManager.close();
		}
		
	}
	
	public static void removeFile(String filename){
		EntityManager entityManager= getEntityManagerFactory().createEntityManager();
		
		try{
			entityManager.getTransaction().begin();
			Query query= entityManager.createQuery("Delete f from UploadedFile where f.filename= :file");
			query.setParameter("file", filename);
			query.executeUpdate();
			entityManager.getTransaction().commit();
		}
		finally {
			entityManager.close();
		}
		
		
	}
	
	public static void disposeEntityManagerfactory(){
		if(entityManagerFactory!=null)
			entityManagerFactory.close();
	}
	
}

package com.fileuploader;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;

public class FileUploaderJob implements Job {
	
	private static final Object uploadsLock= new Object();
	static boolean fileInSubFolder=false;
	
	public static void uploadFiles(){
		
		synchronized (uploadsLock){
			//Need functionality to create dirs on azure storage to avoid scattering of
			//related files
			//FileUploader.uploadFilesToAzure();
			
			EfisalesResource resources= Utility.getResources();
			
			String[] files= FileUploader.
					getFilesInDirectory(resources.getDatabaseBackupsPath());
			
			Utility.log("Unuploaded files found "+ files.length,Level.INFO);
			
			for(String fileName: files){
				
				try{
					if(Files.isDirectory(
							Paths.get(resources.getDatabaseBackupsPath()+fileName),
							LinkOption.NOFOLLOW_LINKS)){
						
						String folderId=null;
						
						String[] filesInDirectory=FileUploader.
								getFilesInDirectory(resources.getDatabaseBackupsPath()+fileName);
						
						if(filesInDirectory!=null && filesInDirectory.length>0){
							
							String currentDate= Formatter.formatDateToDayMonthYearWithHyphens(new Date());
							
							String dirName= fileName+"_"+ currentDate;
							
							Folder folder= DAL.getFolder(dirName);
							
							com.google.api.services.drive.model.File gDriveDirectory=null;
							
							if(folder==null){
								gDriveDirectory=
										GoogleDriveWorker.createGoogleDriveFolder(
												GoogleDriveWorker.BASE_BACKUPS_FOLDERID,dirName);
								
								if(gDriveDirectory==null){
									Utility.log("Could not create google drive directory -> "+dirName ,Level.INFO);
									continue;
								}
								
								folderId=gDriveDirectory.getId();
								
								DAL.addFolder(dirName,folderId);
							}
							else{
								folderId=folder.getFolderId();
							}
							
							for(String file: filesInDirectory){
								fileInSubFolder=true;
								String fileSeparator= resources.getRuntime().equals("linux")?"/":"\\";
								uploadFileToGoogleDrive(folderId,resources.getDatabaseBackupsPath()+ fileName+ fileSeparator+ file);
							}
						}
						
					}
					else {
						String filepath=resources.getDatabaseBackupsPath()+fileName;
						fileInSubFolder=false;
						uploadFileToGoogleDrive(GoogleDriveWorker.BASE_BACKUPS_FOLDERID,filepath);
					}
				
				}
				catch (Exception ex){
					Utility.logStackTrace(ex);
				}
				
			}
		}
	}
	
	public static void uploadFileToGoogleDrive(String parentDirectory,String filePath){
		
		try{
			EfisalesResource resources= Utility.getResources();
			
			String fileName=resources.getRuntime().equals("linux")?
					filePath.substring(filePath.lastIndexOf("/")+1):
					filePath.substring(filePath.lastIndexOf("\\")+1);
			
			if(fileName.toLowerCase().contains("incomplete")){
				Utility.log("The database backup: "+ fileName+", seems to be in progress, exiting",Level.INFO);
				return;
			}
			
			if(fileName.toLowerCase().contains("encryption")){
				Utility.log("Ignoring encryption key, exiting",Level.INFO);
				return;
			}
			
			File file= new File(filePath);
			
			boolean uploaded=false;
			
			if(!DAL.fileExists(fileName)){
				
				Utility.log("Uploading "+ fileName+ " to gdrive",Level.INFO);
				
				//Using folder id instead of the actual folder name
				
				com.google.api.services.drive.model.File uploadedFile=
						GoogleDriveWorker.createFileFromJavaIOFile(parentDirectory,
								Files.probeContentType(file.toPath()),fileName,file);
				
				uploaded=uploadedFile!=null;
				Utility.log("Successfully uploaded "+ fileName+" to gdrive", Level.INFO);
			}
			
			if(uploaded){
				boolean deleted=false;//FileUploader.deleteFile(filePath);
				
				if(!deleted){
					Utility.log("Could not delete the file: "+ fileName,Level.INFO);
				}
				
				if(uploaded){
					DAL.addFile(fileName);
				}
				
			}
		}
		catch (Exception ex){
			Utility.logStackTrace(ex);
		}
	}
	
	@Override
	public void execute(JobExecutionContext jobExecutionContext)
			throws JobExecutionException {
		uploadFiles();
	}

}

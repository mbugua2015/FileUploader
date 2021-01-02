package com.fileuploader;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class UploadFilesToGoogleStorage implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try{
            FileUploader.uploadFilesToGoogleCloudStorage();
        }
        catch (Exception ex){
            Utility.logStackTrace(ex);
        }

    }
}

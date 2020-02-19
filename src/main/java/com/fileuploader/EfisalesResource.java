
package com.fileuploader;

/**
 *
 * @author Mbugua
 */
public class EfisalesResource {
    String DbHost;
    String DbPort;
    String DbName;
    String DbPassword;
    String DbUsername;
    String UploadsPath;
    String TempDir;
    String SmtpServer;
    String SmtpUsername;
    String SmtpPassword;
    String SmtpFrom;
    String SmtpPort;
    String SiteVersion;
    String RedisClusterUrl;
    String CoreSiteBaseUrl;
    String ReportingMicroserviceUrl;
    String BlobStorageContainer;
    String AzureStorageUrl;
    String InstantUploadsPath;
    String RmqHost;
    String RmqPort;
    String RmqUsername;
    String RmqPassword;
    String RmqVHost;
    String EmailsMessageQueue;
    String OrdersPrintMessageQueue;
    String ClientsCacheMessageQueue;
    String ClientsSyncMessageQueue;
    String UploadsMessageQueue;
    String UserStatusQueue;
    String DeleteUploadsQueue;
    String ExpiredRedisKeysQueue;
    String DatabaseBackupContainer;
    String DatabaseBackupsPath;
    String DbBackupsStorageUrl;
    String RedisHost;
    String RedisPassword;
    String AppVersion;
    String AsyncExecutor;
    String Runtime;
    String ClientsUploadsPath;
    String ReportingDbServerClusterHost;
    String ReportingDbServerClusterUsername;
    String ReportingDbServerClusterDbName;
    String ReportingDbServerClusterDbPort;
    String ReportingDbServerCluterPassword;
    String MessageBusBuffer;
    String MongoDbInstances;
    String LogsQueue;
    String SalesRepAppointmentsQueue;
    String AppEnvironment;
    String InfluxDbUri;
    String KafkaUrl;
    String StagingDefaultMac,JdbcDatasource,ApplicationId;
    String UploaderDbPath;
    boolean SmtpSecure,DeleteFilesOnUpload,ExecuteBackgroundJobs,
            UpdateUserTrackingStatus, AuthenticateRedisConnections,
            ArchiveSurveyResults,DeleteOldDbBackups;
    Integer WebJobInterval,UserTrackingStatusInterval,RedisPort;
    

    public String getStagingDefaultMac() {
        return StagingDefaultMac;
    }

    public void setStagingDefaultMac(String stagingDefaultMac) {
        StagingDefaultMac = stagingDefaultMac;
    }

    public String getAppEnvironment() {
        return AppEnvironment;
    }

    public void setAppEnvironment(String appEnvironment) {
        AppEnvironment = appEnvironment;
    }

    public String getDbHost() {
        return DbHost;
    }

    public void setDbHost(String DbHost) {
        this.DbHost = DbHost;
    }

    public String getDbPort() {
        return DbPort;
    }

    public void setDbPort(String DbPort) {
        this.DbPort = DbPort;
    }

    public String getDbName() {
        return DbName;
    }

    public void setDbName(String DbName) {
        this.DbName = DbName;
    }

    public String getDbPassword() {
        return DbPassword;
    }

    public void setDbPassword(String DbPassword) {
        this.DbPassword = DbPassword;
    }

    public String getDbUsername() {
        return DbUsername;
    }

    public void setDbUsername(String DbUsername) {
        this.DbUsername = DbUsername;
    }

    public String getUploadsPath() {
        return UploadsPath;
    }

    public void setUploadsPath(String UploadsPath) {
        this.UploadsPath = UploadsPath;
    }

    public String getTempDir() {
        return TempDir;
    }

    public void setTempDir(String TempDir) {
        this.TempDir = TempDir;
    }   

    public String getSmtpServer() {
        return SmtpServer;
    }

    public void setSmtpServer(String SmtpServer) {
        this.SmtpServer = SmtpServer;
    }

    public String getSmtpUsername() {
        return SmtpUsername;
    }

    public void setSmtpUsername(String SmtpUsername) {
        this.SmtpUsername = SmtpUsername;
    }

    public String getSmtpPassword() {        
        return SmtpPassword;
    }

    public void setSmtpPassword(String SmtpPassword) {
        try{      
            this.SmtpPassword = Encryptor.Decrypt(SmtpPassword);            
        }
        catch(Exception ex){
            Utility.logStackTrace(ex);
        }    
    }

    public boolean isSmtpSecure() {
        return SmtpSecure;
    }

    public void setSmtpSecure(boolean SmtpSecure) {
        this.SmtpSecure = SmtpSecure;
    }   

    public String getSmtpFrom() {
        return SmtpFrom;
    }

    public void setSmtpFrom(String SmtpFrom) {
        this.SmtpFrom = SmtpFrom;
    }  

    public String getSmtpPort() {
        return SmtpPort;
    }

    public void setSmtpPort(String SmtpPort) {
        this.SmtpPort = SmtpPort;
    }

    public String getSiteVersion() {
        return SiteVersion;
    }

    public void setSiteVersion(String SiteVersion) {
        this.SiteVersion = SiteVersion;
    }   

    public Integer getWebJobInterval() {
        return WebJobInterval;
    }

    public void setWebJobInterval(Integer WebJobInterval) {
        this.WebJobInterval = WebJobInterval;
    }  

    public String getRedisClusterUrl() {
        return RedisClusterUrl;
    }

    public void setRedisClusterUrl(String RedisClusterUrl) {
        this.RedisClusterUrl = RedisClusterUrl;
    }

    public String getCoreSiteBaseUrl() {
        return CoreSiteBaseUrl;
    }

    public void setCoreSiteBaseUrl(String CoreSiteBaseUrl) {
        this.CoreSiteBaseUrl = CoreSiteBaseUrl;
    }

    public Integer getUserTrackingStatusInterval() {
        return UserTrackingStatusInterval;
    }

    public void setUserTrackingStatusInterval(Integer UserTrackingStatusInterval) {
        this.UserTrackingStatusInterval = UserTrackingStatusInterval;
    }    

    public String getReportingMicroserviceUrl() {
        return ReportingMicroserviceUrl;
    }

    public void setReportingMicroserviceUrl(String ReportingMicroserviceUrl) {
        this.ReportingMicroserviceUrl = ReportingMicroserviceUrl;
    }  

    public String getBlobStorageContainer() {
        return BlobStorageContainer;
    }

    public void setBlobStorageContainer(String BlobStorageContainer) {
        this.BlobStorageContainer = BlobStorageContainer;
    }    

    public String getAzureStorageUrl() {
        return AzureStorageUrl;
    }

    public void setAzureStorageUrl(String AzureStorageUrl) {
        this.AzureStorageUrl = AzureStorageUrl;
    }

    public String getInstantUploadsPath() {
        return InstantUploadsPath;
    }

    public void setInstantUploadsPath(String InstantUploadsPath) {
        this.InstantUploadsPath = InstantUploadsPath;
    }   

    public boolean isDeleteFilesOnUpload() {
        return DeleteFilesOnUpload;
    }

    public void setDeleteFilesOnUpload(boolean DeleteFilesOnUpload) {
        this.DeleteFilesOnUpload = DeleteFilesOnUpload;
    }    

    public boolean isExecuteBackgroundJobs() {
        return ExecuteBackgroundJobs;
    }

    public void setExecuteBackgroundJobs(boolean ExecuteBackgroundJobs) {
        this.ExecuteBackgroundJobs = ExecuteBackgroundJobs;
    } 

    public String getRmqHost() {
        return RmqHost;
    }

    public void setRmqHost(String RmqHost) {
        this.RmqHost = RmqHost;
    }

    public String getRmqPort() {
        return RmqPort;
    }

    public void setRmqPort(String RmqPort) {
        this.RmqPort = RmqPort;
    }

    public String getRmqUsername() {
        return RmqUsername;
    }

    public void setRmqUsername(String RmqUsername) {
        this.RmqUsername = RmqUsername;
    }

    public String getRmqPassword() {
        return RmqPassword;
    }

    public void setRmqPassword(String RmqPassword) {
        this.RmqPassword = RmqPassword;
    }

    public String getRmqVHost() {
        return RmqVHost;
    }

    public void setRmqVHost(String RmqVHost) {
        this.RmqVHost = RmqVHost;
    }   

    public String getEmailsMessageQueue() {
        return EmailsMessageQueue;
    }

    public void setEmailsMessageQueue(String EmailsMessageQueue) {
        this.EmailsMessageQueue = EmailsMessageQueue;
    }

    public String getOrdersPrintMessageQueue() {
        return OrdersPrintMessageQueue;
    }

    public void setOrdersPrintMessageQueue(String OrdersPrintMessageQueue) {
        this.OrdersPrintMessageQueue = OrdersPrintMessageQueue;
    }

    public String getClientsCacheMessageQueue() {
        return ClientsCacheMessageQueue;
    }

    public void setClientsCacheMessageQueue(String ClientsCacheMessageQueue) {
        this.ClientsCacheMessageQueue = ClientsCacheMessageQueue;
    }

    public String getClientsSyncMessageQueue() {
        return ClientsSyncMessageQueue;
    }

    public void setClientsSyncMessageQueue(String ClientsSyncMessageQueue) {
        this.ClientsSyncMessageQueue = ClientsSyncMessageQueue;
    }

    public String getUploadsMessageQueue() {
        return UploadsMessageQueue;
    }

    public void setUploadsMessageQueue(String UploadsMessageQueue) {
        this.UploadsMessageQueue = UploadsMessageQueue;
    }

    public String getUserStatusQueue() {
        return UserStatusQueue;
    }

    public void setUserStatusQueue(String UserStatusQueue) {
        this.UserStatusQueue = UserStatusQueue;
    }

    public String getDeleteUploadsQueue() {
        return DeleteUploadsQueue;
    }

    public void setDeleteUploadsQueue(String DeleteUploadsQueue) {
        this.DeleteUploadsQueue = DeleteUploadsQueue;
    }

    public boolean isUpdateUserTrackingStatus() {
        return UpdateUserTrackingStatus;
    }

    public void setUpdateUserTrackingStatus(boolean UpdateUserTrackingStatus) {
        this.UpdateUserTrackingStatus = UpdateUserTrackingStatus;
    }

    public String getDatabaseBackupContainer() {
        return DatabaseBackupContainer;
    }

    public void setDatabaseBackupContainer(String DatabaseBackupContainer) {
        this.DatabaseBackupContainer = DatabaseBackupContainer;
    }   

    public String getDatabaseBackupsPath() {
        return DatabaseBackupsPath;
    }

    public void setDatabaseBackupsPath(String DatabaseBackupsPath) {
        this.DatabaseBackupsPath = DatabaseBackupsPath;
    }   

    public String getDbBackupsStorageUrl() {
        return DbBackupsStorageUrl;
    }

    public void setDbBackupsStorageUrl(String DbBackupsStorageUrl) {
        this.DbBackupsStorageUrl = DbBackupsStorageUrl;
    }

    public String getRedisHost() {
        return RedisHost;
    }

    public void setRedisHost(String RedisHost) {
        this.RedisHost = RedisHost;
    }

    public String getRedisPassword() {
        return RedisPassword;
    }

    public void setRedisPassword(String RedisPassword) {
        this.RedisPassword = RedisPassword;
    }

    public Integer getRedisPort() {
        return RedisPort;
    }

    public void setRedisPort(Integer RedisPort) {
        this.RedisPort = RedisPort;
    }

    public boolean isAuthenticateRedisConnections() {
        return AuthenticateRedisConnections;
    }

    public void setAuthenticateRedisConnections(boolean AuthenticateRedisConnections) {
        this.AuthenticateRedisConnections = AuthenticateRedisConnections;
    }   

    public String getAppVersion() {
        return AppVersion;
    }

    public void setAppVersion(String AppVersion) {
        this.AppVersion = AppVersion;
    }

    public String getAsyncExecutor() {
        return AsyncExecutor;
    }

    public void setAsyncExecutor(String AsyncExecutor) {
        this.AsyncExecutor = AsyncExecutor;
    }  

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String Runtime) {
        this.Runtime = Runtime;
    }    

    public String getExpiredRedisKeysQueue() {
        return ExpiredRedisKeysQueue;
    }

    public void setExpiredRedisKeysQueue(String ExpiredRedisKeysQueue) {
        this.ExpiredRedisKeysQueue = ExpiredRedisKeysQueue;
    }

    public String getClientsUploadsPath() {
        return ClientsUploadsPath;
    }

    public void setClientsUploadsPath(String ClientsUploadsPath) {
        this.ClientsUploadsPath = ClientsUploadsPath;
    }    

    public String getReportingDbServerClusterHost() {
        return ReportingDbServerClusterHost;
    }

    public void setReportingDbServerClusterHost(String ReportingDbServerClusterHost) {
        this.ReportingDbServerClusterHost = ReportingDbServerClusterHost;
    }

    public String getReportingDbServerClusterUsername() {
        return ReportingDbServerClusterUsername;
    }

    public void setReportingDbServerClusterUsername(String ReportingDbServerClusterUsername) {
        this.ReportingDbServerClusterUsername = ReportingDbServerClusterUsername;
    }

    public String getReportingDbServerClusterDbName() {
        return ReportingDbServerClusterDbName;
    }

    public void setReportingDbServerClusterDbName(String ReportingDbServerClusterDbName) {
        this.ReportingDbServerClusterDbName = ReportingDbServerClusterDbName;
    }

    public String getReportingDbServerClusterDbPort() {
        return ReportingDbServerClusterDbPort;
    }

    public void setReportingDbServerClusterDbPort(String ReportingDbServerClusterDbPort) {
        this.ReportingDbServerClusterDbPort = ReportingDbServerClusterDbPort;
    }

    public String getMessageBusBuffer() {
        return MessageBusBuffer;
    }

    public void setMessageBusBuffer(String MessageBusBuffer) {
        this.MessageBusBuffer = MessageBusBuffer;
    }    
    

    public String getReportingDbServerCluterPassword() {
        try {
            return Encryptor.Decrypt(ReportingDbServerCluterPassword);
        } catch (Exception ex) {
            Utility.logStackTrace(ex);
            return null;
        }
    }

    public String getMongoDbInstances() {
        return MongoDbInstances;
    }

    public void setMongoDbInstances(String MongoDbInstances) {
        this.MongoDbInstances = MongoDbInstances;
    }   
    

    public void setReportingDbServerCluterPassword(String ReportingDbServerCluterPassword) {
        this.ReportingDbServerCluterPassword = ReportingDbServerCluterPassword;
    }    

    public String getLogsQueue() {
        return LogsQueue;
    }

    public void setLogsQueue(String LogsQueue) {
        this.LogsQueue = LogsQueue;
    }   

    public String getSalesRepAppointmentsQueue() {
        return SalesRepAppointmentsQueue;
    }

    public void setSalesRepAppointmentsQueue(String SalesRepAppointmentsQueue) {
        this.SalesRepAppointmentsQueue = SalesRepAppointmentsQueue;
    }

    public String getJdbcDatasource() {
        return JdbcDatasource;
    }

    public void setJdbcDatasource(String JdbcDatasource) {
        this.JdbcDatasource = JdbcDatasource;
    }   

    public String getInfluxDbUri() {
        return InfluxDbUri;
    }

    public void setInfluxDbUri(String InfluxDbUri) {
        this.InfluxDbUri = InfluxDbUri;
    }    

    public String getApplicationId() {
        return ApplicationId;
    }

    public void setApplicationId(String ApplicationId) {
        this.ApplicationId = ApplicationId;
    }   

    public String getKafkaUrl() {
        return KafkaUrl;
    }

    public void setKafkaUrl(String KafkaUrl) {
        this.KafkaUrl = KafkaUrl;
    } 

    public boolean isArchiveSurveyResults() {
        return ArchiveSurveyResults;
    }

    public void setArchiveSurveyResults(boolean ArchiveSurveyResults) {
        this.ArchiveSurveyResults = ArchiveSurveyResults;
    }
    
    public String getUploaderDbPath() {
        return UploaderDbPath;
    }
    
    public void setUploaderDbPath(String uploaderDbPath) {
        UploaderDbPath = uploaderDbPath;
    }
    
    public boolean deleteOldDbBackups() {
        return DeleteOldDbBackups;
    }

    public void setDeleteOldDbBackups(boolean DeleteOldDbBackups) {
        this.DeleteOldDbBackups = DeleteOldDbBackups;
    }   

    public static enum AppEnvironments {
        STAGING("staging"),
        PRODUCTION("production"),
        NOT_SET("null");

        private final String text;

        AppEnvironments(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
    
    public static class TestClass {
    }
}
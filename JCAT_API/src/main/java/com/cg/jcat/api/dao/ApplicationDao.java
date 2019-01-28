package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.JcatApiApplication;
import com.cg.jcat.api.entity.Application;
import com.cg.jcat.api.exception.SystemExceptions;
import com.cg.jcat.api.repository.IApplicationRepository;

@Component
public class ApplicationDao {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationDao.class);
	@Autowired
	IApplicationRepository applicationRepository;
	
	public List<ApplicationModel> getApplications() throws SystemExceptions {
		
		List<Application> applicationList=new ArrayList<Application>();
		List<ApplicationModel> applicationDaoList=new ArrayList<ApplicationModel>();
		try {
		applicationList=applicationRepository.findAll();
		if(applicationList != null) {
			applicationDaoList=getApplication(applicationList,applicationDaoList);
		}
		}catch(Exception e) {
			logger.error("Applications Not available"+e.getMessage());
			throw new SystemExceptions("getApplications()");
		}
		logger.info("We got"+applicationDaoList.size()+"Number of Applictaions");
		return applicationDaoList;
	}
	private List<ApplicationModel> getApplication(List<Application> applicationList,List<ApplicationModel> applicationDaoList) {
		for(Application application :applicationList) {
			applicationDaoList.add(toGetApplication(application));
		}
		return applicationDaoList;
	}
	private ApplicationModel toGetApplication(Application application)
	{
		ApplicationModel appLicationModel=new ApplicationModel();
		appLicationModel.setAid(application.getAid());
		appLicationModel.setApplicationId(application.getApplicationId());
		appLicationModel.setApplicationName(application.getApplicationName());
		appLicationModel.setApplicationDescription(application.getApplicationDescription());
		appLicationModel.setApplicationDepartment(application.getApplicationDepartment());
		appLicationModel.setApplicationUser(application.getApplicationUser());
		appLicationModel.setDtCloudProvider(application.getDtCloudProvider());
		appLicationModel.setDtMigrationPattern(application.getDtMigrationPattern());
		appLicationModel.setPriority(application.getPriority());
		appLicationModel.setReCloudProvider(application.getReCloudProvider());
		appLicationModel.setReMigrationPattern(application.getReMigrationPattern());
		appLicationModel.setAssessmentStage(application.getAssessmentStage());
		appLicationModel.setCreatedBy(application.getCreatedBy());
		
		return appLicationModel;
	}
	
	public void save(String createdBy, ApplicationModel applicationModel) {
		applicationModel.setCreatedBy(createdBy);
		saveApplication(applicationModel);
	}
	
	private void saveApplication(ApplicationModel applicationModel) {
		applicationRepository.save(toApplication(applicationModel));
	}
	
    private Application toApplication(ApplicationModel applicationModel) {
    	Application application=new Application();
    	application.setAid(applicationModel.getAid());
    	application.setApplicationId(applicationModel.getApplicationId());
    	application.setApplicationName(applicationModel.getApplicationName());
    	application.setApplicationDescription(applicationModel.getApplicationDescription());
    	application.setApplicationDepartment(applicationModel.getApplicationDepartment());
    	application.setApplicationUser(applicationModel.getApplicationUser());
    	application.setAssessmentStage(applicationModel.getAssessmentStage());
    	application.setCreatedBy(applicationModel.getCreatedBy());
    	application.setDtCloudProvider(applicationModel.getDtCloudProvider());
    	application.setDtMigrationPattern(applicationModel.getDtMigrationPattern());
    	//application.setIsSssessmentCompleted(applicationModel.isIs_assessment_completed());
    	application.setPriority(applicationModel.getPriority());
    	application.setActivate(applicationModel.isActivate());
    	application.setDTCloudable(applicationModel.isDTCloudable());
    	application.setReCloudable(applicationModel.isRECloudable());
    	application.setReCloudProvider(applicationModel.getReCloudProvider());
    	//application.setRe_migration_pattern(applicationModel.getRe_migration_pattern());
    	
    	
    	return application;
    }
}

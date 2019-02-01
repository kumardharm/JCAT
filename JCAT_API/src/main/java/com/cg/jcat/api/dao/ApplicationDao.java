package com.cg.jcat.api.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.jcat.api.entity.Application;
import com.cg.jcat.api.repository.IApplicationRepository;

@Component
public class ApplicationDao {

	@Autowired
	IApplicationRepository applicationRepository;
	
	public List<ApplicationModel> getApplications() {
		
		List<Application> applicationList=new ArrayList<Application>();
		applicationList=applicationRepository.findAll();
		List<ApplicationModel> applicationDaoList=new ArrayList<ApplicationModel>();
		return getApplication(applicationList,applicationDaoList);
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
		appLicationModel.setApplication_id(application.getApplicationId());
		appLicationModel.setApplication_name(application.getApplicationName());
		appLicationModel.setApplication_description(application.getApplicationDescription());
		appLicationModel.setApplication_department(application.getApplicationDepartment());
		appLicationModel.setApplication_user(application.getApplicationUser());
		appLicationModel.setDt_cloud_provider(application.getDtCloudProvider());
		appLicationModel.setDt_migration_pattern(application.getDtMigrationPattern());
		appLicationModel.setPriority(application.getPriority());
		appLicationModel.setRe_cloud_provider(application.getReCloudProvider());
		appLicationModel.setRe_migration_pattern(application.getReMigrationPattern());
		appLicationModel.setAssessment_stage(application.getAssessmentStage());
		appLicationModel.setCreated_by(application.getCreatedBy());
		
		return appLicationModel;
	}
	
	public void save(String createdBy, ApplicationModel applicationModel) {
		applicationModel.setCreated_by(createdBy);
		saveApplication(applicationModel);
	}
	
	private void saveApplication(ApplicationModel applicationModel) {
		applicationRepository.save(toApplication(applicationModel));
	}
	
    private Application toApplication(ApplicationModel applicationModel) {
    	Date date = new Date();
    	Application application=new Application();
    	application.setAid(applicationModel.getAid());
    	application.setApplicationId(applicationModel.getApplication_id());
    	application.setApplicationName(applicationModel.getApplication_name());
    	application.setApplicationDescription(applicationModel.getApplication_description());
    	application.setApplicationDepartment(applicationModel.getApplication_department());
    	application.setApplicationUser(applicationModel.getApplication_user());
    	application.setAssessmentStage(applicationModel.getAssessment_stage());
    	application.setCreatedBy(applicationModel.getCreated_by());
    	application.setCreatedTime(date);
    	application.setDtCloudProvider(applicationModel.getDt_cloud_provider());
    	application.setDtMigrationPattern(applicationModel.getDt_migration_pattern());
    	//application.setIsSssessmentCompleted(applicationModel.isIs_assessment_completed());
    	application.setPriority(applicationModel.getPriority());
    	application.setActivate(applicationModel.isIs_activate());
    	application.setDTCloudable(applicationModel.isIs_dt_cloudable());
    	application.setReCloudable(applicationModel.isIs_re_cloudable());
    	application.setReCloudProvider(applicationModel.getRe_cloud_provider());
    	//application.setRe_migration_pattern(applicationModel.getRe_migration_pattern());
    	
    	
    	return application;
    }
}

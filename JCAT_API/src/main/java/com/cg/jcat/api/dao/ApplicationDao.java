package com.cg.jcat.api.dao;

import java.util.ArrayList;
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
		appLicationModel.setApplication_id(application.getApplication_id());
		appLicationModel.setApplication_name(application.getApplication_name());
		appLicationModel.setApplication_description(application.getApplication_description());
		appLicationModel.setApplication_department(application.getApplication_department());
		appLicationModel.setApplication_user(application.getApplication_user());
		appLicationModel.setDt_cloud_provider(application.getDt_cloud_provider());
		appLicationModel.setDt_migration_pattern(application.getDt_migration_pattern());
		appLicationModel.setPriority(application.getPriority());
		appLicationModel.setRe_cloud_provider(application.getRe_cloud_provider());
		appLicationModel.setRe_migration_pattern(application.getRe_migration_pattern());
		appLicationModel.setAssessment_stage(application.getAssessment_stage());
		appLicationModel.setCreated_by(application.getCreated_by());
		
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
    	Application application=new Application();
    	application.setAid(applicationModel.getAid());
    	application.setApplication_id(applicationModel.getApplication_id());
    	application.setApplication_name(applicationModel.getApplication_name());
    	application.setApplication_description(applicationModel.getApplication_description());
    	application.setApplication_department(applicationModel.getApplication_department());
    	application.setApplication_user(applicationModel.getApplication_user());
    	application.setAssessment_stage(applicationModel.getAssessment_stage());
    	application.setCreated_by(applicationModel.getCreated_by());
    	application.setDt_cloud_provider(applicationModel.getDt_cloud_provider());
    	application.setDt_migration_pattern(applicationModel.getDt_migration_pattern());
    	application.setIs_assessment_completed(applicationModel.isIs_assessment_completed());
    	application.setPriority(applicationModel.getPriority());
    	application.setIs_activate(applicationModel.isIs_activate());
    	application.setIs_dt_cloudable(applicationModel.isIs_dt_cloudable());
    	application.setIs_re_cloudable(applicationModel.isIs_re_cloudable());
    	application.setRe_cloud_provider(applicationModel.getRe_cloud_provider());
    	application.setRe_migration_pattern(applicationModel.getRe_migration_pattern());
    	
    	
    	return application;
    }
}

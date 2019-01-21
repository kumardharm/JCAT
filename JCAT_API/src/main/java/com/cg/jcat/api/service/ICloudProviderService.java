package com.cg.jcat.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.jcat.api.dao.CloudProvidersModel;
@Service
public interface ICloudProviderService {

	List<CloudProvidersModel> getCloudProvider();

}

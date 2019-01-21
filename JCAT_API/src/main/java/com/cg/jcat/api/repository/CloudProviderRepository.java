package com.cg.jcat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.jcat.api.entity.CloudProviders;

public interface CloudProviderRepository extends JpaRepository<CloudProviders, Integer>{

}

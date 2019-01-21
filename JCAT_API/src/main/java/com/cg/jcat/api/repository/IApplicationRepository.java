package com.cg.jcat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jcat.api.entity.Application;

@Repository
public interface IApplicationRepository extends JpaRepository<Application, Integer> {

}

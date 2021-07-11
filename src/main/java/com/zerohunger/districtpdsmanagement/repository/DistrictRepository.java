package com.zerohunger.districtpdsmanagement.repository;

import com.zerohunger.districtpdsmanagement.domain.GovBody;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends MongoRepository<GovBody, String> {

	GovBody findOneByDistrictName(final String stateName);
	
}

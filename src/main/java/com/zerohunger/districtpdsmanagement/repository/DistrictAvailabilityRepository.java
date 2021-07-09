package com.zerohunger.districtpdsmanagement.repository;

import com.zerohunger.districtpdsmanagement.domain.GovBodyRawMaterialAvailability;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictAvailabilityRepository extends MongoRepository<GovBodyRawMaterialAvailability, String> {

	GovBodyRawMaterialAvailability findOneByStateName(final String stateName);
	
}

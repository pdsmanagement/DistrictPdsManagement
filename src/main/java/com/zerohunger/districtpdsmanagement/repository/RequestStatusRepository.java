package com.zerohunger.districtpdsmanagement.repository;

import com.zerohunger.districtpdsmanagement.domain.RequestStatus;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestStatusRepository extends MongoRepository<RequestStatus, String> {

	RequestStatus findOneByRequestId(final String requestId);
	
}

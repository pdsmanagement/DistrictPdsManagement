package com.zerohunger.districtpdsmanagement.repository;

import java.util.Optional;

import com.zerohunger.districtpdsmanagement.domain.RequestStatus;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestStatusRepository extends MongoRepository<RequestStatus, String> {

	Optional<RequestStatus> findOneByRequestId(final String requestId);
	
}

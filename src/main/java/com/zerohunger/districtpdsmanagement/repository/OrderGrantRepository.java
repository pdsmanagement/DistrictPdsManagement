package com.zerohunger.districtpdsmanagement.repository;

import com.zerohunger.districtpdsmanagement.domain.OrderGrant;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGrantRepository extends MongoRepository<OrderGrant, String> {
	
	
}

package com.zerohunger.districtpdsmanagement.repository;

import com.zerohunger.districtpdsmanagement.domain.OrderRequest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRequestRepository extends MongoRepository<OrderRequest, String> {

}

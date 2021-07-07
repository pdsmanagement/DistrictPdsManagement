package com.zerohunger.districtpdsmanagement.service;

import com.zerohunger.districtpdsmanagement.domain.District;
import com.zerohunger.districtpdsmanagement.domain.DistrictAvailability;
import com.zerohunger.districtpdsmanagement.domain.OrderGrant;
import com.zerohunger.districtpdsmanagement.domain.OrderRequest;
import com.zerohunger.districtpdsmanagement.domain.RequestStatus;
import com.zerohunger.districtpdsmanagement.dto.OrderGrantService;
import com.zerohunger.districtpdsmanagement.dto.OrderRequestService;

import reactor.core.publisher.Mono;

public interface DistrictManagementService {

    Mono<DistrictAvailability> getRationAvailability(String districtName);

    Mono<District> getDistrictCapacity(String districtName);

    Mono<OrderRequest> requestforRation(OrderRequestService orderRequest);

    Mono<OrderGrant> grantOrderNote(OrderGrantService grantOrder);

    Mono<RequestStatus> getOrderStatus(String requestId);
    
}

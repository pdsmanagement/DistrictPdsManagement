package com.zerohunger.districtpdsmanagement.service;

import com.zerohunger.districtpdsmanagement.domain.GovBody;
import com.zerohunger.districtpdsmanagement.domain.GovBodyRawMaterialAvailability;
import com.zerohunger.districtpdsmanagement.domain.OrderGrant;
import com.zerohunger.districtpdsmanagement.domain.OrderRequest;
import com.zerohunger.districtpdsmanagement.domain.RequestStatus;
import com.zerohunger.districtpdsmanagement.dto.OrderGrantService;
import com.zerohunger.districtpdsmanagement.dto.OrderRequestService;

import reactor.core.publisher.Mono;

public interface DistrictManagementService {

    Mono<GovBodyRawMaterialAvailability> getRationAvailability(String districtName);

    Mono<GovBody> getDistrictCapacity(String districtName);

    Mono<OrderRequest> requestforRation(OrderRequestService orderRequest);

    Mono<OrderGrant> grantOrderNote(OrderGrantService grantOrder);

    Mono<RequestStatus> getOrderStatus(String requestId);
    
}

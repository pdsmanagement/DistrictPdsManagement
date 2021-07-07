package com.zerohunger.districtpdsmanagement.service.implementation;

import com.zerohunger.districtpdsmanagement.domain.District;
import com.zerohunger.districtpdsmanagement.domain.DistrictAvailability;
import com.zerohunger.districtpdsmanagement.domain.OrderGrant;
import com.zerohunger.districtpdsmanagement.domain.OrderRequest;
import com.zerohunger.districtpdsmanagement.domain.RequestStatus;
import com.zerohunger.districtpdsmanagement.dto.OrderGrantService;
import com.zerohunger.districtpdsmanagement.dto.OrderRequestService;
import com.zerohunger.districtpdsmanagement.service.DistrictManagementService;

import reactor.core.publisher.Mono;

public class DistrictManagementServiceImpl implements DistrictManagementService{

    @Override
    public Mono<DistrictAvailability> getRationAvailability(String districtName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<District> getDistrictCapacity(String districtName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<OrderRequest> requestforRation(OrderRequestService orderRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<OrderGrant> grantOrderNote(OrderGrantService grantOrder) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<RequestStatus> getOrderStatus(String requestId) {
        // TODO Auto-generated method stub
        return null;
    }

}

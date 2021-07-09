package com.zerohunger.districtpdsmanagement.service.implementation;

import com.zerohunger.districtpdsmanagement.domain.GovBody;
import com.zerohunger.districtpdsmanagement.domain.GovBodyRawMaterialAvailability;
import com.zerohunger.districtpdsmanagement.domain.OrderGrant;
import com.zerohunger.districtpdsmanagement.domain.OrderRequest;
import com.zerohunger.districtpdsmanagement.domain.RequestStatus;
import com.zerohunger.districtpdsmanagement.dto.OrderGrantService;
import com.zerohunger.districtpdsmanagement.dto.OrderRequestService;
import com.zerohunger.districtpdsmanagement.service.DistrictManagementService;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class DistrictManagementServiceImpl implements DistrictManagementService{

    @Override
    public Mono<GovBodyRawMaterialAvailability> getRationAvailability(String districtName) {
        // get data from database using district name

        return null;
    }

    @Override
    public Mono<GovBody> getDistrictCapacity(String districtName) {
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

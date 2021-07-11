package com.zerohunger.districtpdsmanagement.service.implementation;

import java.util.Date;
import java.util.Optional;

import com.zerohunger.districtpdsmanagement.constant.OrderRequestStatus;
import com.zerohunger.districtpdsmanagement.domain.GovBody;
import com.zerohunger.districtpdsmanagement.domain.GovBodyRawMaterialAvailability;
import com.zerohunger.districtpdsmanagement.domain.OrderGrant;
import com.zerohunger.districtpdsmanagement.domain.OrderRequest;
import com.zerohunger.districtpdsmanagement.domain.RequestStatus;
import com.zerohunger.districtpdsmanagement.dto.OrderGrantService;
import com.zerohunger.districtpdsmanagement.dto.OrderRequestService;
import com.zerohunger.districtpdsmanagement.exception.EntityNotFoundException;
import com.zerohunger.districtpdsmanagement.exception.OrderGrantSaveError;
import com.zerohunger.districtpdsmanagement.exception.OrderRequestSaveError;
import com.zerohunger.districtpdsmanagement.repository.DistrictAvailabilityRepository;
import com.zerohunger.districtpdsmanagement.repository.DistrictRepository;
import com.zerohunger.districtpdsmanagement.repository.OrderGrantRepository;
import com.zerohunger.districtpdsmanagement.repository.OrderRequestRepository;
import com.zerohunger.districtpdsmanagement.repository.RequestStatusRepository;
import com.zerohunger.districtpdsmanagement.service.DistrictManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DistrictManagementServiceImpl implements DistrictManagementService{

    @Autowired
    private DistrictAvailabilityRepository districtAvailabilityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private OrderGrantRepository orderGrantRepository;

    @Autowired
    private OrderRequestRepository orderRequestRepository;

    @Autowired
    private RequestStatusRepository requestStatusRepository;

    private static String DistrictInCamelCase = "";

    @Override
    public Mono<GovBodyRawMaterialAvailability> getRationAvailability(String districtName) {
        // get data from database using district name
        log.info(String.format("Getting Ration Availability for District: %s", districtName));
        DistrictInCamelCase = StringUtils.capitalize(districtName);
        Optional<GovBodyRawMaterialAvailability> data = Optional.ofNullable(districtAvailabilityRepository.findOneByDistrictName(DistrictInCamelCase));
        if(data.isPresent()){
            log.info("Ration Availability Service Completed !");
            return Mono.just(data.get());
        }
        else{
            log.error("Ration Availability Service Failed !");
            return Mono.error(new EntityNotFoundException("District Not Found "+districtName));
        }
    }

    @Override
    public Mono<GovBody> getDistrictCapacity(String districtName) {
        log.info(String.format("Getting Ration Capacity for District: %s", districtName));
        DistrictInCamelCase = StringUtils.capitalize(districtName);
        Optional<GovBody> data = Optional.ofNullable(districtRepository.findOneByDistrictName(DistrictInCamelCase));
        if(data.isPresent()){
            log.info("Ration Capacity of District Service Completed !");
            return Mono.just(data.get());
        }
        else{
            log.error("Ration Capacity of District Service Failed !");
            return Mono.error(new EntityNotFoundException("District Not Found "+districtName));
        }
    }

    @Override
    public Mono<OrderRequest> requestforRation(OrderRequestService orderRequest) {
        log.info(String.format("Requesting Ration for District: %s", orderRequest.getRequestingDistrictName()));
        DistrictInCamelCase = StringUtils.capitalize(orderRequest.getRequestingDistrictName());
        // check district name is present is database or not
        Optional<GovBody> data = Optional.ofNullable(districtRepository.findOneByDistrictName(DistrictInCamelCase));
        if(data.isPresent()){
            // create new order request
            Date date = new Date();
            OrderRequest orderRequestEntity = new OrderRequest(orderRequest.getRequestingStateName(), orderRequest.getRawMaterialName(), orderRequest.getQuantity(), orderRequest.getUnits(), true, date, date, orderRequest.getRequestingDistrictName());
            // save new order request
            Optional<OrderRequest> dbRes = Optional.ofNullable(orderRequestRepository.save(orderRequestEntity));
            if(dbRes.isPresent()){
                log.info("Ration Request Service Completed !");
                // update request status to pending
                requestStatusRepository.save(new RequestStatus(dbRes.get().getId(), OrderRequestStatus.PENDING,0.0, dbRes.get().getQuantity()));
                return Mono.just(dbRes.get());
            }
            else{
                log.error("Ration Request Service Failed !");
                return Mono.error(new OrderRequestSaveError("Request for Ration Service Error ! - Order Request Save Failed"));
            }
        }
        else{
            log.error("Ration Request Service Failed ! District Name not Found "+orderRequest.getRequestingDistrictName());
            return Mono.error(new EntityNotFoundException("District Not Found "+orderRequest.getRequestingDistrictName()));
        }
    }

    @Override
    public Mono<OrderGrant> grantOrderNote(OrderGrantService grantOrder) {
        log.info(String.format("Granting Order Note for District: %s", grantOrder.getGrantingDistrictName()));
        DistrictInCamelCase = StringUtils.capitalize(grantOrder.getGrantingDistrictName());
        // get data from database using district name
        Optional<GovBody> data = Optional.ofNullable(districtRepository.findOneByDistrictName(DistrictInCamelCase));
        if(data.isPresent()){
            // create new order grant
            Date date = new Date();
            OrderGrant orderGrantEntity = new OrderGrant(grantOrder.getGrantingStateName() , grantOrder.getRequestId(), grantOrder.getQuantityGranted(), date, date, grantOrder.getGrantingDistrictName());
            // save new order grant
            Optional<OrderGrant> dbRes = Optional.ofNullable(orderGrantRepository.save(orderGrantEntity));
            if(dbRes.isPresent()){
                log.info("Order Grant Service Completed !");
                updateOrderRequestAndRequestStatusOnGrantOrderNote(dbRes.get());
                return Mono.just(dbRes.get());
            }
            else{
                log.error("Order Grant Service Failed !");
                return Mono.error(new OrderGrantSaveError("Order Grant Service Error ! - Order Grant Save Failed"));
            }
        }
        else{
            log.error("Ration Grant Service Failed ! District Name not Found "+grantOrder.getGrantingDistrictName());
            return Mono.error(new EntityNotFoundException("District Not Found "+grantOrder.getGrantingDistrictName()));
        }
    }

    @Override
    public Mono<RequestStatus> getOrderStatus(String requestId) {
        log.info(String.format("Getting Order Status for Request Id: %s", requestId));
        Optional<RequestStatus> data = Optional.ofNullable(requestStatusRepository.findOneByRequestId(requestId));
        if(data.isPresent()){
            log.info("Order Status Service Completed !");
            return Mono.just(data.get());
        }
        else{
            log.error("Order Status Service Failed !");
            return Mono.error(new EntityNotFoundException("Request Id Not Found "+requestId));
        }
    }

    
    private void updateOrderRequestAndRequestStatusOnGrantOrderNote(OrderGrant orderGrant) {
        // update order request status
        // Optional<OrderRequest> orderRequest = Optional.ofNullable(orderRequestRepository.findOneByRequestId(orderGrant.getRequestId()));
        // if(orderRequest.isPresent()){
        //     Optional<RequestStatus> requestStatus = Optional.ofNullable(requestStatusRepository.findOneByRequestId(orderGrant.getRequestId()));
        //     if(requestStatus.isPresent()){
        //         requestStatus.get().setStatus(OrderRequestStatus.GRANTED);
        //         requestStatus.get().setQuantity(orderRequest.get().getQuantity());
        //         requestStatus.get().setRequestedQuantity(orderRequest.get().getQuantity());
        //         requestStatus.get().setRequestedDate(orderRequest.get().getRequestedDate());
        //         requestStatus.get().setGrantedDate(orderGrant.getGrantDate());
        //         requestStatus.get().setGrantAmount(orderGrant.getQuantityGranted());
        //         requestStatusRepository.save(requestStatus.get());
        //     }
        // }
    }

}

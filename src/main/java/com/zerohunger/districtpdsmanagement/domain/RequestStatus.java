package com.zerohunger.districtpdsmanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zerohunger.districtpdsmanagement.constant.OrderRequestStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "DistrictRequestStatus")
@NoArgsConstructor
@Schema(description = "Model for Status of a Order Request for Ration by State")
public class RequestStatus {

	@Id
	private String id;
	@Schema(description = "Request ID of Order Request Placed by a State for Ration")
	private String requestId;
	@Schema(description = "Status of Order Request by State for Ration")
	private OrderRequestStatus status;
	@Schema(description = "Quantity Granted by Granting State to the Requestor")
	private Double quantityFulfilled;
	public RequestStatus(String requestId, OrderRequestStatus status, Double quantityFulfilled) {
		super();
		this.requestId = requestId;
		this.status = status;
		this.quantityFulfilled = quantityFulfilled;
	}
	
}

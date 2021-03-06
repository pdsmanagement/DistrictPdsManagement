 package com.zerohunger.districtpdsmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Model for Order Grant Request by a State for a particular Order request")
public class OrderGrantService {
	
	@Schema(description = "District who is Granting Ration to a Requesting District in the Same State")
	private String grantingDistrictName;
	@Schema(description = "State name to which the Granting District belongs to")
	private String grantingStateName;
	@Schema(description = "Request ID for whom the Grant Order will be released")
	private String requestId;
	@Schema(description = "Quantity of the Ration granted by the District")
	private Double quantityGranted;

}

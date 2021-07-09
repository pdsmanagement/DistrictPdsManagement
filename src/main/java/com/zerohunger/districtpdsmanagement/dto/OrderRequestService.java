package com.zerohunger.districtpdsmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Model for Order Request by a State who needs Ration from another State")
public class OrderRequestService {
	
	@Schema(description = "District who needs Ration from other Districts in the same State")
	private String requestingDistrictName;
	@Schema(description = "State name to which the Requesting District belongs to")
	private String requestingStateName;
	@Schema(description = "Name of the Ration")
	private String rawMaterialName;
	@Schema(description = "Quantity of Ration Needed by the District")
	private Double quantity;
	@Schema(description = "Unit in which Ration Needed - KG/Quintal/Gram")
	private String units;

}

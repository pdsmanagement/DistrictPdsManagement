package com.zerohunger.districtpdsmanagement.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "DistrictAvailability")
@NoArgsConstructor
@Schema(description = "Model to Get availability of all Rations for a particular District")
public class DistrictAvailability {

	@Id
	private String id;
	@Schema(description = "Name of District in the State")
	private String districtName;
	@Schema(description = "Name of State to which District belongs")
	private String stateName;
	@Schema(description = "Availability of Ration Name along with Quantity")
	private List<Availability> availability;
	public DistrictAvailability(String stateName, List<Availability> availability) {
		super();
		this.stateName = stateName;
		this.availability = availability;
	}
	
}

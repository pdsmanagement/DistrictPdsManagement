package com.zerohunger.districtpdsmanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "District")
@NoArgsConstructor
@Schema(description = "Model to describe District")
public class District {
	
	@Id
	private String id;
	@Schema(description = "Name of District in the State")
	private String districtName;
	@Schema(description = "Name of State to which District belongs")
	private String stateName;
	@Schema(description = "Point of Contact for the District/ DPOC")
	private Meta metaData;
	@Schema(description = "Total Capacity of District to hold Rations")
	private Double capacity;
	public District(String districtName, String stateName, Meta metaData, Double capacity) {
		super();
		this.districtName = districtName;
		this.stateName = stateName;
		this.metaData = metaData;
		this.capacity = capacity;
	}

}

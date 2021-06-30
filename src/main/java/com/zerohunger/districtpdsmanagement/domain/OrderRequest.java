package com.zerohunger.districtpdsmanagement.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "DistrictOrderRequest")
@NoArgsConstructor
public class OrderRequest {

	@Id
	private String id;
	private String requestingDistrictName;
	private String stateName;
	private String rawMaterialName;
	private Double quantity;
	private String unitsRequested;
	private Boolean isActive;

	//@CreatedDate
	private Date createdOn;
	
	//@LastModifiedDate 
	private Date modifiedOn;
	
	public OrderRequest(String requestingDistrictName, String stateName, String rawMaterialName, Double quantity, String unitsRequested,
			Boolean isActive, Date createdOn, Date modifiedOn) {
		super();
		this.requestingDistrictName = requestingDistrictName;
		this.stateName = stateName;
		this.rawMaterialName = rawMaterialName;
		this.quantity = quantity;
		this.unitsRequested = unitsRequested;
		this.isActive = isActive;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	
}

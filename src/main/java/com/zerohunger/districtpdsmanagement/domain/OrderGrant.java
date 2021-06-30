package com.zerohunger.districtpdsmanagement.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "DistrictOrderGrant")
@NoArgsConstructor
public class OrderGrant {

	@Id
	private String id;
	private String grantingDistrictName;
	private String stateName;
	private String requestId;
	private Double quantity;
	
	//@CreatedDate
	private Date createdOn;
	
	//@LastModifiedDate 
	private Date modifiedOn;
	
	public OrderGrant(String grantingDistrictName, String stateName, String requestId, Double quantity, Date createdOn, Date modifiedOn) {
		super();
		this.grantingDistrictName = grantingDistrictName;
		this.stateName = stateName;
		this.requestId = requestId;
		this.quantity = quantity;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	
}

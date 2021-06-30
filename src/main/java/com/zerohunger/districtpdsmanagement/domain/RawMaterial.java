package com.zerohunger.districtpdsmanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zerohunger.districtpdsmanagement.constant.RationItem;

import lombok.Data;

@Data
@Document(collection = "DistrictRawMaterial")
public class RawMaterial {

	@Id
	private String id;
	private RationItem rationItem;
	public RawMaterial(RationItem rationItem) {
		super();
		this.rationItem = rationItem;
	}
	
}

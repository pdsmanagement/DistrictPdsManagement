package com.zerohunger.districtpdsmanagement.constant;

public enum OrderRequestStatus {

	ACCEPTED_BY_STATE("AcceptedByState"), PENDING("Pending"), CRITICAL("Critical"), WITHDRAWN("Withdrawn"), FULFILLED("Fullfilled"), PARTIALY_FULFILLED("PartialyFulfilled");

	private final String orderStatus;

	OrderRequestStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getRationItem() {
		return orderStatus;
	}
	
}

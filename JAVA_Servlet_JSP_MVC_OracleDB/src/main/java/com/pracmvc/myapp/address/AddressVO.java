package com.pracmvc.myapp.address;

import java.util.Map;

// VO
public class AddressVO {

	private String mainAddress;
	private String subAddress;
	
	public String getMainAddress() {
		return mainAddress;
	}
	public String getSubAddress() {
		return subAddress;
	}
	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}
	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}
	
	// 기본 주소가 비어있는지 검증
	public void validateMain(Map<String, Boolean> errors) {
		if(mainAddress == null || mainAddress.trim().isEmpty()) {
			errors.put("main", Boolean.TRUE);
		}
	}
	// 상세 주소가 비어있는지 검증
	public void validateSub(Map<String, Boolean> errors) {
		if(subAddress == null || subAddress.trim().isEmpty()) {
			errors.put("sub", Boolean.TRUE);
		}
	}
	
}

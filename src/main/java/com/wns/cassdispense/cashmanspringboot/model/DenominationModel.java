package com.wns.cassdispense.cashmanspringboot.model;

public class DenominationModel {
	
	
	private String denominationValue;
	private int denominationValueCount;
	
	public String getDenominationValue() {
		return denominationValue;
	}
	public void setDenominationValue(String denominationValue) {
		this.denominationValue = denominationValue;
	}
	public int getDenominationValueCount() {
		return denominationValueCount;
	}
	public void setDenominationValueCount(int denominationValueCount) {
		this.denominationValueCount = denominationValueCount;
	}
	@Override
	public String toString() {
		return "DenominationModel [denominationValue=" + denominationValue + ", denominationValueCount="
				+ denominationValueCount + "]";
	}
	
	
	
	

}

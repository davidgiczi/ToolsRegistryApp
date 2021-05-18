package com.geoLink3D.toolsregistry.demo.model;

import java.util.Date;

public class Tool {

	
	private String name;
	private String serialNumber;
	private String pickUpPlace;
	private Date pickUpDate;
	private String putDownPlace;
	private Date putDownDate;
	private String toolUser;
	private Boolean isUsed;
	
	public Tool() {
	}
	
	public Tool(String name, String serialNumber) {
		this.name = name;
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getPickUpPlace() {
		return pickUpPlace;
	}

	public void setPickUpPlace(String pickUpPlace) {
		this.pickUpPlace = pickUpPlace;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public String getPutDownPlace() {
		return putDownPlace;
	}

	public void setPutDownPlace(String putDownPlace) {
		this.putDownPlace = putDownPlace;
	}

	public Date getPutDownDate() {
		return putDownDate;
	}

	public void setPutDownDate(Date putDownDate) {
		this.putDownDate = putDownDate;
	}

	public Boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getToolUser() {
		return toolUser;
	}

	public void setToolUser(String toolUser) {
		this.toolUser = toolUser;
	}

	@Override
	public String toString() {
		return "Tool [name=" + name + ", serialNumber=" + serialNumber + ", pickUpPlace=" + pickUpPlace
				+ ", pickUpDate=" + pickUpDate + ", putDownPlace=" + putDownPlace + ", putDownDate=" + putDownDate
				+ ", toolUser=" + toolUser + ", isUsed=" + isUsed + "]";
	}
	
}

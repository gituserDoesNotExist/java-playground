package org.fancypackage.dto;

public class UserDTO {

	private String userName;
	private int mobilePhoneNumber;

	public UserDTO() {

	}

	public UserDTO(String userName, int mobilePhoneNumber) {
		this.userName = userName;
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(int mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

}

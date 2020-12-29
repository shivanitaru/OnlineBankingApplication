package com.Model;

public class UserPersonalModel {
	private String customerName;
	private String customerFathersName;
	private String gender;
	private String dateOfBirth;
	private String nationality;
	private long mobileNumber;
	private String emailId;
	// SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerFathersName() {
		return customerFathersName;
	}

	public void setCustomerFathersName(String customerFathersName) {
		this.customerFathersName = customerFathersName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		// this.dateOfBirth = formatter.format(dateOfBirth);
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}

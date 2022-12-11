package al.errvini.restaurantapp.model;

//Define attributes of client for a restaurant

// name (Firstname Lastname)= Text
//email
//phoneNo=Text=+355=String

public class Client {
	private String name;
	private String phoneNo;
	private String address;
	private String zipCode;

	public Client(String name, String phoneNo, String address, String zipCode) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;

	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}

package table.data.example;

import org.primefaces.util.Constants;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	private String phone;
	private String address;
	private Country country;
	private String company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		this.fullName =  firstName + Constants.SPACE + lastName;
		return this.fullName;
	}

	public String getEmail() {
		this.email = String.format("%s.%s@gmail.com", firstName, lastName);
		return this.email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}

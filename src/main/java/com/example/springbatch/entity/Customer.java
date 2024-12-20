package com.example.springbatch.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	@Id
	@Column(name="id")
    private long index;
    private String customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String city;
    private String country;
    private String phone1;
    private String phone2;
    private String email;
    private String subscriptionDate;
    private String website;
	public Customer() {
		super();
	}
	public Customer(long index, String customerId, String firstName, String lastName, String company, String city,
			String country, String phone1, String phone2, String email, String subscriptionDate, String website) {
		super();
		this.index = index;
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.city = city;
		this.country = country;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.subscriptionDate = subscriptionDate;
		this.website = website;
	}
	public long getIndex() {
		return index;
	}
	public void setIndex(long index) {
		this.index = index;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, company, country, customerId, email, firstName, index, lastName, phone1, phone2,
				subscriptionDate, website);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(city, other.city) && Objects.equals(company, other.company)
				&& Objects.equals(country, other.country) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& index == other.index && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phone1, other.phone1) && Objects.equals(phone2, other.phone2)
				&& Objects.equals(subscriptionDate, other.subscriptionDate) && Objects.equals(website, other.website);
	}
	@Override
	public String toString() {
		return "Customer [index=" + index + ", customerId=" + customerId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", company=" + company + ", city=" + city + ", country=" + country + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", email=" + email + ", subscriptionDate=" + subscriptionDate + ", website="
				+ website + "]";
	}
	

}

package com.hotel.MicroService_Booking.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bookings")
public class Bookings {
	
	@Id
	private String id;
	
	private String category;
	
	private String roomNo;
	
	private Date checkIn;
	
	private Date checkOut;
	
	private String name;
	
	private String contactNo;
	
	private String email;
	
	private String addressProof;
	
	private String proofId;
	
	private String paymentStatus;
	
	private String company;
	
	private String city;
	
	private String spoc;
	
	private String paymentType;
	
	private String amount;
	
	private String status;
	
	public Bookings() {}

	public Bookings(String id, String category, String roomNo, Date checkIn, Date checkOut, String name,
			String contactNo, String email, String addressProof, String proofId, String paymentStatus, String company,
			String city, String spoc, String paymentType, String amount, String status) {
		super();
		this.id = id;
		this.category = category;
		this.roomNo = roomNo;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.name = name;
		this.contactNo = contactNo;
		this.email = email;
		this.addressProof = addressProof;
		this.proofId = proofId;
		this.paymentStatus = paymentStatus;
		this.company = company;
		this.city = city;
		this.spoc = spoc;
		this.paymentType = paymentType;
		this.amount = amount;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	public String getProofId() {
		return proofId;
	}

	public void setProofId(String proofId) {
		this.proofId = proofId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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

	public String getSpoc() {
		return spoc;
	}

	public void setSpoc(String spoc) {
		this.spoc = spoc;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bookings[id=" + id + ", category=" + category + ", roomNo=" + roomNo + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + ", name=" + name + ", contactNo=" + contactNo + ", email=" + email
				+ ", addressProof=" + addressProof + ", proofId=" + proofId + ", paymentStatus=" + paymentStatus
				+ ", company=" + company + ", city=" + city + ", spoc=" + spoc + ", paymentType=" + paymentType
				+ ", amount=" + amount + ", status=" + status + "]";
	}
		
}

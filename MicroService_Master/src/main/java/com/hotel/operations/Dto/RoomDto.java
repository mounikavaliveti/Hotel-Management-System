package com.hotel.operations.Dto;

public class RoomDto {

    private String id;
	
	private String roomNo;
	
	private String floor;
	
	private String category;
	
	private String capacity;
	
	private String price;
	
	private boolean booked;
	
	public RoomDto() {}

	public RoomDto(String id, String roomNo, String floor, String category, String capacity, String price, boolean booked) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.floor = floor;
		this.category = category;
		this.capacity = capacity;
		this.price = price;
		this.booked = booked;
	}

	public RoomDto(String roomNo, String floor, String category, String capacity, String price, boolean booked) {
		this.roomNo = roomNo;
		this.floor = floor;
		this.category = category;
		this.capacity = capacity;
		this.price = price;
		this.booked = booked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNo=" + roomNo + ", floor=" + floor + ", category=" + category + ", capacity="
				+ capacity + ", price=" + price + ", booked=" + booked + "]";
	}
	
}

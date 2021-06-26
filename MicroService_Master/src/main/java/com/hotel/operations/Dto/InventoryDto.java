package com.hotel.operations.Dto;

public class InventoryDto {

    private String id;
	
	private String name;
	
	private String quantity;
	
	private String price;
	
	public InventoryDto() {}

	public InventoryDto(String id, String name, String quantity, String price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}

}

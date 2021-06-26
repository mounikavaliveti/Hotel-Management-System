package com.hotel.operations.service;

import java.util.List;

import com.hotel.operations.Dto.InventoryDto;

public interface InventoryService {

    public String saveInventory(InventoryDto inventoryDto);
	
	public List<InventoryDto> getAllInventory();
	
	public InventoryDto findById(String id);
	
	public String deleteInventoryById(String id);
}

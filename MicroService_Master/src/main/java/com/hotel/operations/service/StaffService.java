package com.hotel.operations.service;

import java.util.List;

import com.hotel.operations.Dto.StaffDto;

public interface StaffService {

	public String saveStaff(StaffDto staffDto);
	
	public List<StaffDto> getAllStaff();
	
	public StaffDto findById(String id);
	
	public String deleteStaffById(String id);

	public String updateStaff(StaffDto staffDto);
}

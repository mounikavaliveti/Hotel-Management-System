package com.hotel.operations.service;

import java.util.List;

import com.hotel.operations.Dto.RegisterDto;

public interface RegisterService {

    public String saveEmployee(RegisterDto registerDto);
	
	public List<RegisterDto> getAllRegistered();
	
	public RegisterDto findById(String id);
	
	public String deleteRegisterById(String id);
	
	public RegisterDto findByEmailAndPassword(String email, String password);
}

package com.hotel.operations.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.operations.Dto.RegisterDto;
import com.hotel.operations.Repository.RegisterRepository;
import com.hotel.operations.entityDao.Register;
import com.hotel.operations.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	RegisterRepository registerRepository;

	public String saveEmployee(RegisterDto registerDto) {
		
		Register employee = new Register(registerDto.getId(),registerDto.getEmail(),registerDto.getPassword(),registerDto.getRole(),registerDto.getEmpId());
		Register savedEmployee = registerRepository.save(employee);
		
		return savedEmployee.getEmpId();
	}


public List<RegisterDto> getAllRegistered(){
		
		List<Register> registerList= registerRepository.findAll();
		
		List<RegisterDto> result = new ArrayList<RegisterDto>();
		if(!registerList.isEmpty()) {
			for(Register s:registerList){
				RegisterDto registerDto = new RegisterDto(s.getId(),s.getEmail(),s.getPassword(),s.getRole(),s.getEmpId());
				result.add(registerDto);
			}
		}
	return result;
	}
	
	public RegisterDto findById(String id) {
		
		RegisterDto registerDto = null;
		Optional<Register> register = registerRepository.findById(id);
		
		if(register.isPresent()) {
			Register s =register.get();
			registerDto = new RegisterDto(s.getId(),s.getEmail(),s.getPassword(),s.getRole(),s.getEmpId());
		}
		
	    return registerDto;	
	
	}
	
	public String deleteRegisterById(String id) {
		registerRepository.deleteById(id);
		return "SUCCESS";
	}
	
	public RegisterDto findByEmailAndPassword(String email, String password) {
		RegisterDto registerDto = null;
		Register register = registerRepository.findByEmailAndPassword(email, password);
		
		if(null != register) {
			registerDto = new RegisterDto(register.getId(),register.getEmail(),register.getPassword(),register.getRole(),register.getEmpId());
		
		}
	    return registerDto;	
	
	}

}

package com.hotel.operations.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.operations.Dto.StaffDto;
import com.hotel.operations.Repository.StaffRepository;
import com.hotel.operations.entityDao.Staff;
import com.hotel.operations.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	StaffRepository staffRepository;

	public String saveStaff(StaffDto staffDto) {
		
		Staff staff = new Staff(staffDto.getId(),staffDto.getName(),staffDto.getEmpId(),staffDto.getEmail(),staffDto.getContactNo(),
				staffDto.getSalary(),staffDto.getDob(),staffDto.getJoinDate(),staffDto.getEndDate(),staffDto.getRole());
		
		staffRepository.save(staff);
		return staffDto.getEmpId();
	}
	
	public List<StaffDto> getAllStaff(){
		
		List<Staff> staffList= staffRepository.findAll();
		
		List<StaffDto> result = new ArrayList<StaffDto>();
		if(!staffList.isEmpty()) {
			for(Staff s:staffList){
				StaffDto staffDto = new StaffDto(s.getId(),s.getName(),s.getEmpId(),s.getEmail(),s.getContactNo(),
						s.getSalary(),s.getDob(),s.getJoinDate(),s.getEndDate());
				result.add(staffDto);
			}
		}
	return result;
	}
	
	public StaffDto findById(String id) {
		
		StaffDto staffDto = null;
		Optional<Staff> staff = staffRepository.findById(id);
		
		if(staff.isPresent()) {
			Staff s =staff.get();
			staffDto = new StaffDto(s.getId(),s.getName(),s.getEmpId(),s.getEmail(),s.getContactNo(),
					s.getSalary(),s.getDob(),s.getJoinDate(),s.getEndDate());
		}
		
	    return staffDto;	
	
	}
	
	public String deleteStaffById(String id) {
		staffRepository.deleteById(id);
		return "staff deleted";
	}

	@Override
	public String updateStaff(StaffDto staffDto) {
		Optional<Staff> room = staffRepository.findById(staffDto.getId());
		System.out.println("UPdating"+staffDto.getEmpId());
		Staff updatedStaff = null;
		if(room.isPresent()){
			Staff staff = new Staff(staffDto.getId(),staffDto.getName(),staffDto.getEmpId(),staffDto.getEmail(),staffDto.getContactNo(),
					staffDto.getSalary(),staffDto.getDob(),staffDto.getJoinDate(),staffDto.getEndDate(),
					staffDto.getRole());

			staffRepository.save(staff);
			return staff.getEmpId();
		}else{
			return "Unable to find employee";
		}

	}

}

package com.hotel.operations.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hotel.operations.Dto.InventoryDto;
import com.hotel.operations.Dto.RegisterDto;
import com.hotel.operations.Dto.RoomDto;
import com.hotel.operations.Dto.StaffDto;
import com.hotel.operations.Repository.CategoryRepository;
import com.hotel.operations.entityDao.Category;
import com.hotel.operations.service.InventoryService;
import com.hotel.operations.service.RegisterService;
import com.hotel.operations.service.RoomService;
import com.hotel.operations.service.StaffService;

@CrossOrigin
@RestController
@RequestMapping("/hotel")
public class Controller {
	   
	 @Autowired
	   StaffService staffServiceImpl;
	   
	   @Autowired
	   RoomService roomServiceImpl;

		@Autowired
		CategoryRepository categoryRepository;
	   
	   @Autowired
	   RegisterService registerServiceImpl;
	   
	   @Autowired
	   InventoryService inventoryServiceImpl;




	    @GetMapping(value = "/test/Api")
	    public String testHm() {


	        return "Welcome to Function-Service!!!";
	    }
	    
		@PostMapping(value = "/save/staff")
		public String saveStaff(@RequestBody StaffDto staffDto) {

			return staffServiceImpl.saveStaff(staffDto);
		}
		
		@PostMapping(value = "/save/room")
		public String saveRoom(@RequestBody RoomDto roomDto) {
			
			return roomServiceImpl.saveRoom(roomDto);
		}
		@PostMapping(value = "/save/category")
		public Category saveCategory(@RequestBody Category category) {

			return categoryRepository.save(category);
		}

	        @PutMapping(value = "/update/room")
		public String updateRoom(@RequestBody RoomDto roomDto) {


			return (roomServiceImpl.updateRoom(roomDto));
		}

		@PutMapping(value = "/update/category")
		public String updateCategory(@RequestBody Category category) {
			Optional<Category> existing = categoryRepository.findById(category.getId());
			if(existing.isPresent()){
				Category saved = categoryRepository.save(category);
				return (saved.getName());
			}
			return  ("Category not found");
		}
		
		@PostMapping(value = "/save/register")
		public String saveEmployee(@RequestBody RegisterDto registerDto) {
			
			return (registerServiceImpl.saveEmployee(registerDto));
		}
		
		@PostMapping(value = "/save/inventory")
		public String saveInventory(@RequestBody InventoryDto inventoryDto) {
			
			return (inventoryServiceImpl.saveInventory(inventoryDto));
		}
	    @PutMapping(value = "/update/inventory")
	    public String updateInventory(@RequestBody InventoryDto inventoryDto) {
	        Optional<InventoryDto> existing = Optional.ofNullable(inventoryServiceImpl.findById(inventoryDto.getId()));
	        if(existing.isPresent()){
	            String saved = inventoryServiceImpl.saveInventory(inventoryDto);
	            return (saved);
	        }
	        return("Category not found");
	    }
		
		@GetMapping(value="/search/rooms/{checkin}/{checkout}")
		public List<RoomDto> searchRooms(@PathVariable String checkin, @PathVariable String checkout) throws ParseException {
	   	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date requiredCheckin = simpleDateFormat.parse(checkin);
			Date requiredCheckout = simpleDateFormat.parse(checkout);
			return roomServiceImpl.searchRooms(requiredCheckin, requiredCheckout);
			
		}
		
		@GetMapping(value="/getAll/rooms")
	    public  List<RoomDto> getAllRooms(){
			return (roomServiceImpl.getAllRooms());
			
		}
		@GetMapping(value="/getAll/categories")
		public List<Category> getAllCategories(){
			return (categoryRepository.findAll()) ;

		}
		
		@GetMapping(value="/getAll/staff")
	    public List<StaffDto> getAllStaff(){
			return (staffServiceImpl.getAllStaff());
			
		}
		
		@GetMapping(value="/getstaff/byid/{id}")
	    public StaffDto findStaffById(@PathVariable String id){
			return (staffServiceImpl.findById(id));
			
		}
		
		@DeleteMapping(value="/deletestaff/byid/{id}")
	    public String deleteStaffById(@PathVariable String id){
			String success=staffServiceImpl.deleteStaffById(id);
			return (success);
			
		}
		@DeleteMapping(value="/deleteCategory/byid/{id}")
		public String deleteCategoryById(@PathVariable String id){
			categoryRepository.deleteById(id);
			return (id);

		}
		
		@GetMapping(value="/getroom/byid/{id}")
	    public RoomDto findRoomById(@PathVariable String id){
			return roomServiceImpl.findById(id);
			
		}
		
		@DeleteMapping(value="/deleteroom/byid/{id}")
	    public String deleteRoomById(@PathVariable String id){
			String success=roomServiceImpl.deleteRoomById(id);
			return success;
			
		}
		
		@GetMapping(value="/getAll/inventory")
	    public List<InventoryDto> getAllInventory(){
			return (inventoryServiceImpl.getAllInventory());
			
		}
		
		@GetMapping(value="/getinventory/byid/{id}")
	    public InventoryDto findInventoryById(@PathVariable String id){
			return inventoryServiceImpl.findById(id);
			
		}
		
		@DeleteMapping(value="/deleteinventory/byid/{id}")
	    public String deleteInventoryById(@PathVariable String id){
			String success=inventoryServiceImpl.deleteInventoryById(id);
			return (success);
			
		}

		@GetMapping(value="/getAll/registerd")
	    public List<RegisterDto> getAllRegistered(){
			return (registerServiceImpl.getAllRegistered());
			
		}
		
		@GetMapping(value="/getregistered/byid/{id}")
	    public RegisterDto findRegisterById(@PathVariable String id){
			return registerServiceImpl.findById(id);
			
		}
		
		@DeleteMapping(value="/deleteregistered/byid/{id}")
	    public String deleteRegisteredById(@PathVariable String id){
			String success=registerServiceImpl.deleteRegisterById(id);
			return (success);
			
		}
		@PostMapping(value="/check/validuser/{email}/{password}")
	    public RegisterDto findRegisterById(@PathVariable String email,@PathVariable String password){
			return (registerServiceImpl.findByEmailAndPassword(email, password));
			
		}
		
}

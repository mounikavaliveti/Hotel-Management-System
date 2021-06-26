package com.hotel.Operations;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hotel.operations.Dto.ReturnResponse;
import com.hotel.operations.Dto.RoomDto;
import com.hotel.operations.Dto.StaffDto;
import com.hotel.operations.Repository.CategoryRepository;
import com.hotel.operations.controller.Controller;
import com.hotel.operations.entityDao.Category;
import com.hotel.operations.service.RoomService;
import com.hotel.operations.service.StaffService;

@SpringBootTest
public class MicroServiceMasterApplicationTests {

    @InjectMocks
    Controller controller;

    @Mock
    StaffService staffServiceImpl;

    @Mock
    RoomService roomServiceImpl;

    @Mock
    CategoryRepository categoryRepository;

   
    @Test
    public void contextLoads() {
        Assert.assertEquals("Docker set up done!!",controller.testHm());
    }

    @Test
    public  void testSaveStaff(){
        Mockito.when(staffServiceImpl.saveStaff(Mockito.any())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity("Success", HttpStatus.OK),controller.saveStaff(Mockito.any()));
    }
    @Test
    public  void testSaveRoom(){
        Mockito.when(roomServiceImpl.saveRoom(Mockito.any())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity("Success", HttpStatus.OK),controller.saveRoom(Mockito.any()));
    }

    @Test
    public  void  testgetAllRooms(){
        RoomDto roomDto = new RoomDto();
        roomDto.setId("room");
        Mockito.when(roomServiceImpl.getAllRooms()).thenReturn(Stream.of(roomDto).collect(Collectors.toList()));

        Assert.assertNotNull(controller.getAllRooms());

    }

    @Test
    public void testGetAllCategories(){
        Category categoryDto = new Category();
        categoryDto.setId("123");
        Mockito.when(categoryRepository.findAll()).thenReturn(Stream.of(categoryDto).collect(Collectors.toList()));
        Assert.assertNotNull(controller.getAllCategories());
    }

    @Test
    public void testGetAllStaff(){
        StaffDto staffDto = new StaffDto();
        staffDto.setId("test");
        Mockito.when(staffServiceImpl.getAllStaff()).thenReturn(Stream.of(staffDto).collect(Collectors.toList()));
        Assert.assertEquals(new ResponseEntity(Stream.of(staffDto).collect(Collectors.toList()), HttpStatus.OK),controller.getAllStaff());
    }

    @Test
    public void testDeleteRoomById(){
        Mockito.when(roomServiceImpl.deleteRoomById(Mockito.anyString())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity(new ReturnResponse("Success"), HttpStatus.OK),
                controller.deleteRoomById(Mockito.anyString()));
    }
   
    @Test
    public void testDeleteStaffById(){
        Mockito.when(staffServiceImpl.deleteStaffById(Mockito.anyString())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity(new ReturnResponse("Success"), HttpStatus.OK),
                controller.deleteStaffById(Mockito.anyString()));
    }

    @Test void testUpdateRoom() {
        Mockito.when(roomServiceImpl.updateRoom(Mockito.any())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity(new ReturnResponse("Success"), HttpStatus.OK),
                controller.updateRoom(Mockito.any()));
    }
}

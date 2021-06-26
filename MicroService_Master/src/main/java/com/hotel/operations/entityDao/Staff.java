package com.hotel.operations.entityDao;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "staff")
public class Staff {

	@Id
	private String id;
	
    private String name;
	
	private String empId;

	private String role;
	
	private String email;
	
	private String contactNo;
	
	private String Salary;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date joinDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	public Staff() {}

	public Staff(String id, String name, String empId, String email, String contactNo, String salary, Date dob,
			Date joinDate, Date endDate, String role) {
		super();
		this.id = id;
		this.name = name;
		this.empId = empId;
		this.email = email;
		this.contactNo = contactNo;
		Salary = salary;
		this.dob = dob;
		this.joinDate = joinDate;
		this.endDate = endDate;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", empId=" + empId + ", email=" + email + ", contactNo="
				+ contactNo + ", Salary=" + Salary + ", dob=" + dob + ", joinDate=" + joinDate + ", endDate=" + endDate
				+ "]";
	}

		
}

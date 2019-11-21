package com.purchaseOrder.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tblUsers")
public class User {
	
	@Id
	private int User_Id;
	
	private String User_Name;

	private String Email;
	
	private String Password;
	
	private String Address;
	
	private int Mobile_no;
	
	private String IsActive;
	
	private LocalDate Created_date;
	
	private String Created_by;
	
	private String Update_by;
	
	private LocalDate Update_date;
	
	private String RoleId;

	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getMobile_no() {
		return Mobile_no;
	}

	public void setMobile_no(int mobile_no) {
		Mobile_no = mobile_no;
	}

	public String getIsActive() {
		return IsActive;
	}

	public void setIsActive(String isActive) {
		IsActive = isActive;
	}

	public LocalDate getCreated_date() {
		return Created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		Created_date = created_date;
	}

	public String getCreated_by() {
		return Created_by;
	}

	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}

	public String getUpdate_by() {
		return Update_by;
	}

	public void setUpdate_by(String update_by) {
		Update_by = update_by;
	}

	public LocalDate getUpdate_date() {
		return Update_date;
	}

	public void setUpdate_date(LocalDate update_date) {
		Update_date = update_date;
	}

	public String getRoleId() {
		return RoleId;
	}

	public void setRoleId(String roleId) {
		RoleId = roleId;
	}

	@Override
	public String toString() {
		return "User [User_Id=" + User_Id + ", User_Name=" + User_Name + ", Email=" + Email + ", Password=" + Password
				+ ", Address=" + Address + ", Mobile_no=" + Mobile_no + ", IsActive=" + IsActive + ", Created_date="
				+ Created_date + ", Created_by=" + Created_by + ", Update_by=" + Update_by + ", Update_date="
				+ Update_date + ", RoleId=" + RoleId + "]";
	}
	
		
}

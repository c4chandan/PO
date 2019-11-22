package com.purchaseOrder.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Buyer_table")
public class Buyer {

	@Id
	@GeneratedValue
	private int buyer_Id;
	
	private String buyer_Name;

	private String Email;

	private String Password;

	private String Address;

	private long Mobile_no;

	private String IsActive;

	private LocalDate Created_date;

	private String Created_by;

	private String Update_by;

	private LocalDate Update_date;
	
	private String Role;

	public int getBuyer_Id() {
		return buyer_Id;
	}

	public void setBuyer_Id(int buyer_Id) {
		this.buyer_Id = buyer_Id;
	}

	public String getBuyer_Name() {
		return buyer_Name;
	}

	public void setBuyer_Name(String buyer_Name) {
		this.buyer_Name = buyer_Name;
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

	public long getMobile_no() {
		return Mobile_no;
	}

	public void setMobile_no(long mobile_no) {
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

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "Buyer [buyer_Id=" + buyer_Id + ", buyer_Name=" + buyer_Name + ", Email=" + Email + ", Password="
				+ Password + ", Address=" + Address + ", Mobile_no=" + Mobile_no + ", IsActive=" + IsActive
				+ ", Created_date=" + Created_date + ", Created_by=" + Created_by + ", Update_by=" + Update_by
				+ ", Update_date=" + Update_date + ", Role=" + Role + "]";
	}
		
	
}
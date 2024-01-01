package com.asgprojects.bean;

public class User {
	int role;
	long aadhar;
	String password;
	String name;
	int age; 
	String state, district, city;
	int pincode;
	String gender;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int role, long aadhar, String password, String name, int age, String state, String district,
			String city, int pincode, String gender) {
		super();
		this.role = role;
		this.aadhar = aadhar;
		this.password = password;
		this.name = name;
		this.age = age;
		this.state = state;
		this.district = district;
		this.city = city;
		this.pincode = pincode;
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

package com.asgprojects.bean;

public class Job {

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public int getJob_salary() {
		return job_salary;
	}

	public void setJob_salary(int job_salary) {
		this.job_salary = job_salary;
	}

	public int getJob_exp() {
		return job_exp;
	}

	public void setJob_exp(int job_exp) {
		this.job_exp = job_exp;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getJob_desc() {
		return job_desc;
	}

	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}

	public String getJob_country() {
		return job_country;
	}

	public void setJob_country(String job_country) {
		this.job_country = job_country;
	}

	public String getJob_state() {
		return job_state;
	}

	public void setJob_state(String job_state) {
		this.job_state = job_state;
	}

	public String getJob_district() {
		return job_district;
	}

	public void setJob_district(String job_district) {
		this.job_district = job_district;
	}

	public String getJob_city() {
		return job_city;
	}

	public void setJob_city(String job_city) {
		this.job_city = job_city;
	}

	public String getJob_org() {
		return job_org;
	}

	public void setJob_org(String job_org) {
		this.job_org = job_org;
	}

	public String getJob_sector() {
		return job_sector;
	}

	public void setJob_sector(String job_sector) {
		this.job_sector = job_sector;
	}

	public String getJob_function() {
		return job_function;
	}

	public void setJob_function(String job_function) {
		this.job_function = job_function;
	}

	public Job(int job_id, int job_salary, int job_exp, String job_title, String job_desc, String job_country,
			String job_state, String job_district, String job_city, String job_org, String job_sector,
			String job_function) {
		super();
		this.job_id = job_id;
		this.job_salary = job_salary;
		this.job_exp = job_exp;
		this.job_title = job_title;
		this.job_desc = job_desc;
		this.job_country = job_country;
		this.job_state = job_state;
		this.job_district = job_district;
		this.job_city = job_city;
		this.job_org = job_org;
		this.job_sector = job_sector;
		this.job_function = job_function;
	}

	int job_id, job_salary, job_exp;
	String job_title, job_desc, job_country, job_state, job_district, job_city, job_org, job_sector, job_function; 
	
	public Job() {
		
	}

}

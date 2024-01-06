package com.asgprojects.bean;

public class Job {

	public Job(int jobId, int jobSalary, int jobExp, String jobTitle, String jobDesc, String jobState,
			String jobDistrict, String jobCity, String jobSector, String jobFunction) {
		super();
		this.jobId = jobId;
		this.jobSalary = jobSalary;
		this.jobExp = jobExp;
		this.jobTitle = jobTitle;
		this.jobDesc = jobDesc;
		this.jobState = jobState;
		this.jobDistrict = jobDistrict;
		this.jobCity = jobCity;
		this.jobSector = jobSector;
		this.jobFunction = jobFunction;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(int jobSalary) {
		this.jobSalary = jobSalary;
	}

	public int getJobExp() {
		return jobExp;
	}

	public void setJobExp(int jobExp) {
		this.jobExp = jobExp;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobState() {
		return jobState;
	}

	public void setJobState(String jobState) {
		this.jobState = jobState;
	}

	public String getJobDistrict() {
		return jobDistrict;
	}

	public void setJobDistrict(String jobDistrict) {
		this.jobDistrict = jobDistrict;
	}

	public String getJobCity() {
		return jobCity;
	}

	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}

	public String getJobSector() {
		return jobSector;
	}

	public void setJobSector(String jobSector) {
		this.jobSector = jobSector;
	}

	public String getJobFunction() {
		return jobFunction;
	}

	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}

	int jobId, jobSalary, jobExp;
	String jobTitle, jobDesc, jobState, jobDistrict, jobCity, jobSector, jobFunction;
	
	public Job() {
		
	}

}

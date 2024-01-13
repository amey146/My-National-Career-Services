package com.asgprojects.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.asgprojects.bean.DatabaseConnection;
import com.asgprojects.bean.Job;

public class JobGov implements Job_Dao {

	public JobGov() {

	}

	public static int save(Job j) {
		int status = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"INSERT INTO gov_jobs (jobId, jobTitle, jobDesc, jobSalary, jobState, jobDistrict, jobCity, jobSector, jobFunction, jobExp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
					ps.setInt(1, j.getJobId()); // Change to getJobId()
					ps.setString(2, j.getJobTitle()); // Change to getJobTitle()
					ps.setString(3, j.getJobDesc()); // Change to getJobDesc()
					ps.setInt(4, j.getJobSalary()); // Assuming jobSalary is a String, if it's an int, adjust
													// accordingly
					ps.setString(5, j.getJobState()); // Change to getJobState()
					ps.setString(6, j.getJobDistrict()); // Change to getJobDistrict()
					ps.setString(7, j.getJobCity()); // Change to getJobCity()
					ps.setString(8, j.getJobSector()); // Change to getJobSector()
					ps.setString(9, j.getJobFunction()); // Change to getJobFunction()
					ps.setInt(10, j.getJobExp()); // Change to getJobExp()
					status = ps.executeUpdate();
					
					ps.close();
					con.close();
				}
			} else {
				System.out.println("Error: Unable to establish a database connection");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}

package com.asgprojects.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.asgprojects.bean.DatabaseConnection;
import com.asgprojects.bean.Job;

public class JobPriv implements Job_Dao {

	public JobPriv() {
		// TODO Auto-generated constructor stub
	}

	public static int save(Job j) {
		int status = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"INSERT INTO priv_jobs (jobId, jobTitle, jobDesc, jobSalary, jobState, jobDistrict, jobCity, jobSector, jobFunction, jobExp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
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
	
	public static List<Job> getAllRecords(){  
	    List<Job> list=new ArrayList<Job>();  
	      
	    try{  
	        Connection con= DatabaseConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from register");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Job j=new Job();  
	        	
	        	// Assuming these methods exist in your Job class
	        	j.setJobId(rs.getInt("jobId"));
	        	j.setJobTitle(rs.getString("jobTitle"));
	        	j.setJobDesc(rs.getString("jobDesc"));
	        	j.setJobSalary(rs.getInt("jobSalary")); // Assuming jobSalary is an int, adjust accordingly
	        	j.setJobState(rs.getString("jobState"));
	        	j.setJobDistrict(rs.getString("jobDistrict"));
	        	j.setJobCity(rs.getString("jobCity"));
	        	j.setJobSector(rs.getString("jobSector"));
	        	j.setJobFunction(rs.getString("jobFunction"));
	        	j.setJobExp(rs.getInt("jobExp")); 
	           
	            list.add(j);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
}

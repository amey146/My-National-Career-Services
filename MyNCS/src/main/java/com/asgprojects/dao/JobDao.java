package com.asgprojects.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.asgprojects.bean.DatabaseConnection;
import com.asgprojects.bean.Job;

public class JobDao {

	public static int save(Job j) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            if (con != null) {
                try (PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO users (job_id, job_title, job_desc, job_country, job_state, job_district, job_salary, job_exp, job_org, job_sector, job_function, job_city) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                    ps.setInt(1, j.getJob_id());
                    ps.setString(2, j.getJob_title());
                    ps.setString(3, j.getJob_desc());
                    ps.setString(4, j.getJob_country());
                    ps.setString(5, j.getJob_state());
                    ps.setString(6, j.getJob_district());
                    ps.setInt(7, j.getJob_salary());
                    ps.setInt(8, j.getJob_exp());
                    ps.setString(9, j.getJob_org());
                    ps.setString(10, j.getJob_sector());
                    ps.setString(11, j.getJob_function());
                    ps.setString(12, j.getJob_city());
                    
                    status = ps.executeUpdate();
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

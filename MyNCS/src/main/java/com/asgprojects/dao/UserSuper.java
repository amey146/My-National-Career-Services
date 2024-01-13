package com.asgprojects.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicInteger;

import com.asgprojects.bean.DatabaseConnection;
import com.asgprojects.bean.User;

public class UserSuper implements User_Dao {

	public UserSuper() {
		// TODO Auto-generated constructor stub
	}
	private static final AtomicInteger counter = new AtomicInteger(
            (int) (System.currentTimeMillis() % Integer.MAX_VALUE) // Initialize with unique base
    );
	public static int save(User u) {
		int status = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"INSERT INTO SUPER_USER (uid, password, name, age, state, district, city, pincode, gender, empid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
					ps.setLong(1, u.getAadhar());
					ps.setString(2, u.getPassword());
					ps.setString(3, u.getName());
					ps.setInt(4, u.getAge());
					ps.setString(5, u.getState());
					ps.setString(6, u.getDistrict());
					ps.setString(7, u.getCity());
					ps.setInt(8, u.getPincode());
					ps.setString(9, u.getGender());
					ps.setString(10, "EMP"+counter.incrementAndGet());
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

	public static User getRecordById(long uid) {
		User u = null;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from SUPER_USER where uid=?");
			ps.setLong(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setAadhar(rs.getLong("uid"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setRole(1);
				u.setAge(rs.getInt("age"));
				u.setGender(rs.getString("gender"));
				u.setState(rs.getString("state"));
				u.setDistrict(rs.getString("district"));
				u.setCity(rs.getString("city"));
				u.setPincode(rs.getInt("pincode"));
				u.setEmpIdForSUser(rs.getString("empid"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}

}

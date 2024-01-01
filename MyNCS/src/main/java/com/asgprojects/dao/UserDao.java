package com.asgprojects.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.asgprojects.bean.DatabaseConnection;
import com.asgprojects.bean.User;

public class UserDao {

    public static int save(User u) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            if (con != null) {
                try (PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO users (uid, password, name, role, age, state, district, city, pincode, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                    ps.setLong(1, u.getAadhar());
                    ps.setString(2, u.getPassword());
                    System.out.println("OK TILL HERE");
                    ps.setString(3, u.getName());
                    ps.setLong(4, u.getRole());
                    ps.setLong(5, u.getAge());
                    ps.setString(6, u.getState());
                    ps.setString(7, u.getDistrict());
                    ps.setString(8, u.getCity());
                    ps.setLong(9, u.getPincode());
                    ps.setString(10, u.getGender());
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

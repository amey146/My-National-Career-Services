package com.asgprojects.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                    ps.setString(3, u.getName());
                    ps.setInt(4, u.getRole());
                    ps.setInt(5, u.getAge());
                    ps.setString(6, u.getState());
                    ps.setString(7, u.getDistrict());
                    ps.setString(8, u.getCity());
                    ps.setInt(9, u.getPincode());
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
    
    public static User getRecordById(long uid){  
        User u=null;  
        try{  
            Connection con= DatabaseConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from users where uid=?");  
            ps.setLong(1,uid);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                u=new User();  
                u.setAadhar(rs.getLong("uid"));  
                u.setName(rs.getString("name"));  
                u.setPassword(rs.getString("password"));  
                u.setRole(rs.getInt("role"));  
                u.setAge(rs.getInt("age"));
                u.setGender(rs.getString("gender"));
                u.setState(rs.getString("state"));
                u.setDistrict(rs.getString("district"));
                u.setCity(rs.getString("city"));
                u.setPincode(rs.getInt("pincode"));
            }  
        }catch(Exception e){System.out.println(e);}  
        return u;  
    }  
}

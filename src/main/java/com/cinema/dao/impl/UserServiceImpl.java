package com.cinema.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cinema.dao.UserService;
import com.cinema.entities.User;

public class UserServiceImpl implements UserService{
	
	private Connection con;
	
	public UserServiceImpl(Connection con) {
		super();
		this.con = con;
	}



	@Override
	public Boolean userRegister(User user) {
		Boolean f = false;
		
		try {
			
			String query = "insert into user(name,email,phone,password,role) values(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getRole());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}



	@Override
	public Boolean checkUser(String email) {
		Boolean f = true;
		
		try {
			
			String query = "select * from user where email = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				f = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}



	@Override
	public User login(String email, String password) {
		User user = null;
		
		try {
			
			String query = "select * from user where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setRole(rs.getString(6));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	@Override
	public User getUserById(int id) {
		User user = null;

		try {

			String sql = "select * from user where id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setRole(rs.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}


}

package com.comp1.dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.comp1.util.DBUtil;

public  class UserDaoImpl implements UserDao {

	@Override
	public boolean issValidUser(String username, String password) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM my WHERE username = ? AND password = ?";
   	 try (Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

           preparedStatement.setString(1, username);
           preparedStatement.setString(2, password);

           ResultSet resultSet = preparedStatement.executeQuery();

           return resultSet.next();
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
   }

	@Override
	public boolean addUser(User user) {
		 String query = "INSERT INTO my (username, email, password) VALUES (?, ?, ?)";

	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());

	            int rowsAffected = preparedStatement.executeUpdate();

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	}
	}
}

	



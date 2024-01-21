package com.comp1.dao1;

public interface UserDao {

	boolean issValidUser(String username, String password);

	boolean addUser(User user);

}

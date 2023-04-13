package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.User;

public interface UserDao {
	
	public User saveUser(User user);
	public boolean deleteUser(int uId);
	public User getUserById(int uId);
	public User updateUserById(int uId, User user);
	public List<User> getAllUsers();
	public List<User> getUserByRole(String role);

}

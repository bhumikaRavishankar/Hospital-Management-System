package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.UserDaoImp;
import com.ty.hospital_app.dto.User;

public class UserService {
	
	public void saveUser(User user)
	{
		UserDaoImp userdaoimp = new UserDaoImp();
		User user1 = userdaoimp.saveUser(user);
		if(user1!=null)
		{
			System.out.println("User saved");
		}
		else {
			System.out.println("Unfortunatly user not saved");
		}
	}
	public User getUserId(int uId) 
	{
		UserDaoImp userdaoimp = new UserDaoImp();
		User user = userdaoimp.getUserById(uId);
		if(user!=null)
		{
			return user;
		}
		else {
			return null;
		}
	}
	public void deleteUserId(int uId) 
	{
		UserDaoImp userdaoimp = new UserDaoImp();
		User user = userdaoimp.getUserById(uId);
		boolean flag = userdaoimp.deleteUser(uId);
		if(flag)
		{
			System.out.println("User deleted");
		}
		else {
			System.out.println("User not found");
		}
	}
	public User updateUser(int uId, User user)
	{
		UserDaoImp userdaoimp = new UserDaoImp();
		User user2 = userdaoimp.updateUserById(uId, user);
		if(user2 != null)
		{
			return user2;
		}
		else {
			return null;
		}
	}
	
}

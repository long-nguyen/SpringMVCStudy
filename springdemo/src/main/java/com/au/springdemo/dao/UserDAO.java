package com.au.springdemo.dao;

import java.util.List;

import com.au.springdemo.model.User;

public interface UserDAO {
	public void addUser(User p);

	public void updateUser(User p);

	public List<User> listUser();

	public User getUserById(int id);

	public void removeUser(int id);
}

package co.au.vog.dao;

import java.util.List;

import co.au.vog.model.entity.User;

public interface UserDAO {
	public void addUser(User p);

	public void updateUser(User p);

	public List<User> listUser();

	public User getUserById(int id);

	public void removeUser(int id);
}

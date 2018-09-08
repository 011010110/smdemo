package org.jiang.mapper;

import java.util.List;

import org.jiang.user.entity.User;

public interface UserMapper {

	public User getUserById(String id);
	
	public List<User> findUserList();
	
	public int updateUser(User user);
	
	public int insertUser(User user);
	
	public int deleteUserById(String id);
	
}

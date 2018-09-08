package org.jiang.user.service;

import java.util.List;

import org.jiang.mapper.UserMapper;
import org.jiang.role.entity.Role;
import org.jiang.role.service.RoleService;
import org.jiang.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleService roleService;

	public User getUserById(String id) {
		return userMapper.getUserById(id);
	}

	public List<User> findUserList() {
		return userMapper.findUserList();
	}

	public boolean updateUser(User user) {
		return userMapper.updateUser(user) > 0;
	}
	
	@Transactional
	public boolean updateUserAndRole(User user,Role role) {
		boolean userResult = this.updateUser(user);
//		int m = 1/0;
		boolean roleResult = roleService.updateRole(role);
	    return userResult&&roleResult;
	}
}

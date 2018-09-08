package org.jiang.role.service;

import java.util.List;

import org.jiang.mapper.RoleMapper;
import org.jiang.role.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public Role getRoleById(String id) {
		return roleMapper.getRoleById(id);
	}
	
	public List<Role> getRoleList(){
		return roleMapper.getRoleList();
	}
	
	public boolean insertRole(Role role) {
		return roleMapper.insertRole(role)>0;
	}
	
	public boolean updateRole(Role role) {
		return roleMapper.updateRole(role)>0;
	}
	
	public boolean deleteRoleById(String id) {
		return roleMapper.deleteRoleById(id)>0;
	}
}

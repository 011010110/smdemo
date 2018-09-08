package org.jiang.mapper;

import java.util.List;

import org.jiang.role.entity.Role;

public interface RoleMapper {

	
	
	public Role getRoleById(String id);
	
	public List<Role> getRoleList();
	
	public int insertRole(Role role);
	
	public int updateRole(Role role);
	
	public int deleteRoleById(String id);
}
